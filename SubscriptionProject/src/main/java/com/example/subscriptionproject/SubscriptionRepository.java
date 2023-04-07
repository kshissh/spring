package com.example.subscriptionproject;


import com.example.subscriptionproject.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription,String> {
}
