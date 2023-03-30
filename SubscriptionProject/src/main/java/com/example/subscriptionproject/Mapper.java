package com.example.subscriptionproject;

import com.example.subscriptionproject.model.Subscription;
import com.example.subscriptionproject.model.Transport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Mapper {
    public SubResponseDTO toDto(Subscription sub) {
        UUID subId = sub.getSubscriptionId();
        LocalDateTime date1 = sub.getCreatedAt();
        LocalDateTime date2 = sub.getExpiresAt();
        String status = sub.getStatus();
        String family = sub.getFamily();
        Transport transport = sub.getTransport();
        return new SubResponseDTO(subId, date1,date2,status,family,transport);
    }

    public Subscription toSub(SubCreationDTO subCreationDTO) {
        return new Subscription(subCreationDTO.getFamily(), subCreationDTO.getTransport());
    }
}
