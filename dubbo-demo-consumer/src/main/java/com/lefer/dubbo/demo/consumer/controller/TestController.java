package com.lefer.dubbo.demo.consumer.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.lefer.dubbo.demo.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(version = "${service.version}")
    private HelloService helloService;
    @NacosValue(value = "${testStr:default}", autoRefreshed = true)
    private String testStr;

    @RequestMapping(path = "hello",method = RequestMethod.GET)
    public String hello(String name){
        return helloService.sayHello(name.concat(testStr));
    }
}
