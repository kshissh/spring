package com.example.subscriptionproject.api;

import com.example.subscriptionproject.DTOs.SubResponseDTO;
import com.example.subscriptionproject.Mapper;
import com.example.subscriptionproject.DTOs.SubCreationDTO;
import com.example.subscriptionproject.SubscriptionServiceImpl;
import com.example.subscriptionproject.model.Subscription;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api")
public class SubscriptionController {

    private SubscriptionServiceImpl subscriptionService;
    private Mapper mapper;

    SubscriptionController(SubscriptionServiceImpl subscriptionService, Mapper mapper){
        this.subscriptionService = subscriptionService;
        this.mapper = mapper;
    }

    @PostMapping("/subs")
    @ResponseBody
    public SubResponseDTO create(@RequestBody @Valid SubCreationDTO subCreationDTO) {
        Subscription subscription = mapper.toSubscription(subCreationDTO);
        subscriptionService.create(subscription);
        return mapper.toSubResponseDto(subscription);
    }

    @GetMapping("/subs")
    public List<SubResponseDTO> getAll() {
        return subscriptionService.getAll()
                .stream()
                .map(mapper::toSubResponseDto)
                .collect(Collectors.toList());
    }

    @PutMapping("subs/{subscriptionId}")
    public SubResponseDTO updateSub(@PathVariable("subscriptionId") String subscriptionId) {
        Subscription subscription = subscriptionService.updateSubscription(subscriptionId);
        return mapper.toSubResponseDto(subscription);
    }


    @DeleteMapping("/subs/{subscriptionId}")
    public void deleteSub(@PathVariable("subscriptionId") String subscriptionId) {
        subscriptionService.delete(subscriptionId);
    }

     @GetMapping("/subs/{subscriptionId}")
    public SubResponseDTO getById(@PathVariable("subscriptionId") String subscriptionId) {
        Subscription subscription = subscriptionService.getById(subscriptionId);
        return mapper.toSubResponseDto(subscription);
    }

}
