package com.example.notificationdispatcher;

import com.example.notificationdispatcher.config.ScheduledExecutorConfig;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SendTaskTest extends TestCase {
    private RestTemplate restTemplate;
    private String endpoint;
    private String notification;
    private int attempt;
    private ScheduledExecutorConfig scheduledExecutor;
    private SendTask sendTask;

    @BeforeEach
    public void setup() {
        sendTask = new SendTask(restTemplate, endpoint, notification, attempt, scheduledExecutor);
    }

    @Test
    public void testRunSuccess() {
        String endpoint = "https://webhook.site/83d1ebc9-0f27-43a4-93c2-6c3a41b333b6";
        String notification = "{\n" +
                "  \"event\": \"Notification\",\n" +
                "  \"id\": \"db225502-2c15-45d6-a3c5-1f50ec787800\"\n" +
                "}";
        restTemplate = mock(RestTemplate.class);
        sendTask = new SendTask(restTemplate, endpoint, notification, 0, scheduledExecutor);

        when(restTemplate.postForLocation(endpoint, notification)).thenReturn(null);

        sendTask.run();

        verify(restTemplate).postForLocation(endpoint, notification);
    }

    @Test
    public void testRunFail() {
        String endpoint = "https://webhook.site/cfb71d4c-1ee4-40eb-9ae5-895309e5d636";
        String notification = "{\n" +
                "  \"event\": \"Notification\",\n" +
                "  \"id\": \"db225502-2c15-45d6-a3c5-1f50ec787800\"\n" +
                "}";
        restTemplate = mock(RestTemplate.class);
        scheduledExecutor = mock(ScheduledExecutorConfig.class);
        sendTask = new SendTask(restTemplate, endpoint, notification, 0, scheduledExecutor);

        when(restTemplate.postForLocation(endpoint, notification)).thenThrow(new RuntimeException("Error sending notification"));

        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        when(scheduledExecutor.scheduledExecutorService()).thenReturn(executorService);
        
        sendTask.run();

        verify(scheduledExecutor.scheduledExecutorService()).schedule(
                any(SendTask.class), eq(30L), eq(TimeUnit.SECONDS));
    }
    @Test
    public void testRunMaxRetryAttemptsReached() {
        String endpoint = "https://webhook.site/cfb71d4c-1ee4-40eb-9ae5-895309e5d636";
        String notification = "{\n" +
                "  \"event\": \"Notification\",\n" +
                "  \"id\": \"db225502-2c15-45d6-a3c5-1f50ec787800\"\n" +
                "}";
        restTemplate = mock(RestTemplate.class);
        scheduledExecutor = mock(ScheduledExecutorConfig.class);
        sendTask = new SendTask(restTemplate, endpoint, notification, 4, scheduledExecutor);

        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        when(scheduledExecutor.scheduledExecutorService()).thenReturn(executorService);

        sendTask.run();

        verify(scheduledExecutor.scheduledExecutorService()).shutdown();
    }

}