package com.iitmsc.developeriq.application.controller;

import com.iitmsc.developeriq.application.transport.request.BaseRequest;
import com.iitmsc.developeriq.application.transport.request.GithubBaseRequest;
import com.iitmsc.developeriq.application.transport.response.BaseResponse;
import com.iitmsc.developeriq.application.transport.response.GithubBaseResponse;
import com.iitmsc.developeriq.domain.service.DeveloperMetricsService;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "${base-url.context}/developer-metrics" )
@CrossOrigin( origins = "*",
        allowedHeaders = "*" )
public class DeveloperMetricsController {

    @Autowired
    private DeveloperMetricsService developerMetricsService;

    @ApiOperation( value = "getDeveloperMatrics" )
    @PostMapping( value = "/get-developer-metrics",
            produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8" )
    public ResponseEntity<BaseResponse> getDeveloperMetrics(
            @Validated
                                                            @RequestBody( required = true )
            GithubBaseRequest baseRequest, HttpServletRequest request) {
        GithubBaseResponse  githubBaseResponse = developerMetricsService.getDeveloperMetrics(baseRequest);
        return new ResponseEntity <>(githubBaseResponse, HttpStatus.OK);
    }
}
