package com.lefer.dubbo.demo.provider2.service;

import com.lefer.dubbo.demo.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "2.0.0")
public class Hello2ServiceImpl implements HelloService {
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String sayHello(String name) {
        System.out.println("2.0.0");
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
