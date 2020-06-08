package com.demtem.blog_service.services.contracts;

import com.demtem.blog_service.models.Post;
import com.demtem.blog_service.models.responses.Response;
import org.bson.types.ObjectId;

public interface PostService {

    Response<Post> createPost(Post post);
    Response<Post> readPosts();
    Response<Post> readPostById(ObjectId id);
    Response<Post> updatePost(Post post);
    Response<Post> deletePost(ObjectId id);
}
