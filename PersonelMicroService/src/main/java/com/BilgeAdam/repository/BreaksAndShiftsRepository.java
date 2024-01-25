package com.BilgeAdam.repository;

import com.BilgeAdam.repository.entity.BreaksAndShifts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BreaksAndShiftsRepository extends MongoRepository<BreaksAndShifts,String> {
}
