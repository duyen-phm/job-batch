package com.diendev.jobbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JobBatchApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(JobBatchApplication.class, args);

		try {
			applicationContext.getBean(MyJobRunner.class).runJob();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
