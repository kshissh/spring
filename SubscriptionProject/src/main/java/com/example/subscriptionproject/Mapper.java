package com.example.subscriptionproject;

import com.example.subscriptionproject.DTOs.SubCreationDTO;
import com.example.subscriptionproject.DTOs.SubResponseDTO;
import com.example.subscriptionproject.DTOs.TransportDTO;
import com.example.subscriptionproject.model.Subscription;
import com.example.subscriptionproject.model.Transport;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class Mapper {
    public SubResponseDTO toSubResponseDto(Subscription sub) {
        String subId = sub.getSubscriptionId();
        LocalDateTime date1 = sub.getCreatedAt();
        LocalDateTime date2 = sub.getExpiresAt();
        String status = sub.getStatus();
        String family = sub.getFamily();
        TransportDTO transport = toTransportDTO(sub.getTransport());
        return new SubResponseDTO(subId, date1,date2,status,family,transport);
    }
    public TransportDTO toTransportDTO(Transport transport) {
        if (transport == null) {
            return null;
        }
        String type = transport.getType();
        String endpoint = transport.getEndpoint();
        return new TransportDTO(type,endpoint);
    }
    public Transport toTransport(TransportDTO transportDTO) {
        if (transportDTO == null) {
            return null;
        }
        Transport transport = new Transport();
        transport.setType(transportDTO.getType());
        transport.setEndpoint(transportDTO.getEndpoint());
        return transport;
    }

    public Subscription toSubscription(SubCreationDTO subCreationDTO) {
        Transport transport = toTransport(subCreationDTO.getTransport());
        return new Subscription(subCreationDTO.getFamily(),transport);
    }


}
