package com.BilgeAdam.repository;

import com.BilgeAdam.repository.entity.Personel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository extends MongoRepository<Personel,String> {
}
