package com.xz.spider.bilibili.pojo;

import java.io.Serializable;
import java.util.Date;

public class Video implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String aid;
	//名称
	private String name;
	//播放量
	private Integer playCount;
	//播放排名
	private Integer playRank;
	//日期
	private Date date;
	//弹幕数
	private Integer barrageCount;
	//弹幕排名
	private Integer barrageRank;
	//评论数
	private Integer replyCount;
	//评论数排名
	private Integer replyRank;
	//硬币
	private Integer coinCount;
	//收藏
	private Integer collectionCount;
	//分享
	private Integer shareCount;
	//分享排名
	private Integer shareRank;
	//up主
	private String upName;
	//粉丝数
	private Integer fansCount;
	//类别
	private String type;
	//时长
	private String duration;
	//链接
	private String url;
	
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPlayCount() {
		return playCount;
	}
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}
	public Integer getPlayRank() {
		return playRank;
	}
	public void setPlayRank(Integer playRank) {
		this.playRank = playRank;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getBarrageCount() {
		return barrageCount;
	}
	public void setBarrageCount(Integer barrageCount) {
		this.barrageCount = barrageCount;
	}
	public Integer getBarrageRank() {
		return barrageRank;
	}
	public void setBarrageRank(Integer barrageRank) {
		this.barrageRank = barrageRank;
	}
	public Integer getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	public Integer getReplyRank() {
		return replyRank;
	}
	public void setReplyRank(Integer replyRank) {
		this.replyRank = replyRank;
	}
	public Integer getCoinCount() {
		return coinCount;
	}
	public void setCoinCount(Integer coinCount) {
		this.coinCount = coinCount;
	}
	public Integer getCollectionCount() {
		return collectionCount;
	}
	public void setCollectionCount(Integer collectionCount) {
		this.collectionCount = collectionCount;
	}
	public Integer getShareCount() {
		return shareCount;
	}
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}
	public Integer getShareRank() {
		return shareRank;
	}
	public void setShareRank(Integer shareRank) {
		this.shareRank = shareRank;
	}
	public String getUpName() {
		return upName;
	}
	public void setUpName(String upName) {
		this.upName = upName;
	}
	public Integer getFansCount() {
		return fansCount;
	}
	public void setFansCount(Integer fansCount) {
		this.fansCount = fansCount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
