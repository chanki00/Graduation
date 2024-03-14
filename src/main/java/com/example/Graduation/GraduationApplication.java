package com.example.Graduation;

import com.example.Graduation.crawler.Crawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GraduationApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(GraduationApplication.class, args);
		//Crawler.getNotice();
	}

}
