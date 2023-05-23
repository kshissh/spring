package com.example.notificationdispatcher;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.config.KafkaConfig;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerContainerManager {
    private KafkaMessageListenerContainer<String, NotificationAvro> container;


    public KafkaListenerContainerManager(KafkaConfig kafkaConfig, EngagementMessageListener engagementMessageListener) {
        ContainerProperties containerProperties = new ContainerProperties("engagement-topic");
        containerProperties.setMessageListener(engagementMessageListener);
        this.container = new KafkaMessageListenerContainer<>(kafkaConfig.consumerFactory(), containerProperties);

    }

    public void startContainer() {
        container.start();
    }
}
