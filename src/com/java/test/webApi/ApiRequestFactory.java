package com.java.test.webApi;

import java.io.File;

import com.java.test.webApi.Interface.ApiRequestFactoryInterface;
import com.java.test.webApi.Interface.Request.AuthorizationRequestInterface;
import com.java.test.webApi.Interface.Request.DeleteFileRequestInterface;
import com.java.test.webApi.Interface.Request.GetAuthTokenRequestInterface;
import com.java.test.webApi.Interface.Request.GetMetadataRequestInterface;
import com.java.test.webApi.Interface.Request.UploadFileRequestInterface;
import com.java.test.webApi.Request.AuthorizationRequest;
import com.java.test.webApi.Request.DeleteFileRequest;
import com.java.test.webApi.Request.GetAuthTokenRequest;
import com.java.test.webApi.Request.GetMetadataRequest;
import com.java.test.webApi.Request.UploadFileRequest;

public class ApiRequestFactory implements ApiRequestFactoryInterface {

    public GetAuthTokenRequestInterface getAuthToken() {
        return new GetAuthTokenRequest();
    }
    
    public AuthorizationRequestInterface authorization(String appKey) {
        return new AuthorizationRequest(appKey);
    }

    public UploadFileRequestInterface uploadFile(String token, String path, File file) {
        return new UploadFileRequest(token, path, file);
    }

    public GetMetadataRequestInterface getMetadata(String token, String path) {
        return new GetMetadataRequest(token, path);
    }

    public DeleteFileRequestInterface deleteFile(String token, String path) {
        return new DeleteFileRequest(token, path);
    }
}
