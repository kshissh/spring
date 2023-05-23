package com.example.notificationdispatcher;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationdispatcher.config.KafkaConfig;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerContainerManager {
    private KafkaMessageListenerContainer<String, NotificationAvro> container;
    private KafkaConfig kafkaConfig;
    private TopicMessageListener topicMessageListener;

    public KafkaListenerContainerManager(KafkaConfig kafkaConfig, TopicMessageListener topicMessageListener) {
        this.kafkaConfig = kafkaConfig;
        this.topicMessageListener = topicMessageListener;
    }

    public void startContainer() {
        if (container != null && container.isRunning()) {
            return;
        }
        ContainerProperties containerProperties = new ContainerProperties("engagement-topic");
        containerProperties.setMessageListener(topicMessageListener);
        container = new KafkaMessageListenerContainer<>(kafkaConfig.consumerFactory(), containerProperties);
        container.start();
    }
}
