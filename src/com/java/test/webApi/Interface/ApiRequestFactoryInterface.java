package com.java.test.webApi.Interface;

import java.io.File;

import com.java.test.webApi.Interface.Request.AuthorizationRequestInterface;
import com.java.test.webApi.Interface.Request.DeleteFileRequestInterface;
import com.java.test.webApi.Interface.Request.GetAuthTokenRequestInterface;
import com.java.test.webApi.Interface.Request.GetMetadataRequestInterface;
import com.java.test.webApi.Interface.Request.UploadFileRequestInterface;

public interface ApiRequestFactoryInterface {
    GetAuthTokenRequestInterface getAuthToken();

    AuthorizationRequestInterface authorization(String appKey);

    UploadFileRequestInterface uploadFile(String token, String path, File file);

    GetMetadataRequestInterface getMetadata(String token, String path);

    DeleteFileRequestInterface deleteFile(String token, String path);
}
