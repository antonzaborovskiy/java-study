package com.java.test.webApi.Request;

import java.util.Map;

import org.json.JSONObject;

import com.java.test.webApi.Enums.RequestIdEnum;
import com.java.test.webApi.Interface.Request.DeleteFileRequestInterface;

public class DeleteFileRequest implements DeleteFileRequestInterface {

    private String token;
    private String path;

    public DeleteFileRequest(String token, String path) {
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
        body.put("path", path);
        return body;
    }

    public Map<String, Object> getQueryParams() {
        return null;
    }

    public String getId() {
        return RequestIdEnum.POST_FILE_DELETE;
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
