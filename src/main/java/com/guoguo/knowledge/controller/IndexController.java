package com.guoguo.knowledge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户登录
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
