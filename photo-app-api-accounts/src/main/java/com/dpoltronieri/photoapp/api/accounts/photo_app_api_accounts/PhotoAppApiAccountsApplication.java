package com.dpoltronieri.photoapp.api.accounts.photo_app_api_accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountsApplication.class, args);
	}

}
