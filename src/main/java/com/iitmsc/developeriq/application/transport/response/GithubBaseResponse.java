package com.iitmsc.developeriq.application.transport.response;

import lombok.Data;

@Data
public class GithubBaseResponse extends BaseResponse {

    private Integer totalCommitCount;
    private Integer totalIssueCount;
    private Integer totalPullRequestCount;
    private Integer totalForkCount;
}
