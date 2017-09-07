package com.xz.spider.bilibili.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "constant")
@PropertySource("classpath:constant.properties")
public class Constant {
	
	private String barrage;

	public String getBarrage() {
		return barrage;
	}

	public void setBarrage(String barrage) {
		this.barrage = barrage;
	}

	@Override
	public String toString() {
		return "Constant [barrage=" + barrage + "]";
	}

	
	
}
