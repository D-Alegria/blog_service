package com.demtem.blog_service.controllers;

import com.demtem.blog_service.models.Post;
import com.demtem.blog_service.models.responses.Response;
import com.demtem.blog_service.services.contracts.PostService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PostController {

    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/add-post")
    public ResponseEntity<Response<Post>> createPost(@RequestBody Post post){
        Response<Post> postResponse = postService.createPost(post);
        return new ResponseEntity<>(postResponse, HttpStatus.valueOf(Integer.parseInt(postResponse.getStatusCode())));
    }

    @GetMapping("/posts")
    public ResponseEntity<Response<Post>> getPost(){
        Response<Post> postResponse = postService.readPosts();
        return new ResponseEntity<>(postResponse, HttpStatus.valueOf(Integer.parseInt(postResponse.getStatusCode())));
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Response<Post>> getPostById(@PathVariable ObjectId id){
        Response<Post> postResponse = postService.readPostById(id);
        return new ResponseEntity<>(postResponse, HttpStatus.valueOf(Integer.parseInt(postResponse.getStatusCode())));
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Response<Post>> updatePost(@RequestBody Post post){
        Response<Post> postResponse = postService.updatePost(post);
        return new ResponseEntity<>(postResponse, HttpStatus.valueOf(Integer.parseInt(postResponse.getStatusCode())));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Post>> deletePost(@PathVariable ObjectId id){
        Response<Post> postResponse = postService.deletePost(id);
        return new ResponseEntity<>(postResponse, HttpStatus.valueOf(Integer.parseInt(postResponse.getStatusCode())));
    }

}
