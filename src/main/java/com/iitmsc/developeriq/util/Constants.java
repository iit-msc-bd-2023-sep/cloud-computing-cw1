package com.iitmsc.developeriq.util;

public class Constants {

    public static final String GIT_HUB_URL_VARIABLE_OWNER = "{{OWNER}}";
    public static final String GIT_HUB_URL_VARIABLE_CODE_REPO = "{{CODE_REPO}}";

    public static final String METRICS_MGT = "metricsmgt";

    public static final String LOG_STRING = "{}:{}:{}:{}:{}:{}:{}";
    public static final String DB_CALL_INIT = "citymgt:db request initiated:{}:{}:{}";
    public static final String DB_CALL_TERMINATED = "citymgt:db request terminated:{}:{}:{}:{}";
    public static final String REQUEST_TERMINATED = "REQUEST TERMINATED";

    public static final String REQUEST_RECEIVED = "REQUEST RECEIVED";
    public static final String ERROR_PARSING_PARAMS_IN_CLASS = "error parsing params in class {}";
    public static final String METHOD_START = "{}:method start:{}:{}";
    public static final String METHOD_OUT = "{}:method out:{}:{}";

    public static final String CRUD_METHOD_INIT_LOG_MSG_UPDATE = "update method started | id: {}";
    public static final String DUPLICATE_METRIC_NAME = "duplicate_metric name repo pair";
}
