package com.nalituwe.student_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.nalituwe.student_manager.controllers", "com.nalituwe.student_manager.models", "com.nalituwe.student_manager.controllers.data"})
@SpringBootApplication
public class StudentManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagerApplication.class, args);
	}

}
