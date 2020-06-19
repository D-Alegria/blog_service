package com.demtem.blog_service.models.responses;

import lombok.Data;

@Data
public class Error {

    private String fieldName;
    private String message;
}
