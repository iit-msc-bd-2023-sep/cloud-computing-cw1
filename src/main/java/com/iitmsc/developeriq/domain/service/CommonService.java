package com.iitmsc.developeriq.domain.service;

import com.iitmsc.developeriq.application.transport.request.RequestHeader;
import com.iitmsc.developeriq.application.transport.response.ResponseHeader;

import java.time.LocalDateTime;
import java.util.Objects;

public interface CommonService {

    /**
     * Create Response Header.
     *
     * @param requestHeader
     * @param responseDescription
     * @return
     */
    default ResponseHeader createResponseHeader(RequestHeader requestHeader, String responseDescription) {
        ResponseHeader responseHeader = new ResponseHeader();
        if ( Objects.nonNull(requestHeader) ) {
            responseHeader.setRequestId(requestHeader.getRequestId());
        }
        responseHeader.setResponseCode("200");
        responseHeader.setResponseDesc(responseDescription);
        responseHeader.setResponseDescDisplay(responseDescription);
        responseHeader.setTimestamp(LocalDateTime.now().toString());
        return responseHeader;
    }
}
