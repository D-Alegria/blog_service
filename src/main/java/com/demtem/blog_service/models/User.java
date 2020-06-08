package com.demtem.blog_service.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    private ObjectId _id;
    private String username;
}
