package com.java.test.webApi.Response;

import org.json.JSONObject;

import com.java.test.webApi.Interface.ApiResponseInterface;
import com.java.test.webApi.Interface.Response.GetAuthTokenResponseInterface;

public class GetAuthTokenResponse implements GetAuthTokenResponseInterface {
    private ApiResponseInterface response;

    public GetAuthTokenResponse(final ApiResponseInterface response) {
        this.response = response;
    }

    public final String getAuthToken() {
        JSONObject body = new JSONObject(this.response.getBody());
        return (String) body.get("access_token");
    }
}
