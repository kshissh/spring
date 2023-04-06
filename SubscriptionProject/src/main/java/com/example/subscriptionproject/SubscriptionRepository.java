package com.example.subscriptionproject;


import com.example.subscriptionproject.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,String>{
}
