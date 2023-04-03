package com.example.subscriptionproject;

import com.example.subscriptionproject.DTO.SubCreationDTO;
import com.example.subscriptionproject.DTO.SubResponseDTO;
import com.example.subscriptionproject.model.Subscription;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionService {
    SubResponseDTO create(SubCreationDTO subCreationDTO);
    List<SubResponseDTO> getAll();
    SubResponseDTO updateSubscription(UUID subscriptionId, SubResponseDTO subResponseDTO);
    void delete(UUID subscriptionId);
    SubResponseDTO getById(UUID subscriptionId);

    }

