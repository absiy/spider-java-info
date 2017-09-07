package com.xz.spider.bilibili.util;


public enum ApiUrl {
	
	danMu("http://comment.bilibili.com/{0}.xml"),
	
	UPer("https://api.bilibili.com/cardrich?&mid={0}"),
	
	Reply("https://api.bilibili.com/x/v2/reply?&type=1&oid={0}");
	
	private final String url;

    private final String url1;

    private int index;

    ApiUrl(String url) {
        this.url=url;
        url1 = null;
    }

    public ApiUrl s(int index) {
        this.index = index;
        return this;
    }

    ApiUrl(String url, String url1) {
        this.url = url;
        this.url1 = url1;
    }

    public String getUrl(){
        switch (this.index){
            case 2:return this.url1;
            case 1:
            default:return this.url;
        }
    }

    public String getUrl(Object ...obj){
        String buildUrl=getUrl();
        if(buildUrl==null){
            return null;
        }
        for(int j=0;j<obj.length;j++){
            buildUrl=buildUrl.replace("{"+j+"}",obj[j].toString());
        }
        return buildUrl;
    }


}
