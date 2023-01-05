package com.java.test.webApi.Request;

import java.util.Map;

import org.json.JSONObject;

import com.java.test.webApi.Enums.RequestIdEnum;
import com.java.test.webApi.Interface.Request.GetMetadataRequestInterface;

public class GetMetadataRequest implements GetMetadataRequestInterface {

    private String token;
    private String path;

    public GetMetadataRequest(String token, String path) {
        this.token = token;
        this.path = path;
    }

    public String getMethod() {
        return RequestIdEnum.getMethod(this.getId());
    }

    public String getUri() {
        return RequestIdEnum.getUri(this.getId());
    }

    public Object getBody() {
        JSONObject body = new JSONObject();
        body.put("include_deleted", false);
        body.put("include_has_explicit_shared_members", false);
        body.put("include_media_info", false);
        body.put("path", this.path);
        return body;
    }

    public Map<String, Object> getQueryParams() {
        return null;
    }

    public String getId() {
        return RequestIdEnum.POST_METADATA;
    }

    public String getAuth() {
        return this.token;
    }

    public Map<String, String> getHeaders() {
        return null;
    }

    public String getContentType() {
        return "application/json";
    }
}
