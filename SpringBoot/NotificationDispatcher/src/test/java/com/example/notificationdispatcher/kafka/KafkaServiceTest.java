package com.example.notificationdispatcher.kafka;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.Mapper;
import com.example.notificationdispatcher.SubscriptionRepository;
import com.example.notificationservice.model.Subscription;
import com.example.notificationservice.model.Transport;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KafkaServiceTest {

    private SubscriptionRepository subscriptionRepository;

    private RedisTemplate redisTemplate;
    private Mapper mapper;

    private KafkaService kafkaService;
    private RestTemplate restTemplate;
    private ConsumerRecord<String, NotificationAvro> consumerRecord;


    @BeforeEach
    public void setup() {
        subscriptionRepository = mock(SubscriptionRepository.class);
        redisTemplate = mock(RedisTemplate.class);
        mapper = mock(Mapper.class);
        kafkaService = new KafkaService(subscriptionRepository,redisTemplate,mapper);
        restTemplate = mock(RestTemplate.class);
        consumerRecord = mock(ConsumerRecord.class);
    }

    @Test
    void sendNotificationTest() throws IOException {
        NotificationAvro notificationAvro = new NotificationAvro();
        notificationAvro.setId("75a0ce74-da88-4e6e-a082-bb11f26b6f5c");
        notificationAvro.setEvent("Notification");
        when(consumerRecord.value()).thenReturn(notificationAvro);
        Subscription subscription1 = new Subscription();
        subscription1.setSubscriptionId("a939b970-c74a-4e46-b25a-eb57eb0d0dc3");
        subscription1.setCreatedAt("2023-05-28T16:39:03.824804800");
        subscription1.setExpiresAt("2023-05-28T17:39:03.825802900");
        subscription1.setStatus("ACTIVE");
        subscription1.setFamily("CALL_RECORDING");
        Transport transport = new Transport("WEBHOOK","https://webhook.site/cfb71d4c-1ee4-40eb-9ae5-895309e5d636");
        subscription1.setTransport(transport);
        when(subscriptionRepository.findAll()).thenReturn(List.of(subscription1));
        when(restTemplate.postForLocation(anyString(), anyString())).thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}