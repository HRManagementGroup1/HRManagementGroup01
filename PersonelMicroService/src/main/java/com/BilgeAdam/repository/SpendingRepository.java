package com.BilgeAdam.repository;


import com.BilgeAdam.repository.entity.Spending;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpendingRepository extends MongoRepository<Spending,String> {
}
