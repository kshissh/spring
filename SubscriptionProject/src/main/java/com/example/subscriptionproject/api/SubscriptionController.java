package com.example.subscriptionproject.api;

import com.example.subscriptionproject.DTO.SubResponseDTO;
import com.example.subscriptionproject.Mapper;
import com.example.subscriptionproject.DTO.SubCreationDTO;
import com.example.subscriptionproject.SubscriptionServiceImpl;
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

    @PostMapping("/subs")
    @ResponseBody
    public SubResponseDTO create(@RequestBody SubCreationDTO subCreationDTO) {
        SubResponseDTO subResponseDTO = mapper.toSub(subCreationDTO);
        return subscriptionService.create(subCreationDTO);
    }

    @GetMapping("/subs")
    public List<SubResponseDTO> getAll() {
        return subscriptionService.getAll();
    }

    @PutMapping("subs/{subscriptionId}")
    public SubResponseDTO updateSub(@PathVariable("subscriptionId") UUID subscriptionId, @RequestBody SubResponseDTO subResponseDTO) {
        return subscriptionService.updateSubscription(subscriptionId, subResponseDTO);
    }

    @DeleteMapping("/subs/{subscriptionId}")
    public void deleteSub(@PathVariable("subscriptionId") UUID subscriptionId) {
        subscriptionService.delete(subscriptionId);
    }

     @GetMapping("/subs/{subscriptionId}")
    public SubResponseDTO getById(@PathVariable("subscriptionId") UUID subscriptionId) {
        return subscriptionService.getById(subscriptionId);
    }


}
