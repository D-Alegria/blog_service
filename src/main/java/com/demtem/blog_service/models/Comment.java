package com.demtem.blog_service.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Comment {

    private User author;
    private Date date;
    private String Body;
    private List<User> likes;

}
