package com.xz.spider.bilibili.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.StandardSocketFactory;
import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Output;
import com.xz.spider.bilibili.vo.Archive;
import com.xz.spider.bilibili.vo.UPer;

public class ConnectUtil {
	public static Document getDocument(String url){
		System.out.println(url);
		Connection connection = Jsoup.connect(url);
		Document document = null;
		try {
			connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
			document = connection.ignoreContentType(true).timeout(10000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return document;
	}
	
	public static Response getResponse(String url){
		Connection connection = Jsoup.connect(url);
		Response response = null;
		try {
			connection.header("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
			response = connection.ignoreContentType(true).timeout(10000).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return response;
		
	}
	
	public static CloseableHttpResponse doGet(String href){
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(href);
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; MALC)");
        try {
            return closeableHttpClient.execute(httpGet);
        } catch (IOException e) {
            return doGet(href);
        }
    }
	
	public static <T>T downLoadDanmu(String href,String aid, String path){
        SAXReader saxReader=new SAXReader();
        InputStreamReader in= null;
        HttpEntity httpEntity=null;
        try {
            httpEntity = ConnectUtil.doGet(href).getEntity();
            in = new InputStreamReader(httpEntity.getContent(),"utf-8");
            if(href.contains("rolldate")) {
                ObjectMapper objectMapper=new ObjectMapper();
                JsonNode jsonNode=objectMapper.readTree(in);
                return (T)jsonNode;
            }else {
				FileUtil.writeFile(aid+".xml", in, path);
			
            	org.dom4j.Element root = saxReader.read(in).getRootElement();
                if(root.element("source")!=null&&root.element("source").getText().equals("e-r")){
                    return null;
                }else{
                    return (T)root;
                }
            }
        } catch (IOException e) {
        } catch (DocumentException e) {
        }finally {
//            try {
//                EntityUtils.consume(httpEntity);
//            } catch (IOException e) {
//                LogUtil.getLogger().error(String.valueOf(e));
//            }

        }
        return null;
    }
	
	/**
	 * 抓取1.view(观看次数)、danmaku(总弹幕数)、reply(弹幕数)、his_rank(最高全站日排行)、favorite(收藏人数)、coin(硬币数)、share(分享数)
	 */
	public static Archive spiderArchive(String aid){
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
		Response response = getResponse("https://api.bilibili.com/x/web-interface/archive/stat?callback=jQuery17208549602856317029_1502097590081&aid="+aid+"&jsonp=jsonp&_=1502097590829");

		String json = regxJson(response.body());
		//System.out.println(json);
		JSONObject jsonObject = JSONObject.parseObject(json);
		Archive archive = JSONObject.parseObject(jsonObject.get("data").toString(),Archive.class);
		System.out.println(archive);
		return archive;
	}
	
	/**
	 * 获取详情页
	 */
	public static Document getDetail(String url){
		Document document = getDocument(url);
		
		return document;
		}
	
	/**
	 * 提取cid
	 */
	public static String getCid(Document document){

		Element e = document.body();
		String cid = null;
		Elements es = e.select("script");
		for (int i = 0; i < es.size(); i++) {
			String a = es.html();
			if (!a.contains("EmbedPlayer(")) {
				continue;
			}
			cid = a.substring(a.indexOf("cid=")+4, a.indexOf("&aid"));
		}
		//System.out.println(cid);
		return cid;
	}
	
	/**
	 * 根据cid获取弹幕页面
	 */
	public static void getBarrage(String cid, String aid, String path) throws IOException{

		ConnectUtil.downLoadDanmu("https://comment.bilibili.com/"+cid+".xml", aid, path);
	}
	//将一个字符串中的json剥离
	public static String regxJson(String exJson){
		String json = null;
		if(exJson.indexOf("({")>-1){
			json = exJson.substring(exJson.indexOf("(")+1,exJson.lastIndexOf(")"));
		}else{
			json = exJson;
		}
		
		return json;
	}
	
	/**
	 * 获取mid
	 */
	public static String getMid(Document document){
		String mid = null;
		mid = document.select(".upinfo>.u-face>a").attr("mid");
		
		return mid;
	}
	
	/**
	 * 获取up主信息
	 * @param mid
	 * @return
	 */
	public static UPer getUPer(String mid){
		Response response = getResponse(ApiUrl.UPer.getUrl(mid));
		String json = response.body();
		System.out.println(json);
		JSONObject obj = JSONObject.parseObject(json);
		UPer up = null;
		if(obj.containsKey("data")){
			System.out.println(obj.get("data").toString());
			JSONObject obj1 = JSONObject.parseObject(obj.get("data").toString());
			up = JSONObject.parseObject(obj1.get("card").toString(),UPer.class);
		}
		return up;
	}
	
	/**
	 * 获取回复数
	 * @param mid
	 * @return
	 */
	public static String getReply(String oid){
		Response response = getResponse(ApiUrl.Reply.getUrl(oid));
		String json = response.body();
		System.out.println(json);
		JSONObject obj = JSONObject.parseObject(json);
		String reply = null;
		UPer up = null;
		if(obj.containsKey("data")){
			JSONObject obj1 = JSONObject.parseObject(obj.get("data").toString());
			JSONObject obj2 = JSONObject.parseObject(obj1.get("page").toString());
			reply = obj2.get("acount").toString();
		}
		return reply;
	}
	
}
