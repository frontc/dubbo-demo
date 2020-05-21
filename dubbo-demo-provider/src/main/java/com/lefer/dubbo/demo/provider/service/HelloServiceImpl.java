package com.lefer.dubbo.demo.provider.service;

import com.lefer.dubbo.demo.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${dubbo.provider.version}")
public class HelloServiceImpl implements HelloService {
    @Value("${dubbo.application.name}")
    private String serviceName;

    @Value( "${dubbo.provider.version}")
    private String version;

    @Override
    public String sayHello(String name) {
        System.out.println(version);
        return String.format("[%s] : Hello, %s", serviceName, name);
    }
}
