package com.example.notificationdispatcher.api;

import com.example.notificationdispatcher.NotificationServiceImpl;
import com.example.notificationdispatcher.SubscriptionRepository;
import com.example.notificationservice.model.Subscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class NotificationController {
    private NotificationServiceImpl notificationService;
    NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/subs")
    public List<Subscription> getAll() {
        return notificationService.getAll();
    }

}


