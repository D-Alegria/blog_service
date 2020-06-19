package com.demtem.blog_service.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class User {

    @Id
    private ObjectId _id;

    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;
    private String providerId;
}
