package com.zking.service.impl;

import com.zking.model.Customer;
import com.zking.model.Order;
import com.zking.service.IBookService;
import com.zking.service.ICustomerService;
import com.zking.service.IOrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplTest extends BaseTestCase{
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IOrderService orderService;
    private Customer customer=null;

    @Before
    public void setUp() throws Exception {
        customer=new Customer();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        customer.setCustomerName("天气好啊");
        int n = customerService.insert(customer);
        Order order=new Order();
        order.setOrderNo("S001");
        order.setCid(customer.getCustomerId());
        List<Order> orders=new ArrayList<>();
        orders.add(order);
        customer.setOrders(orders);
        if(n>0){
            for (Order o : customer.getOrders()) {
                orderService.insert(o);
            }
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
//        Order order = orderService.selectByPrimaryKey(7);
        Customer c = customerService.selectByPrimaryKey(3);
        List<Order> orders = orderService.getByCid(c.getCustomerId());
        c.setOrders(orders);

//        order.setCustomer(c);
        System.out.println(c);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void list() {
        List<Customer> customers = customerService.list(customer);
        for (Customer c : customers) {
            c.setOrders(orderService.getByCid(c.getCustomerId()));
            System.out.println(c);
        }
    }
}