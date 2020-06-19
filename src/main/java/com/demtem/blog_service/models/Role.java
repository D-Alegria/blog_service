package com.demtem.blog_service.models;

import lombok.Data;

import java.util.List;

@Data
public class Role {

    private String name;
    private List<Privilege> privileges;

}
