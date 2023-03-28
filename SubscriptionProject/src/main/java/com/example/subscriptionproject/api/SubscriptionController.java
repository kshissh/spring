package com.example.subscriptionproject.api;

import com.example.subscriptionproject.SubscriptionServiceImpl;
import com.example.subscriptionproject.model.Subscription;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class SubscriptionController {

    private SubscriptionServiceImpl subscriptionService;

    SubscriptionController(SubscriptionServiceImpl subscriptionService){
        this.subscriptionService = subscriptionService;
    }





}
