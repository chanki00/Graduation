package com.example.Graduation;

import com.example.Graduation.crawler.LectureCrawler;
import com.example.Graduation.dto.LectureDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class GraduationApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(GraduationApplication.class, args);
		ArrayList<LectureDto> lectureList = LectureCrawler.crawlLecture();

		lectureList.forEach(i -> System.out.println(i));

	}

}
