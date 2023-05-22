package com.example.notificationdispatcher.kafka;

import com.example.notification.schema.SubscriptionAvro;
import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.Mapper;
import com.example.notificationdispatcher.config.ScheduledExecutorConfig;
import com.example.notificationdispatcher.SendTask;
import com.example.notificationdispatcher.SubscriptionRepository;
import com.example.notificationservice.model.Subscription;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class KafkaService {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaService.class);
    private SubscriptionRepository subscriptionRepository;
    private RedisTemplate redisTemplate;
    private Mapper mapper;
    private ScheduledExecutorConfig executorService;

    KafkaService(SubscriptionRepository subscriptionRepository,
                 RedisTemplate redisTemplate,
                 Mapper mapper, ScheduledExecutorConfig executorService) {
        this.subscriptionRepository = subscriptionRepository;
        this.redisTemplate = redisTemplate;
        this.mapper = mapper;
        this.executorService = executorService;
    }

    RestTemplate restTemplate = new RestTemplate();

    @Async("threadPoolTaskExecutor")
    @KafkaListener(topics = "notification-subscription", groupId = "myGroup")
    public void consume(ConsumerRecord<String, SubscriptionAvro> message) throws IOException {
        LOGGER.info(String.format("Message received -> %s", message));
        ContainerProperties containerProperties = new ContainerProperties("engagement-topic");
        containerProperties.setMessageListener((MessageListener<String, NotificationAvro>) engagementMessage -> {
            LOGGER.info(String.format("Message received -> %s", engagementMessage));
            List<Subscription> subscriptions = subscriptionRepository.findAll();
            for (Subscription sub : subscriptions) {
                String endpoint = sub.getTransport().getEndpoint();
                String test = null;
                try {
                    test = mapper.avroToJson(engagementMessage.value());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                SendTask sendTask = new SendTask(restTemplate, endpoint, test, 0, executorService);
                sendTask.run();
            }
        });
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
        props.put("schema.registry.url", schemaRegistryUrl);

        DefaultKafkaConsumerFactory<String, Object> consumerFactory = new DefaultKafkaConsumerFactory<>(props);
        KafkaMessageListenerContainer<String, NotificationAvro> container = new KafkaMessageListenerContainer<>(consumerFactory,containerProperties);
        container.start();
    }
}



