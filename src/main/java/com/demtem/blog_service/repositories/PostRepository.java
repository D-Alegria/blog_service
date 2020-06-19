package com.demtem.blog_service.repositories;

import com.demtem.blog_service.models.Post;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, ObjectId> {

}
