package com.example.notificationdispatcher;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.config.ScheduledExecutorConfig;
import com.example.notificationservice.model.Subscription;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@Service
public class EngagementMessageListener implements MessageListener<String, NotificationAvro> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EngagementMessageListener.class);
    private SubscriptionRepository subscriptionRepository;
    private Mapper mapper;
    private ScheduledExecutorConfig executorService;
    RestTemplate restTemplate = new RestTemplate();


    public EngagementMessageListener(SubscriptionRepository subscriptionRepository, Mapper mapper, ScheduledExecutorConfig executorService) {
        this.subscriptionRepository = subscriptionRepository;
        this.mapper = mapper;
        this.executorService = executorService;
    }
    @Override
    public void onMessage(ConsumerRecord<String, NotificationAvro> stringNotificationAvroConsumerRecord) {
        LOGGER.info(String.format("Message received -> %s", stringNotificationAvroConsumerRecord));
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        for (Subscription sub : subscriptions) {
            String endpoint = sub.getTransport().getEndpoint();
            String test = null;
            try {
                test = mapper.avroToJson(stringNotificationAvroConsumerRecord.value());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            SendTask sendTask = new SendTask(restTemplate, endpoint, test, 0, executorService);
            sendTask.run();
        }
    }
}
