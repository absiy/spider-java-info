package com.xz.spider.bilibili.controller;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.spider.bilibili.util.ConnectUtil;
import com.xz.spider.bilibili.util.Constant;
import com.xz.spider.bilibili.vo.Archive;
import com.xz.spider.bilibili.vo.UPer;
@RestController
public class SpiderController {
	
	@Autowired
	Constant constant;
	
	@RequestMapping(value = "/test/1", method = RequestMethod.GET)
	public String getVideo(String url){
//		Connection connection = Jsoup.connect();
//		connection.header("(Request-Line)", "POST /cgi-bin/login?lang=zh_CN HTTP/1.1");
//		connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
//		connection.header("Accept-Encoding", "gzip, deflate");
//		connection.header("Accept-Language", "zh-cn");
//		connection.header("Cache-Control", "no-cache");
//		connection.header("Connection", "Keep-Alive");
//		connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//		connection.header("Host", "mp.weixin.qq.com");
//		connection.header("Referer", "https://news.qq.com/");
//		connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
		Document document = ConnectUtil.getDocument("https://search.bilibili.com/all?keyword=%E5%A6%96%E7%8E%8B&page=1&order=totalrank");
		//获取列表页所有元素
		Element e = document.body();
		Elements es = e.select(".video.matrix");
		for (int i = 0; i < es.size(); i++) {
			//遍历获取列表页每一个元素
			Elements eidArray = es.get(i).select(".search-watch-later.icon-later-off");
			Element eid = eidArray.first();
			
			//获取视频的播放时长
			Elements etimeArray = es.get(i).select(".so-imgTag_rb");
			Element etime = etimeArray.first();
			String time = etime.text();
			System.out.println(time);
			
			//获取视频的aid
			String aid = eid.attr("data-aid");
			//根据视频aid获取视频的部分信息
			Archive archive = ConnectUtil.spiderArchive(aid);

			//抓取观看链接
 			Elements eurlArray = es.get(i).select("a[lnk-type=\"video\"]");
			Element eurl = eurlArray.first();
			//视频播放页链接
			String watchUrl = eurl.attr("href");
			
			//获取播放详情页的dom树
			Document detail = ConnectUtil.getDetail("https:"+watchUrl);
			//cid(弹幕id)
			String cid = ConnectUtil.getCid(detail);
			//mid(up主id)
			String mid = ConnectUtil.getMid(detail);
			UPer up = ConnectUtil.getUPer(mid);
			
			System.out.println(cid+"----"+mid);
			try {
				//爬取弹幕xml,保存在本地
				ConnectUtil.getBarrage(cid, aid, constant.getBarrage());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//回复数
			String reply = ConnectUtil.getReply(aid);
		}
		return "1";
	}
	
	
	
}
