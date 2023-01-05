package com.java.test.webApi.Request;

import java.util.HashMap;
import java.util.Map;

import com.java.test.webApi.Enums.RequestIdEnum;
import com.java.test.webApi.Interface.Request.AuthorizationRequestInterface;

public class AuthorizationRequest implements AuthorizationRequestInterface {

    private String appKey;

    public AuthorizationRequest(String appKey) {
        this.appKey = appKey;
    }

    public String getMethod() {
        return RequestIdEnum.getMethod(this.getId());
    }

    public String getUri() {
        return RequestIdEnum.getUri(this.getId());
    }

    public Map<String, Object> getBody() {
        return null;
    }

    public Map<String, Object> getQueryParams() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("client_id", appKey);
        params.put("response_type", "code");
        return params;
    }

    public String getId() {
        return RequestIdEnum.GET_AUTHORIZATION;
    }

    public String getAuth() {
        return null;
    }

    public Map<String, String> getHeaders() {
        return null;
    }

    public String getContentType() {
        return null;
    }
}
