package com.java.test.webApi.Enums;

public class RequestIdEnum {
    public static final String POST_METADATA = "POST::/2/files/get_metadata";
    public static final String POST_FILE_DELETE = "POST::/2/files/delete_v2";
    public static final String POST_FILE_UPLOAD = "POST::/2/files/upload";
    public static final String GET_AUTHORIZATION = "GET::/oauth2/authorize";
    public static final String POST_GETAUTHTOKEN = "POST::/oauth2/token";

    public static String getMethod(final String id) {
        String[] result = id.split("::");
        return result[0];
    }

    public static String getUri(final String id) {
        String[] result = id.split("::");
        return result[1];
    }
}
