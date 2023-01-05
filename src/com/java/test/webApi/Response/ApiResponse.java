package com.java.test.webApi.Response;

import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;
import com.java.test.webApi.Interface.ApiResponseInterface;

import io.restassured.http.Header;
import io.restassured.response.Response;

public class ApiResponse implements ApiResponseInterface {
    public static final int SUCCESS_CODE = 200;
    public static final String VALID_CONTENT_TYPE = "application/json";
    public static final String ERROR_KEY = "error";

    private Response response;
    private String error;
    private Object body = new JSONObject();

    public ApiResponse(final Response response) {
        this.response = response;
        this.validate();
    }

    private void validate() {
        try {
            this.validateBody();
            this.validateResponseCode();
        } catch (Exception e) {
            this.error = e.getMessage();
        }
    }

    private void validateResponseCode() throws Exception {
        int code = this.getStatusCode();
        if (code != SUCCESS_CODE) {
            throw new Exception(
                String.format("Invalid response code: %s", code)
            );
        }
    }

    public int getStatusCode() {
        return this.response.getStatusCode();
    }

    public Object getBody() {
        return this.body;
    }

    public String getValidationError() {
        return this.error;
    }

    private void validateBody() throws Exception {
        String bodyStr = "";
        try {
            bodyStr = this.response.body().asString();
            this.body = new JSONObject(bodyStr);
        } catch (JSONException e) {
            this.body = bodyStr;
        }
    }

    public JSONObject getHeaders() {
        Iterator<Header> headers = this.response.headers().iterator();
        JSONObject headersJson = new JSONObject();
        while (headers.hasNext()) {
            Header curr = headers.next();
            headersJson.put(curr.getName(), curr.getValue());
        }
        return headersJson;
    }
}
