package com.example.subscriptionproject;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepo;
    private ModelMapper modelMapper;

    SubscriptionServiceImpl(SubscriptionRepository subscriptionRepo, ModelMapper modelMapper) {
    this.subscriptionRepo = subscriptionRepo;
    this.modelMapper = modelMapper;
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
    public SubCreationDTO convertToDTO(SubCreationDTO subscription) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        SubCreationDTO subscriptionCreationDTO = new SubCreationDTO();
        subscriptionCreationDTO=modelMapper.map(subscription,SubCreationDTO.class);
        return subscriptionCreationDTO;
    }


}
