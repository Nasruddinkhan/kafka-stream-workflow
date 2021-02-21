package com.mypractice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class KafkaStreamWorkflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamWorkflowApplication.class, args);
	}

}
