package com.java.test.webApi.Interface;

import com.java.test.webApi.Interface.Response.AuthorizationResponseInterface;
import com.java.test.webApi.Interface.Response.DeleteFileResponseInterface;
import com.java.test.webApi.Interface.Response.GetAuthTokenResponseInterface;
import com.java.test.webApi.Interface.Response.GetMetadataResponseInterface;
import com.java.test.webApi.Interface.Response.UploadFileResponseInterface;

public interface ApiResponseBuilderInterface {
    GetAuthTokenResponseInterface buildGetAuthToken(ApiResponseInterface response);

    AuthorizationResponseInterface buildAuthorization(ApiResponseInterface response);

    UploadFileResponseInterface buildUploadFile(ApiResponseInterface response);

    GetMetadataResponseInterface buildGetMetadata(ApiResponseInterface response);

    DeleteFileResponseInterface buildDeleteFile(ApiResponseInterface response);
}
