package com.java.test.webApi.Request;

import java.util.Map;

import com.java.test.webApi.Enums.RequestIdEnum;
import com.java.test.webApi.Interface.Request.GetAuthTokenRequestInterface;

public class GetAuthTokenRequest implements GetAuthTokenRequestInterface {

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
        return null;
    }

    public String getId() {
        return RequestIdEnum.POST_GETAUTHTOKEN;
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
