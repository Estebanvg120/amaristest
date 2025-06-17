package com.amaristest.amaristest.infrastructure.constants;

public class Constants {

    public static final String REST_API_LOGIN = "/api/login";
    public static final String API_POST_LOGIN = "/auth";
    public static final String API_GET_USER = "/user";
    public static final String API_GET_USERS = "/users";


    //Errors
    public static final String ERROR_CALLING_DUMMY_FEIGN = "Error calling dummy service";

    //Cookies name
    public static final String COOKIE_ACCESS_TOKEN_NAME = "accessToken";

    //Configuration Cookie
    public static final Integer COOKIE_TIME = 60*60;
    public static final String COOKIE_PATHS = "/";

    //Feigns paths

    public static final String AUTH_PATH = "/auth/login";
    public static final String USER_PATH = "/auth/me";
    public static final String USERS_PATH = "/users";


}
