package com.demtem.blog_service.services;

import com.demtem.blog_service.models.User;
import com.demtem.blog_service.models.responses.Response;
import com.demtem.blog_service.repositories.UserRepository;
import com.demtem.blog_service.services.contracts.UserService;
import org.bson.types.ObjectId;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Response<User> createUser(User user) {

        Response<User> response = new Response<>();

        User newUser = userRepository.insert(user);
        response.setResponseCode("00");
        response.setModels(Collections.singletonList(newUser));
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<User> readUsers() {

        Response<User> response = new Response<>();

        List<User> newUsers = userRepository.findAll();
        response.setResponseCode("00");
        response.setModels(newUsers);
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<User> readUserById(ObjectId id) {

        Response<User> response = new Response<>();

        Optional<User> readUser = userRepository.findById(id);
        response.setResponseCode("00");
        if (readUser.isEmpty())
            return null;

        response.setModels(Collections.singletonList(readUser.get()));
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<User> updateUser(User user) {
        Response<User> response = new Response<>();

        User updatedUsers = userRepository.save(user);
        response.setResponseCode("00");
        response.setModels(Collections.singletonList(updatedUsers));
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<User> deleteUser(ObjectId id) {
        Response<User> response = new Response<>();

        userRepository.deleteById(id);

        response.setResponseCode("00");
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }
}
