package com.BilgeAdam.repository;


import com.BilgeAdam.repository.entity.Items;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ItemsRepository extends MongoRepository<Items,String> {
    Optional<Items> findItemsById(String Id);
}
