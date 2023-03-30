package com.example.subscriptionproject.api;

import com.example.subscriptionproject.Mapper;
import com.example.subscriptionproject.SubCreationDTO;
import com.example.subscriptionproject.SubscriptionServiceImpl;
import com.example.subscriptionproject.model.Subscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api")
public class SubscriptionController {

    private SubscriptionServiceImpl subscriptionService;
    private Mapper mapper;

    SubscriptionController(SubscriptionServiceImpl subscriptionService, Mapper mapper){
        this.subscriptionService = subscriptionService;
        this.mapper = mapper;
    }

    @PostMapping("/subs/create")
    @ResponseBody
    public Subscription create(@RequestBody SubCreationDTO subCreationDTO) {
        Subscription subscription = mapper.toSub(subCreationDTO);
        return subscriptionService.create(subscription);
    }

    @GetMapping("/subs-all")
    public List<Subscription> getAll() {
        return subscriptionService.getAll();
    }

    @PutMapping("subs/update/{subscriptionId}")
    public Subscription updateSub(@PathVariable("subscriptionId") UUID subscriptionId, @RequestBody Subscription subscription) {
        return subscriptionService.updateSubscription(subscriptionId, subscription);
    }

    @DeleteMapping("/subs/delete/{subscriptionId}")
    public void deleteSub(@PathVariable("subscriptionId") UUID subscriptionId) {
        subscriptionService.delete(subscriptionId);
    }


}
