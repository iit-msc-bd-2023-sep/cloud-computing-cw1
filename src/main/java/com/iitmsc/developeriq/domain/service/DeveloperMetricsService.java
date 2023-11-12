package com.iitmsc.developeriq.domain.service;

import com.iitmsc.developeriq.application.transport.request.BaseRequest;
import com.iitmsc.developeriq.application.transport.request.GithubBaseRequest;
import com.iitmsc.developeriq.application.transport.response.BaseResponse;
import com.iitmsc.developeriq.application.transport.response.GithubBaseResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "${base-url.context}/developer-metrics" )
@CrossOrigin( origins = "*",
        allowedHeaders = "*" )
public interface DeveloperMetricsService extends CommonService {

    public GithubBaseResponse getDeveloperMetrics(GithubBaseRequest githubBaseRequest);
}
