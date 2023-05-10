package com.example.notificationservicetool;

import com.example.notification.service.tool.schema.NotificationAvro;
import com.example.notificationservicetool.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public NotificationAvro toAvro(Notification notification) {
        NotificationAvro.Builder notificationAvro = NotificationAvro.newBuilder();
        notificationAvro.setEvent(notification.getEvent());
        notificationAvro.setId(notification.getId());
        return notificationAvro.build();
    }
}