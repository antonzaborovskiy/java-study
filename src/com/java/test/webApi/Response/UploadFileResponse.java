package com.java.test.webApi.Response;

import org.json.JSONObject;

import com.java.test.webApi.Interface.ApiResponseInterface;
import com.java.test.webApi.Interface.Response.UploadFileResponseInterface;

public class UploadFileResponse implements UploadFileResponseInterface {
    private ApiResponseInterface response;

    public UploadFileResponse(final ApiResponseInterface response) {
        this.response = response;
    }

    public final String getFileName() {
        JSONObject body = new JSONObject(this.response.getBody().toString());
        return (String) body.get("name");
    }
}
