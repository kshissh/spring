package com.example.subscriptionproject;

import com.example.subscriptionproject.DTO.SubCreationDTO;
import com.example.subscriptionproject.DTO.SubResponseDTO;
import com.example.subscriptionproject.model.Subscription;
import com.example.subscriptionproject.model.Transport;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepo;
    private Mapper mapper;

    SubscriptionServiceImpl(SubscriptionRepository subscriptionRepo, Mapper mapper) {
    this.subscriptionRepo = subscriptionRepo;
    this.mapper=mapper;
    }


    @Override
    public SubResponseDTO create(SubCreationDTO subCreationDTO) {
        Subscription subscription = new Subscription();
        subscription.setSubscriptionId(UUID.randomUUID());
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setExpiresAt(LocalDateTime.now().plusHours(1));
        subscription.setStatus("ACTIVE");
        subscription.setFamily(subCreationDTO.getFamily());
        subscription.setTransport(mapper.toTransport(subCreationDTO.getTransport()));
        Subscription savedSub = subscriptionRepo.save(subscription);
        return mapper.toDto(savedSub);
    }
    @Override
    public List<SubResponseDTO> getAll() {
        return subscriptionRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public SubResponseDTO updateSubscription(UUID subscriptionId, SubResponseDTO subResponseDTO) {
        Subscription existingSubscription = subscriptionRepo.findById(subscriptionId).orElse(null);
        if (existingSubscription != null) {
            existingSubscription.setCreatedAt(LocalDateTime.now());
            existingSubscription.setExpiresAt(LocalDateTime.now().plusHours(1));
            existingSubscription.setStatus("ACTIVE");
            subscriptionRepo.save(existingSubscription);
            return mapper.toDto(existingSubscription);
        }
        return null;
    }

    @Override
    public void delete(UUID subscriptionId) {
        subscriptionRepo.deleteById(subscriptionId);
    }

    @Override
    public SubResponseDTO getById(UUID subscriptionId) {
        Optional<Subscription> subscription = subscriptionRepo.findById(subscriptionId);
        Subscription sub = subscription.orElse(null);
        return mapper.toDto(sub);
    }

}
