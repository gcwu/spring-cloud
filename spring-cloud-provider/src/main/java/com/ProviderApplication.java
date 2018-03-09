package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入端口号：");
		String port =sc.nextLine();
		new SpringApplicationBuilder(ProviderApplication.class).properties("server.port="+port).run(args);
	}

}
