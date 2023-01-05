package com.java.test.webApi;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import com.java.test.webApi.Interface.ApiRequestInterface;
import com.java.test.webApi.Interface.ApiRequestSenderInterface;
import com.java.test.webApi.Interface.ApiResponseInterface;
import com.java.test.webApi.Response.ApiResponse;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiRequestSender implements ApiRequestSenderInterface {
    private RequestSpecification client;

    public ApiRequestSender(
        final RequestSpecification client
    ) {
        this.client = client;
    }

    public final ApiResponseInterface request(final ApiRequestInterface request)
        throws Exception {
        try {
            ApiResponseInterface response = this.send(request);

            return response;
        } catch (Exception e) {
            throw e;
        }
    }

    private ApiResponseInterface send(final ApiRequestInterface request)
        throws IOException, URISyntaxException {
        RequestSpecification httpRequest = buildRequest(request);

        String method = request.getMethod();
        String id = request.getUri();
        Response response = httpRequest.request(method, id);
        response.then().log().all();

        return this.buildApiResponse(response);
    }

    private RequestSpecification buildRequest(
        final ApiRequestInterface request
    ) throws URISyntaxException, IOException {

        EncoderConfig encoderconfig = new EncoderConfig();

        client.config(
            RestAssured
                .config()
                .encoderConfig(encoderconfig.appendDefaultContentCharsetToContentTypeIfUndefined(false))
        );

        this.setUpHeaders(request);
        this.setUpQueryParams(request);
        this.setUpAuth(request);
        this.setUpContentType(request);
        this.setUpBody(request);

        return client;
    }

    private ApiResponseInterface buildApiResponse(
        final Response response
    ) {
        return new ApiResponse(response);
    }

    private void setUpHeaders(ApiRequestInterface request) {
        Map<String, String> headers = request.getHeaders();

        if (headers != null) {
            for (Map.Entry<String,String> entry : headers.entrySet()) {
                client.header(new Header(entry.getKey(), entry.getValue()));
            }
        }
    }

    private void setUpQueryParams(ApiRequestInterface request) {
        Map<String, Object> qp = request.getQueryParams();

        if (qp != null) {
            client.queryParams(request.getQueryParams());
        }
    }

    private void setUpAuth(ApiRequestInterface request) {
        String token = request.getAuth();

        if (token != null) {
            client.header(new Header("Authorization", String.format("Bearer sl.%s", token)));
        }
    }

    private void setUpContentType(ApiRequestInterface request) {
        String contentType = request.getContentType();
        if (contentType != null) {
            client.contentType(contentType);
        }
    }

    private void setUpBody(ApiRequestInterface request) {
        Object body = request.getBody();

        if (body != null) {
            switch (request.getContentType()) {
                case "application/json":
                    client.body(body.toString());
                    break;
                case "application/octet-stream":
                    client.body((File) body);
                default:
                    break;
            }
        }
    }
    
}
