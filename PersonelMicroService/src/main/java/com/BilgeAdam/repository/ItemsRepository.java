package com.BilgeAdam.repository;


import com.BilgeAdam.repository.entity.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface    ItemsRepository extends MongoRepository<Items,String> {
}
