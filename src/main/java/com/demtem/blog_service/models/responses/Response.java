package com.demtem.blog_service.models.responses;

import lombok.Data;

import java.util.List;

@Data
public class Response<T> {

    private String statusCode;
    private String responseCode;
    private String responseMessage;
    private List<T> models;
    private List<Error> errors;
}
