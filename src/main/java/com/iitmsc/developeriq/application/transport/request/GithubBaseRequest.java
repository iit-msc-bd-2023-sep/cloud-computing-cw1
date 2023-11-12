package com.iitmsc.developeriq.application.transport.request;

import lombok.Data;

@Data
public class GithubBaseRequest extends BaseRequest {

    private String owner;
    private String repo;
}
