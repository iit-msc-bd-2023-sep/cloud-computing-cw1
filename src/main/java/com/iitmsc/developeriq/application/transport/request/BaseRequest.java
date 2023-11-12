package com.iitmsc.developeriq.application.transport.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BaseRequest {

    @NotNull( message = "requestHeader not found for operation. This action is not allowed" )
    @Valid
    private RequestHeader requestHeader;
}
