package com.java.test.webApi.Request;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.java.test.webApi.Enums.RequestIdEnum;
import com.java.test.webApi.Interface.Request.UploadFileRequestInterface;

public class UploadFileRequest implements UploadFileRequestInterface {

    private String token;
    private String path;
    private File file;

    public UploadFileRequest(String token, String path, File file) {
        this.token = token;
        this.file = file;
        this.path = path;
    }

    public String getMethod() {
        return RequestIdEnum.getMethod(this.getId());
    }

    public String getUri() {
        return RequestIdEnum.getUri(this.getId());
    }

    public Object getBody() {
        return file;
    }

    public Map<String, Object> getQueryParams() {
        return null;
    }

    public String getId() {
        return RequestIdEnum.POST_FILE_UPLOAD;
    }

    public String getAuth() {
        return this.token;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(
            "Dropbox-API-Arg",
            String.format(
                "{\"autorename\":false,\"mode\":\"add\",\"mute\":false,\"path\":\"%s%s\",\"strict_conflict\":false}",
                this.path,
                this.file.getName()
            )
        );

        return headers;
    }

    public String getContentType() {
        return "application/octet-stream";
    }
}
