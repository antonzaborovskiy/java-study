package com.java.test.webApi;

import java.io.File;

import com.java.test.webApi.Interface.ApiRequestFactoryInterface;
import com.java.test.webApi.Interface.ApiRequestSenderInterface;
import com.java.test.webApi.Interface.ApiResponseBuilderInterface;
import com.java.test.webApi.Interface.ApiResponseInterface;
import com.java.test.webApi.Interface.ClientInterface;
import com.java.test.webApi.Interface.Request.AuthorizationRequestInterface;
import com.java.test.webApi.Interface.Request.DeleteFileRequestInterface;
import com.java.test.webApi.Interface.Request.GetAuthTokenRequestInterface;
import com.java.test.webApi.Interface.Request.GetMetadataRequestInterface;
import com.java.test.webApi.Interface.Request.UploadFileRequestInterface;
import com.java.test.webApi.Interface.Response.GetAuthTokenResponseInterface;
import com.java.test.webApi.Interface.Response.UploadFileResponseInterface;

public class Client implements ClientInterface {
    private ApiRequestSenderInterface sender;
    private ApiRequestFactoryInterface requestFactory;
    private ApiResponseBuilderInterface responseBuilder;

    public Client(
        final ApiRequestSenderInterface sender,
        final ApiRequestFactoryInterface requestFactory,
        final ApiResponseBuilderInterface responseBuilder
    ) {
        this.sender = sender;
        this.requestFactory = requestFactory;
        this.responseBuilder = responseBuilder;
    }

    public String getAuthToken() throws Exception {
        GetAuthTokenRequestInterface request = this.requestFactory.getAuthToken();
        ApiResponseInterface response = this.sender.request(request);
        GetAuthTokenResponseInterface responseObj = this.responseBuilder.buildGetAuthToken(response);
        return responseObj.getAuthToken();
    }

    public String uploadFile(String token, String path, File file) throws Exception {
        UploadFileRequestInterface request = this.requestFactory.uploadFile(token, path, file);
        ApiResponseInterface response = this.sender.request(request);
        UploadFileResponseInterface responseObj = this.responseBuilder.buildUploadFile(response);
        return responseObj.getFileName();
    }

    public void authorization(String appKey) throws Exception {
        AuthorizationRequestInterface request = this.requestFactory.authorization(appKey);
        ApiResponseInterface response = this.sender.request(request);
        this.responseBuilder.buildAuthorization(response);
    }

    public void getMetadata(String token, String path) throws Exception {
        GetMetadataRequestInterface request = this.requestFactory.getMetadata(token, path);
        ApiResponseInterface response = this.sender.request(request);
        this.responseBuilder.buildGetMetadata(response);
    }

    public void deleteFile(String token, String path) throws Exception {
        DeleteFileRequestInterface request = this.requestFactory.deleteFile(token, path);
        ApiResponseInterface response = this.sender.request(request);
        this.responseBuilder.buildDeleteFile(response);
    }  
}
