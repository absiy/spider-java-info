package com.xz.spider.bilibili.dao;

import com.xz.spider.bilibili.pojo.Video;

public interface VideoDao {
    int deleteByPrimaryKey(String aid);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(String aid);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);
}