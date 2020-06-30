package com.java.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public HashMap hello(){
        HashMap<String, String> res = new HashMap<>();
        res.put("a","aaa");
        res.put("b","bbb");
        res.put("c","ccc");
        return res;
    }
    @RequestMapping("/hello1")
    public HashMap hello1(){
        HashMap<String, String> res = new HashMap<>();
        res.put("a","aaa");
        res.put("b","bbb");
        res.put("c","ccc");
        res.put("dd","ddddd");
        return res;
    }
}
