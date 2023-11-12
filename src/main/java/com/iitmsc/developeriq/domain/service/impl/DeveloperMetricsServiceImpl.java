package com.iitmsc.developeriq.domain.service.impl;

import com.iitmsc.developeriq.application.transport.request.BaseRequest;
import com.iitmsc.developeriq.application.transport.request.GithubBaseRequest;
import com.iitmsc.developeriq.application.transport.response.BaseResponse;
import com.iitmsc.developeriq.application.transport.response.GithubBaseResponse;
import com.iitmsc.developeriq.domain.entity.Metrics;
import com.iitmsc.developeriq.domain.service.DeveloperMetricsService;
import com.iitmsc.developeriq.external.api.GithubApiConnector;
import com.iitmsc.developeriq.external.repository.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeveloperMetricsServiceImpl implements DeveloperMetricsService {


    @Autowired
    private GithubApiConnector githubApiConnector;

    @Autowired
    private MetricRepository metricRepository;

    /**
     * get Developer related metrics
     * @param githubBaseRequest
     * @return
     */
    @Override
    public GithubBaseResponse getDeveloperMetrics(GithubBaseRequest githubBaseRequest) {
        List<Map<String, Object>> responseGetCommitList =  githubApiConnector.callGithubApiGetCommitList(githubBaseRequest.getOwner(), githubBaseRequest.getRepo());
        Metrics metrics = new Metrics();
        metrics.setOwner(githubBaseRequest.getOwner());
        metrics.setTotalCommits( responseGetCommitList.size());
        metricRepository.save(metrics);
        GithubBaseResponse githubBaseResponse = new GithubBaseResponse();
        githubBaseResponse.setTotalCommitCount(metrics.getTotalCommits());
        githubBaseResponse.setResponseHeader(createResponseHeader(githubBaseRequest.getRequestHeader(), "Successfully retrieved metrics"));
        return githubBaseResponse;
    }
}
