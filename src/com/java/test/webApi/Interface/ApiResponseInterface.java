package com.java.test.webApi.Interface;

import org.json.JSONObject;

public interface ApiResponseInterface {
    JSONObject getHeaders();

    Object getBody();

    int getStatusCode();
}
