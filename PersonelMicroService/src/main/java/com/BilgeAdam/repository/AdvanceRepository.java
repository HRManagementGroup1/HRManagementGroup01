package com.BilgeAdam.repository;


import com.BilgeAdam.repository.entity.Advance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdvanceRepository extends MongoRepository<Advance,String> {
}
