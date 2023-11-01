package com.stdmgmt.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stdmgmt.demo.entity.Student;
import com.stdmgmt.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	// Below method can be used to feed some initial data to start with
	// due to hibernate mapping tables and record entries are created automatically.
	@Override
	public void run(String... args) {

		// Student s1 = new Student("Pratiksha", "Sawant", "psawant@gmail.com");
		// studentRepository.save(s1);

		// Student s2 = new Student("Prerana", "Sawant", "prsawant@gmail.com");
		// studentRepository.save(s2);
	}

}
