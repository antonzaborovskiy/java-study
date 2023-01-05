package com.java.test.webApi.Interface;

public interface ApiRequestSenderInterface {
    ApiResponseInterface request(ApiRequestInterface request) throws Exception;
}
