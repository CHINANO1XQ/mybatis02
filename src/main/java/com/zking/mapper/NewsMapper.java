package com.zking.mapper;

import com.zking.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
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