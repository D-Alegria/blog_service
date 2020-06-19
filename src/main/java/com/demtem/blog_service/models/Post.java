package com.demtem.blog_service.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class Post {
    @Id
    private ObjectId _id;

    private String title;
    private String body;
    private User author;
    private List<Comment> comments;
    private List<User> likes;
    private Date date;

    public String get_id(){
       return _id.toHexString();
    }
}
