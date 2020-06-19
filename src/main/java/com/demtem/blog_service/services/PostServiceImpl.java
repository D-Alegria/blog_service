package com.demtem.blog_service.services;

import com.demtem.blog_service.models.Post;
import com.demtem.blog_service.models.responses.Response;
import com.demtem.blog_service.repositories.PostRepository;
import com.demtem.blog_service.services.contracts.PostService;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Response<Post> createPost(Post post) {

        Response<Post> response = new Response<>();

        post.set_id(ObjectId.get());

        Post newPost = postRepository.insert(post);
        response.setResponseCode("00");
        response.setModels(Collections.singletonList(newPost));
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<Post> readPosts() {

        Response<Post> response = new Response<>();

        List<Post> newPosts = postRepository.findAll();
        response.setResponseCode("00");
        response.setModels(newPosts);
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<Post> readPostById(ObjectId id) {

        Response<Post> response = new Response<>();

        Optional<Post> readPost = postRepository.findById(id);
        response.setResponseCode("00");
        if (readPost.isEmpty())
            return null;

        response.setModels(Collections.singletonList(readPost.get()));
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<Post> updatePost(Post post) {
        Response<Post> response = new Response<>();

        Post updatedPosts = postRepository.save(post);
        response.setResponseCode("00");
        response.setModels(Collections.singletonList(updatedPosts));
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }

    @Override
    public Response<Post> deletePost(ObjectId id) {
        Response<Post> response = new Response<>();

        postRepository.deleteById(id);

        response.setResponseCode("00");
        response.setStatusCode("200");
        response.setResponseMessage("Successful");

        return response;
    }
}
