package com.example.notificationservice;

import com.example.notification.schema.SubscriptionAvro;
import com.example.notification.schema.TransportAvro;
import com.example.notificationservice.DTO.SubCreationDTO;
import com.example.notificationservice.DTO.SubResponseDTO;
import com.example.notificationservice.DTO.TransportDTO;
import com.example.notificationservice.model.Subscription;
import com.example.notificationservice.model.Transport;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public SubscriptionAvro toAvro(Subscription subscription) {
        SubscriptionAvro.Builder avroBuilder = SubscriptionAvro.newBuilder();
        avroBuilder.setSubscriptionId(subscription.getSubscriptionId());
        avroBuilder.setCreatedAt(subscription.getCreatedAt());
        avroBuilder.setExpiresAt(subscription.getExpiresAt());
        avroBuilder.setStatus(subscription.getStatus());
        avroBuilder.setFamily(subscription.getFamily());
        TransportAvro transportAvro = toAvroTrans(subscription.getTransport());
        avroBuilder.setTransport(transportAvro);
        return avroBuilder.build();
    }
    public TransportAvro toAvroTrans(Transport transport) {
        TransportAvro.Builder transportAvro = TransportAvro.newBuilder();
        transportAvro.setType(transport.getType());
        transportAvro.setEndpoint(transport.getEndpoint());
        return transportAvro.build();
    }
    public SubResponseDTO toSubResponseDto(Subscription sub) {
        SubResponseDTO subResponseDTO = new SubResponseDTO();
        subResponseDTO.setSubscriptionId(sub.getSubscriptionId());
        subResponseDTO.setCreatedAt(sub.getCreatedAt());
        subResponseDTO.setExpiresAt(sub.getExpiresAt());
        subResponseDTO.setStatus(sub.getStatus());
        subResponseDTO.setFamily(sub.getFamily());
        subResponseDTO.setTransport(toTransportDTO(sub.getTransport()));
        return subResponseDTO;
    }
    public TransportDTO toTransportDTO(Transport transport) {
        if (transport == null) {
            return null;
        }
        TransportDTO transportDTO = new TransportDTO();
        transportDTO.setType(transport.getType());
        transportDTO.setEndpoint(transport.getEndpoint());
        return transportDTO;
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
