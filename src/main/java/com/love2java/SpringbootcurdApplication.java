package com.love2java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/hi")
public class SpringbootcurdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcurdApplication.class, args);
	}
	@GetMapping("/hello")
	public String show()
	{
		return "Hello Spring Boot!!";
	}

}
