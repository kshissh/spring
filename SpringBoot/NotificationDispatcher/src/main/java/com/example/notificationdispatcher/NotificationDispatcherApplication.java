package com.example.notificationdispatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

//@Configuration
//@EnableRetry
@SpringBootApplication
public class NotificationDispatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationDispatcherApplication.class, args);
	}


}
