package com.demtem.blog_service.services.contracts;

import com.demtem.blog_service.models.User;
import com.demtem.blog_service.models.responses.Response;
import org.bson.types.ObjectId;

public interface UserService {

    Response<User> createUser(User user);
    Response<User> readUsers();
    Response<User> readUserById(ObjectId id);
    Response<User> updateUser(User user);
    Response<User> deleteUser(ObjectId id);
}
