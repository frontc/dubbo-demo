package com.lefer.dubbo.demo.consumer.controller;


import com.lefer.dubbo.demo.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(version = "${service.version}")
    private HelloService helloService;

    @RequestMapping(path = "hello",method = RequestMethod.GET)
    public String hello(String name){
        System.out.println(name);
        return helloService.sayHello(name);
    }
}
