package com.java.test.webApi.Interface;

import io.restassured.specification.RequestSpecification;

public interface ClientFactoryInterface {
    ClientInterface build(
        RequestSpecification specification
    );
}
