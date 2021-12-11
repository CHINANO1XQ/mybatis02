package com.zking.service.impl;

import com.zking.model.Category;
import com.zking.model.News;
import com.zking.service.ICategoryService;
import com.zking.service.INewsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class NewsServiceImplTest extends BaseTestCase{
    @Autowired
    private INewsService newsService;
    @Autowired
    private ICategoryService categoryService;
    private News news=null;

    @Before
    public void setUp() throws Exception {
        news= new News();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() {
        int n = newsService.deleteNewsCategory(13);
        if(n>0){
            newsService.deleteByPrimaryKey(13);
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }

    }

    @Test
    public void insert() {
        Category c = categoryService.selectByPrimaryKey(5);
        news.setTitle(c.getCategoryName());
        int n = newsService.insert(news);
        if(n>0){
            newsService.insertNewsCategory(news.getNewsId(),5);
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }

    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void getAll() {
        List<News> newList = newsService.getAll(news);
        for (News n : newList) {
            List<Category> categoryList = categoryService.getByNewsId(n.getNewsId());
            n.setCategories(categoryList);
            System.out.println(n);
        }
    }
}