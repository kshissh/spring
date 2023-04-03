package com.example.subscriptionproject;

import com.example.subscriptionproject.DTO.SubCreationDTO;
import com.example.subscriptionproject.DTO.SubResponseDTO;
import com.example.subscriptionproject.DTO.TransportDTO;
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
        TransportDTO transport = toTransDTO(sub.getTransport());
        return new SubResponseDTO(subId, date1,date2,status,family,transport);
    }
    public TransportDTO toTransDTO(Transport transport) {
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

    public SubResponseDTO toSub(SubCreationDTO subCreationDTO) {
        return new SubResponseDTO(subCreationDTO.getFamily(),subCreationDTO.getTransport());
    }


}
