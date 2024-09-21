package com.cafyf.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeCafyfApplication {

	public static void main(String[] args) {
		System.out.println("The module is initating to provide service for the code galaxy");
		SpringApplication.run(CodeCafyfApplication.class, args);
	}

}
