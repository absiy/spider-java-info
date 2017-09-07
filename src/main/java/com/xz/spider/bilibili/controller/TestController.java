package com.xz.spider.bilibili.controller;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xz.spider.bilibili.dao.DoubanDao;
import com.xz.spider.bilibili.dao.VideoDao;
import com.xz.spider.bilibili.pojo.Douban;
import com.xz.spider.bilibili.pojo.Video;
import com.xz.spider.bilibili.util.ConnectUtil;
import com.xz.spider.bilibili.util.Constant;
import com.xz.spider.bilibili.util.StringZlibUtil;
import com.xz.spider.bilibili.vo.UPer;
@RestController
public class TestController {
	
			@Autowired
			Constant constant;
			@Autowired
			VideoDao videoDao;
			@Autowired
			DoubanDao doubanDao;
			/**
			 * 根据cid获取弹幕页面
			 */
			@RequestMapping(value = "/tests/1", method = RequestMethod.GET)
			public void getBarrage(String cid,String aid) throws IOException{
		//		Connection connection = Jsoup.connect("https://comment.bilibili.com/"+cid+".xml");
				/*String xml = response.body();
				FileDownload fileDownload = new FileDownload();
				fileDownload.savePic(xml, aid);*/
				/*Document doc=Jsoup.parse(new URL("https://comment.bilibili.com/"+cid+".xml"), 10000);
				FileDownload fileDownload = new FileDownload();
				fileDownload.savePic(doc.body().text(), aid);*/
				
				Connection connection = Jsoup.connect("https://comment.bilibili.com/21692199.xml");
				connection.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				connection.header("Accept-Encoding", "gzip, deflate, sdch, br");
				connection.header("Accept-Language", "zh-CN,zh;q=0.8");
				connection.header("Cache-Control", "max-age=0");
				connection.header("Connection", "Keep-Alive");
				connection.header("Host", "comment.bilibili.com");
				connection.header("Upgrade-Insecure-Requests","1");
				connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
				Response response = null;
				response = connection.timeout(10000).execute();
				System.out.println(response.charset());
				System.out.println(response.body());
				byte[] decStr=Base64.decodeBase64(response.body()); 
				byte[] decode_str;
				try {
					decode_str = StringZlibUtil.zlibInfCompress(decStr, "UTF-8");
					String decStrOgr=new String(decode_str,"UTF-8");  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				/*String url = "https://comment.bilibili.com/21692199.xml";
				FileDownload.DownLoadPages(url, "D:/upload/2345.xml");*/
				
				/*Document document = Jsoup.parse(new URL(url).openStream(),"UTF-8",url);*/
				
			}
			@RequestMapping("/test/2")
			public String test(){
				System.out.println("----"+constant.getBarrage());
				return constant.getBarrage();
			}
			
			@RequestMapping("/test/3")
			public UPer test1(){
				UPer u = ConnectUtil.getUPer("3334179");
				
				
				return u;
			}
			
			@RequestMapping("/test/4")
			public Video test2(){
				//String u = ConnectUtil.getReply("4964006");
				Video v = videoDao.selectByPrimaryKey("1");
				
				return v;
			}
			
			@RequestMapping("/test/5")
			public String test5() throws IOException{
				Integer p;
				//建立连接
				for (int i = 0; i < 100; i++) {
					p = 1;
					if (i>0) {
						p = i*25;
					}
					System.out.println("第"+(i+1)+"页");
					Connection connection = Jsoup.connect("https://www.douban.com/group/145219/discussion?start="+p);
					connection.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
					connection.header("Accept-Encoding", "gzip, deflate, sdch, br");
					connection.header("Accept-Language", "zh-CN,zh;q=0.8");
					connection.header("Cache-Control", "max-age=0");
					connection.header("Connection", "Keep-Alive");
					connection.header("Host", "comment.bilibili.com");
					connection.header("Upgrade-Insecure-Requests","1");
					connection.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
					Document d = connection.timeout(10000).ignoreContentType(true).get();
					Elements es = d.select("a[title]");
					for (Element element : es) {
						String title = element.attr("title");
						String url = element.attr("href");
						Douban douban = new Douban();
						if (title.contains("东站")||title.contains("彭埠")||title.contains("新和嘉苑")||title.contains("明月嘉苑")
								||title.contains("云河家园")||title.contains("钱江府")||title.contains("云峰家园")||title.contains("三堡东苑")||title.contains("运新花苑")
								||title.contains("东方御府")) {
							douban.setTitle(title);
							douban.setUrl(url);
							doubanDao.insert(douban);
						}
					}
					//System.out.println(d.body());
				}
				
				
				
				return null;
			}
			
}
