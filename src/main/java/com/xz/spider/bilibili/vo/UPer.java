package com.xz.spider.bilibili.vo;

import java.util.List;
import java.util.Map;

public class UPer {
	private String mid;
	private String name;
	private String approve;
	private String sex;
	private String rank;
	private String face;
	private String DisplayRank;
	private String regtime;
	private String spacesta;
	private String birthday;
	private String place;
	private String description;
	private String article;
	private List<String> attentions;
	private String fans;
	private String friend;
	private String attention;
	private String sign;
	private Map<String,String> level_info;
	private Map<String,String> pendant;
	private Map<String,String> nameplate;
	private Map<String,String> official_verify;
	private Map<String,String> vip;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public String getDisplayRank() {
		return DisplayRank;
	}
	public void setDisplayRank(String displayRank) {
		DisplayRank = displayRank;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public String getSpacesta() {
		return spacesta;
	}
	public void setSpacesta(String spacesta) {
		this.spacesta = spacesta;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public List<String> getAttentions() {
		return attentions;
	}
	public void setAttentions(List<String> attentions) {
		this.attentions = attentions;
	}
	public String getFans() {
		return fans;
	}
	public void setFans(String fans) {
		this.fans = fans;
	}
	public String getFriend() {
		return friend;
	}
	public void setFriend(String friend) {
		this.friend = friend;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Map<String, String> getLevel_info() {
		return level_info;
	}
	public void setLevel_info(Map<String, String> level_info) {
		this.level_info = level_info;
	}
	public Map<String, String> getPendant() {
		return pendant;
	}
	public void setPendant(Map<String, String> pendant) {
		this.pendant = pendant;
	}
	public Map<String, String> getNameplate() {
		return nameplate;
	}
	public void setNameplate(Map<String, String> nameplate) {
		this.nameplate = nameplate;
	}
	public Map<String, String> getOfficial_verify() {
		return official_verify;
	}
	public void setOfficial_verify(Map<String, String> official_verify) {
		this.official_verify = official_verify;
	}
	public Map<String, String> getVip() {
		return vip;
	}
	public void setVip(Map<String, String> vip) {
		this.vip = vip;
	}
	@Override
	public String toString() {
		return "UPer [mid=" + mid + ", name=" + name + ", approve=" + approve + ", sex=" + sex + ", rank=" + rank
				+ ", face=" + face + ", DisplayRank=" + DisplayRank + ", regtime=" + regtime + ", spacesta=" + spacesta
				+ ", birthday=" + birthday + ", place=" + place + ", description=" + description + ", article="
				+ article + ", attentions=" + attentions + ", fans=" + fans + ", friend=" + friend + ", attention="
				+ attention + ", sign=" + sign + ", level_info=" + level_info + ", pendant=" + pendant + ", nameplate="
				+ nameplate + ", official_verify=" + official_verify + ", vip=" + vip + "]";
	}
	
}
