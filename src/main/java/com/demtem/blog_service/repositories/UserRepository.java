package com.demtem.blog_service.repositories;

import com.demtem.blog_service.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByEmail(String email);

    Boolean existsByEmail(String email);
}
