package com.spike.hello.dubbo.service.user.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spike.hello.dubbo.service.user.api.UserService;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @Value(value = "${dubbo.protocol.port}")
    private String port;

    @Override
    @HystrixCommand
    public String sayHi() {
        return "hello dubbo " + port;
    }
}
