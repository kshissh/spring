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
    public SubResponseDTO toSubResponseDto(com.example.notificationservice.model.Subscription sub) {
        String subId = sub.getSubscriptionId();
        String date1 = sub.getCreatedAt();
        String date2 = sub.getExpiresAt();
        String status = sub.getStatus();
        String family = sub.getFamily();
        TransportDTO transport = toTransportDTO(sub.getTransport());
        return new SubResponseDTO(subId, date1,date2,status,family,transport);
    }
    public TransportDTO toTransportDTO(com.example.notificationservice.model.Transport transport) {
        if (transport == null) {
            return null;
        }
        String type = transport.getType();
        String endpoint = transport.getEndpoint();
        return new TransportDTO(type,endpoint);
    }
    public com.example.notificationservice.model.Transport toTransport(TransportDTO transportDTO) {
        if (transportDTO == null) {
            return null;
        }
        com.example.notificationservice.model.Transport transport = new com.example.notificationservice.model.Transport();
        transport.setType(transportDTO.getType());
        transport.setEndpoint(transportDTO.getEndpoint());
        return transport;
    }

    public com.example.notificationservice.model.Subscription toSubscription(SubCreationDTO subCreationDTO) {
        com.example.notificationservice.model.Transport transport = toTransport(subCreationDTO.getTransport());
        return new com.example.notificationservice.model.Subscription(subCreationDTO.getFamily(),transport);
    }


}
