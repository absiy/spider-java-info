package com.xz.spider.bilibili.controller;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
@RestController
public class SpiderController {
		@RequestMapping(value = "/test/1", method = RequestMethod.GET)
		public String getVideo(String url){
			Connection connection = Jsoup.connect("https://search.bilibili.com/all?keyword=%E5%A6%96%E7%8E%8B&page=1&order=totalrank");
			connection.header("(Request-Line)", "POST /cgi-bin/login?lang=zh_CN HTTP/1.1");
			connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
			connection.header("Accept-Encoding", "gzip, deflate");
			connection.header("Accept-Language", "zh-cn");
			connection.header("Cache-Control", "no-cache");
			connection.header("Connection", "Keep-Alive");
			connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.header("Host", "mp.weixin.qq.com");
			connection.header("Referer", "https://news.qq.com/");
			connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
			Document document = null;
			try {
				document =  connection.timeout(10000).get();
				
				//System.out.println(document.body());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Element e = document.body();
			Elements eids = e.select(".search-watch-later.icon-later-off");
			for (int i = 0; i < eids.size(); i++) {
				Element eid = eids.get(i);
				String s = eid.attr("data-aid");
				getPage(s);
				
				//System.out.println(s);
			}
			//JSONObject json = JSONObject.parseObject(body.text());
			return "1";
		}
		public int getPage(String s){
			Connection connection = Jsoup.connect("https://api.bilibili.com/x/web-interface/archive/stat?callback=jQuery17208549602856317029_1502097590081&aid="+s+"&jsonp=jsonp&_=1502097590829");
			connection.header("(Request-Line)", "POST /cgi-bin/login?lang=zh_CN HTTP/1.1");
			connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
			connection.header("Accept-Encoding", "gzip, deflate");
			connection.header("Accept-Language", "zh-cn");
			connection.header("Cache-Control", "no-cache");
			connection.header("Connection", "Keep-Alive");
			connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.header("Host", "mp.weixin.qq.com");
			connection.header("Referer", "https://news.qq.com/");
			connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
			Response response = null;
			try {
				response =  connection.timeout(10000).ignoreContentType(true).execute();
				
				System.out.println(response.body());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//JSONObject json = JSONObject.parseObject(body.text());
			return 1;
		}
	
	
		//抓取1.view(观看次数)、danmaku(总弹幕数)、reply(弹幕数)、his_rank(最高全站日排行)、favorite(收藏人数)、coin(硬币数)、share(分享数)
		public String spiderOne(String aid){
			Connection connection = Jsoup.connect("https://api.bilibili.com/x/web-interface/archive/stat?callback=jQuery17208549602856317029_1502097590081&aid="+aid+"&jsonp=jsonp&_=1502097590829");
			connection.header("(Request-Line)", "POST /cgi-bin/login?lang=zh_CN HTTP/1.1");
			connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
			connection.header("Accept-Encoding", "gzip, deflate");
			connection.header("Accept-Language", "zh-cn");
			connection.header("Cache-Control", "no-cache");
			connection.header("Connection", "Keep-Alive");
			connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.header("Host", "mp.weixin.qq.com");
			connection.header("Referer", "https://news.qq.com/");
			connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
			Response response = null;
			try {
				response = connection.timeout(10000).ignoreContentType(true).execute();
				
				//System.out.println(document.body());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String json = regxJson(response.body());
			System.out.println(json);
			JSONObject jsonObject = JSONObject.parseObject(json);
			
			
			return json;
		}
		
		
		//将一个字符串中的json剥离
		public String regxJson(String exJson){
			String json = null;
			if(exJson.indexOf("({")>-1){
				json = exJson.substring(exJson.indexOf("(")+1,exJson.lastIndexOf(")"));
			}else{
				json = exJson;
			}
			
			return json;
		}
}
