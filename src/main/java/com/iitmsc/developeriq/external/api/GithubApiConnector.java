package com.iitmsc.developeriq.external.api;

import com.iitmsc.developeriq.application.config.YAMLConfig;
import com.iitmsc.developeriq.util.Constants;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GithubApiConnector extends ApiConnector{


    @Autowired
    private YAMLConfig yamlConfig;

    @PostConstruct
    public void init() {
       super.restTemplate = new RestTemplate();
       super.authToken = yamlConfig.getGitHubToken();
    }

    /**
     * Call Github API to get list of commits
     * @param owner
     * @param codeRepo
     * @return
     */
    public List<Map<String, Object>> callGithubApiGetCommitList(String owner, String codeRepo) {
        String url = yamlConfig.getGitHubUrlCommitList();
        url = StringUtils.replace(url, Constants.GIT_HUB_URL_VARIABLE_OWNER, owner);
        url = StringUtils.replace(url, Constants.GIT_HUB_URL_VARIABLE_CODE_REPO, codeRepo);
        return callGetApi(url);
    }

    /**
     * Call Github API to get list of issues
     * @param owner
     * @param codeRepo
     * @return
     */
    public List<Map<String, Object>>  callGithubApiGetIssues(String owner, String codeRepo) {
        String url = yamlConfig.getGitHubUrlCommitList();
        return callGetApi(url);
    }

    /**
     * Call Github API to get list of forks
     * @param owner
     * @param codeRepo
     * @return
     */
    public List<Map<String, Object>>  callGithubApiGetForks(String owner, String codeRepo) {
        String url = yamlConfig.getGitHubUrlCommitList();
        StringUtils.replace(url, Constants.GIT_HUB_URL_VARIABLE_OWNER, owner);
        StringUtils.replace(url, Constants.GIT_HUB_URL_VARIABLE_CODE_REPO, codeRepo);
        return callGetApi(url);
    }
}
