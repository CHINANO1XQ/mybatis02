package com.zking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
    public String hello(){
        System.out.println("你调我干哈，造反？");
        return "index";
    }
}
