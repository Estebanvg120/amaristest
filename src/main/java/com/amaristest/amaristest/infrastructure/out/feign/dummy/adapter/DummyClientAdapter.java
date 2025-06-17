package com.amaristest.amaristest.infrastructure.out.feign.dummy.adapter;

import com.amaristest.amaristest.domain.models.LoginModel;
import com.amaristest.amaristest.domain.models.UserModel;
import com.amaristest.amaristest.domain.models.UsersListModel;
import com.amaristest.amaristest.domain.spi.IDummyClientPort;
import com.amaristest.amaristest.infrastructure.constants.Constants;
import com.amaristest.amaristest.infrastructure.exception.ErrorFeignException;
import com.amaristest.amaristest.infrastructure.out.feign.dummy.IAuthClient;
import com.amaristest.amaristest.infrastructure.out.feign.dummy.mapper.IDummyClientMapper;
import feign.FeignException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyClientAdapter implements IDummyClientPort {

    private final IAuthClient authClient;
    private final IDummyClientMapper dummyClientMapper;

    public DummyClientAdapter(IAuthClient authClient, IDummyClientMapper dummyClientMapper) {
        this.authClient = authClient;
        this.dummyClientMapper = dummyClientMapper;
    }

    @Override
    public LoginModel login(LoginModel loginModel) {
        try {
            var response = authClient.login(dummyClientMapper.toLoginDummyRequest(loginModel));
            return dummyClientMapper.toLoginModel(response);
        }catch (FeignException e) {
            throw new ErrorFeignException(Constants.ERROR_CALLING_DUMMY_FEIGN + e.contentUTF8());
        }

    }

    @Override
    public UserModel getUser() {
        try {
            var response = authClient.getUser();
            return dummyClientMapper.toUserModel(response);
        }catch (FeignException e) {
            throw new ErrorFeignException(Constants.ERROR_CALLING_DUMMY_FEIGN + e.contentUTF8());
        }
    }

    @Override
    public UsersListModel getUsers() {
        try {
            var response = authClient.getUsers();
            return dummyClientMapper.toListUserModel(response);
        }catch (FeignException e) {
            throw new ErrorFeignException(Constants.ERROR_CALLING_DUMMY_FEIGN + e.contentUTF8());
        }
    }
}
