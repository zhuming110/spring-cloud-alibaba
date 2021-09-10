package com.example.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class NacosProviderApplication {

    @Value( "${yaml.age}" )
    private String age;

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

    @GetMapping("/helloNacos")
    public String helloNacos(){
        System.out.println(age);
        return "你好，nacos！";
    }
}
