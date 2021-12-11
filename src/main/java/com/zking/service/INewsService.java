package com.zking.service;

import com.zking.model.News;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface INewsService {
    int deleteByPrimaryKey(Integer newsId);

    int deleteNewsCategory(Integer nid);

    int insert(News record);

    int insertNewsCategory(Integer nid,Integer cid);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> getAll(News news);
}