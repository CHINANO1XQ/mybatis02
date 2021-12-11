package com.zking.service.impl;

import com.github.pagehelper.PageHelper;
import com.zking.model.Book;
import com.zking.service.IBookService;
import com.zking.util.PageBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class BookServiceImplTest {
    @Autowired
    private IBookService bookService;
    private Book book=null;

    @Before
    public void setUp() throws Exception {
        book=new Book();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() {
        bookService.deleteByPrimaryKey(51);
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        book.setBookId(51);
        book.setBookName("何瑞源生吃妖精");
        book.setBookBrief("真牛逼");
        book.setBookPrice(66f);
        bookService.insertSelective(book);
    }

    @Test
    public void selectByPrimaryKey() {
        Book b=bookService.selectByPrimaryKey(3);
        System.out.println(b);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void selAll() {
        PageBean pageBean=new PageBean();
        pageBean.setRows(3);
        book.setBookName("何瑞源生吃");
        List<Book> books = bookService.selAll(book,pageBean);
        for (Book book1 : books) {
            System.out.println(book1);
        }
    }
}