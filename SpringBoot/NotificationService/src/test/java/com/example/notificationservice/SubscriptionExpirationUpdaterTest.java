package com.example.notificationservice;

import com.example.notificationservice.model.Subscription;
import com.example.notificationservice.model.Transport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class SubscriptionExpirationUpdaterTest {
    private SubscriptionRepository subscriptionRepository;

    private SubscriptionExpirationUpdater subscriptionExpirationUpdater;


    @BeforeEach
    public void setup() {
        subscriptionRepository = mock(SubscriptionRepository.class);
        subscriptionExpirationUpdater = new SubscriptionExpirationUpdater(subscriptionRepository);
    }

    @Test
    void shouldCheckExpiredSubscriptions() {
        Subscription subscription1 = new Subscription();
        subscription1.setSubscriptionId("a939b970-c74a-4e46-b25a-eb57eb0d0dc3");
        subscription1.setCreatedAt("2023-05-05T16:39:03.824804800");
        subscription1.setExpiresAt("2023-05-05T17:39:03.825802900");
        subscription1.setStatus("ACTIVE");
        subscription1.setFamily("CALL_RECORDING");
        Transport transport = new Transport("WEBHOOK","https://webhook.site/cfb71d4c-1ee4-40eb-9ae5-895309e5d636");
        subscription1.setTransport(transport);
        when(subscriptionRepository.findAll()).thenReturn(List.of(subscription1));
        subscriptionExpirationUpdater.checkExpiredSubscriptions();
        verify(subscriptionRepository).save((argThat(sub -> sub.getStatus().equals("SUSPENDED"))));
    }

    @Test
    void shouldNotCheckNonExpiredSubscriptions() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Subscription subscription2 = new Subscription();
        subscription2.setSubscriptionId("b84df650-3e9a-471f-a45b-0985a2a35f4a");
        subscription2.setCreatedAt(localDateTime.toString());
        subscription2.setExpiresAt(localDateTime.plusHours(1).toString());
        subscription2.setStatus("ACTIVE");
        subscription2.setFamily("CALL_RECORDING");
        Transport transport = new Transport("WEBHOOK", "https://webhook.site/83d1ebc9-0f27-43a4-93c2-6c3a41b333b6");
        subscription2.setTransport(transport);
        when(subscriptionRepository.findAll()).thenReturn(List.of(subscription2));
        subscriptionExpirationUpdater.checkExpiredSubscriptions();
        verify(subscriptionRepository, never()).save(any(Subscription.class));
    }

}