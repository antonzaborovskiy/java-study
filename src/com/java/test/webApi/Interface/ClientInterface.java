package com.java.test.webApi.Interface;

import java.io.File;

public interface ClientInterface {
    void authorization(String appKey) throws Exception;

    String getAuthToken() throws Exception;

    String uploadFile(String token, String path, File file) throws Exception;

    void getMetadata(String token, String path) throws Exception;

    void deleteFile(String token, String path) throws Exception;
}
