package com.java.test.webApi.Interface;

import java.util.Map;

public interface ApiRequestInterface {

    String getMethod();

    String getUri();

    String getContentType();

    Map<String, String> getHeaders();

    Object getBody();

    Map<String, Object> getQueryParams();

    String getId();

    String getAuth();
}
