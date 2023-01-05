package com.java.test.webApi;

import com.java.test.webApi.Interface.ApiRequestFactoryInterface;
import com.java.test.webApi.Interface.ApiRequestSenderInterface;
import com.java.test.webApi.Interface.ApiResponseBuilderInterface;
import com.java.test.webApi.Interface.ClientFactoryInterface;
import com.java.test.webApi.Interface.ClientInterface;

import io.restassured.specification.RequestSpecification;

public class ClientFactory implements ClientFactoryInterface {

    private RequestSpecification specification;

    public final ClientInterface build(
        RequestSpecification specification
    ) {
        this.specification = specification;

        return new Client(
            this.getSender(),
            this.getRequestFactory(),
            this.getResponseBuilder()
        );
    }

    private ApiRequestSenderInterface getSender() {
        return new ApiRequestSender(
            this.specification
        );
    }

    private ApiRequestFactoryInterface getRequestFactory() {
        return new ApiRequestFactory();
    }

    private ApiResponseBuilderInterface getResponseBuilder() {
        return new ApiResponseBuilder();
    }
}
