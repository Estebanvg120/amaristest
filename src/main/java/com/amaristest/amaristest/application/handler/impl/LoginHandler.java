package com.amaristest.amaristest.application.handler.impl;

import com.amaristest.amaristest.application.dto.request.LoginDummyAuthRequest;
import com.amaristest.amaristest.application.dto.response.LoginDummyAuthResponse;
import com.amaristest.amaristest.application.dto.response.UserDummyResponse;
import com.amaristest.amaristest.application.dto.response.UsersListDummyResponse;
import com.amaristest.amaristest.application.handler.ILoginHandler;
import com.amaristest.amaristest.application.mapper.ILoginMapper;
import com.amaristest.amaristest.domain.api.ILoginServicePort;
import com.amaristest.amaristest.domain.models.LoginModel;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LoginHandler implements ILoginHandler {

    private final ILoginMapper loginMapper;
    private final ILoginServicePort loginServicePort;

    public LoginHandler(ILoginMapper loginMapper, ILoginServicePort loginServicePort) {
        this.loginMapper = loginMapper;
        this.loginServicePort = loginServicePort;
    }

    @Override
    public LoginDummyAuthResponse login(LoginDummyAuthRequest loginDummyAuthRequest) {
        LoginModel loginModel = loginMapper.toLoginModel(loginDummyAuthRequest);
        return loginMapper.toLoginResponse(loginServicePort.login(loginModel));
    }

    @Override
    public UserDummyResponse getUser() {
        return loginMapper.toUserResponse(loginServicePort.getUser());
    }

    @Override
    public UsersListDummyResponse getUsers() {
        return loginMapper.toListUsersResponse(loginServicePort.getUsers());
    }
}
