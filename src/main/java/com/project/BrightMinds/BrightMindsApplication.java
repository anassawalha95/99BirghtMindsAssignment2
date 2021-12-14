package com.project.BrightMinds;

import com.project.BrightMinds.model.Employee;
import com.project.BrightMinds.model.EmploymentType;
import com.project.BrightMinds.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrightMindsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BrightMindsApplication.class, args);
	}

}
