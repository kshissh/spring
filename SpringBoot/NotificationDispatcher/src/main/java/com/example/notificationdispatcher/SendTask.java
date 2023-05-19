package com.example.notificationdispatcher;

import com.example.notificationdispatcher.config.ScheduledExecutorConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


public class SendTask implements Runnable{
    private static final Logger LOGGER = LoggerFactory.getLogger(SendTask.class);
    private RestTemplate restTemplate;
    private String endpoint;
    private String notification;
    private int attempt;
    private ScheduledExecutorConfig scheduledExecutor;


    public SendTask(RestTemplate restTemplate, String endpoint, String notification, int attempt, ScheduledExecutorConfig scheduledExecutor) {
        this.restTemplate = restTemplate;
        this.endpoint = endpoint;
        this.notification = notification;
        this.attempt = attempt;
        this.scheduledExecutor = scheduledExecutor;
    }
    @Override
    public void run() {
        if (attempt > 3) {
            scheduledExecutor.scheduledExecutorService().shutdown();
            LOGGER.error("Max retry attempts reached. Notification not sent.");
            return;
        }
        try {
            restTemplate.postForLocation(endpoint, notification);
            LOGGER.info("Notification sent successfully.");
        } catch (Exception e) {
            LOGGER.error("Error sending notification: " + e.getMessage());
             scheduledExecutor.scheduledExecutorService().schedule(new SendTask(restTemplate, endpoint, notification, attempt + 1,scheduledExecutor),
                    30, TimeUnit.SECONDS);
        }
    }
}
