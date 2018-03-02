package com.test.cloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServerApplication {

    public static void main(String[] args) {
        //下面两行代码都可以用来启动
        //SpringApplication.run(ServerApplication.class, args);
        new SpringApplicationBuilder(ServerApplication.class).web(true).run(args);
    }
}
