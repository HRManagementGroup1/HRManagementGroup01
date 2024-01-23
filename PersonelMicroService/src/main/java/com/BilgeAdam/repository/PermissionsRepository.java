package com.BilgeAdam.repository;


import com.BilgeAdam.repository.entity.Permissions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PermissionsRepository extends MongoRepository<Permissions,String> {
}
