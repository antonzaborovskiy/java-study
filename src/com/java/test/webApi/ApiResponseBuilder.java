package com.java.test.webApi;

import com.java.test.webApi.Interface.ApiResponseBuilderInterface;
import com.java.test.webApi.Interface.ApiResponseInterface;
import com.java.test.webApi.Interface.Response.AuthorizationResponseInterface;
import com.java.test.webApi.Interface.Response.DeleteFileResponseInterface;
import com.java.test.webApi.Interface.Response.GetAuthTokenResponseInterface;
import com.java.test.webApi.Interface.Response.GetMetadataResponseInterface;
import com.java.test.webApi.Interface.Response.UploadFileResponseInterface;
import com.java.test.webApi.Response.AuthorizationResponse;
import com.java.test.webApi.Response.DeleteFileResponse;
import com.java.test.webApi.Response.GetAuthTokenResponse;
import com.java.test.webApi.Response.GetMetadataResponse;
import com.java.test.webApi.Response.UploadFileResponse;

public class ApiResponseBuilder implements ApiResponseBuilderInterface {

    public GetAuthTokenResponseInterface buildGetAuthToken(ApiResponseInterface response) {
        return new GetAuthTokenResponse(response);
    }
 
    public AuthorizationResponseInterface buildAuthorization(ApiResponseInterface response) {
        return new AuthorizationResponse();
    }

    public UploadFileResponseInterface buildUploadFile(ApiResponseInterface response) {
        return new UploadFileResponse(response);
    }

    public GetMetadataResponseInterface buildGetMetadata(ApiResponseInterface response) {
        return new GetMetadataResponse();
    }

    public DeleteFileResponseInterface buildDeleteFile(ApiResponseInterface response) {
        return new DeleteFileResponse();
    }
}
