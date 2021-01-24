package com.hl.springboot01hellloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // 类的所有方法直接返回给浏览器（如果是对象转为json数据 ）
@RestController // 综合上面两个
public class HelloController {
        @RequestMapping("/helloworld")
        public String hello(){
            return "hello world quickly！";
        }


}
