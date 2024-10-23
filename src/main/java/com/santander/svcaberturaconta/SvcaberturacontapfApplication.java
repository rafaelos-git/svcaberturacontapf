package com.santander.svcaberturaconta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SvcaberturacontapfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcaberturacontapfApplication.class, args);
	}

}
