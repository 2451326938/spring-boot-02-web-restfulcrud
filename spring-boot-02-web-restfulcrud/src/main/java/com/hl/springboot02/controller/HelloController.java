package com.hl.springboot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping({"/","/login.html"})
    public String index(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/success.html")
    public String success(Map<String,Object> map){
        map.put("hello","你好");
        map.put("users", Arrays.asList("hl","hf","yx","tt"));
        return "success";
    }

    @GetMapping(value = "/hf.json", params = "action=update") // http://localhost:8080/hf.json?action=update
    public @ResponseBody String hf(){
        return "hf";
    }

    @GetMapping("/hl.json/{name}")
    public @ResponseBody String hl(@PathVariable(value = "name", required = true) String name){
        return name;
    }

}
