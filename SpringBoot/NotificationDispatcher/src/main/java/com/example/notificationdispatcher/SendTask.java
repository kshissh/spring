package com.example.notificationdispatcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SendTask implements Runnable{
    private static final Logger LOGGER = LoggerFactory.getLogger(SendTask.class);
    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
    private RestTemplate restTemplate;
    private String endpoint;
    private String notification;
    private int attempt;

    public SendTask(RestTemplate restTemplate, String endpoint, String notification, int attempt) {
        this.restTemplate = restTemplate;
        this.endpoint = endpoint;
        this.notification = notification;
        this.attempt = attempt;
    }
    @Override
    public void run() {
        if (attempt > 3) {
            LOGGER.error("Max retry attempts reached. Notification not sent.");
            return;
        }
        try {
            restTemplate.postForLocation(endpoint, notification);
            LOGGER.info("Notification sent successfully.");
        } catch (Exception e) {
            LOGGER.error("Error sending notification: " + e.getMessage());
            executorService.schedule(new SendTask(restTemplate, endpoint, notification, attempt + 1),
                    30, TimeUnit.SECONDS);
        }
    }
}
