package com.org.DnDHelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DnDHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(DnDHelperApplication.class, args);
	}

}
