package com.amaristest.amaristest.application.handler;

import com.amaristest.amaristest.application.dto.request.LoginDummyAuthRequest;
import com.amaristest.amaristest.application.dto.response.LoginDummyAuthResponse;
import com.amaristest.amaristest.application.dto.response.UserDummyResponse;
import com.amaristest.amaristest.application.dto.response.UsersListDummyResponse;

import java.util.List;

public interface ILoginHandler {
    LoginDummyAuthResponse login (LoginDummyAuthRequest loginDummyAuthRequest);
    UserDummyResponse getUser ();
    UsersListDummyResponse getUsers();
}
