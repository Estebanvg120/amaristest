package com.amaristest.amaristest.infrastructure.out.feign.dummy;

import com.amaristest.amaristest.application.dto.request.LoginDummyAuthRequest;
import com.amaristest.amaristest.application.dto.response.LoginDummyAuthResponse;
import com.amaristest.amaristest.application.dto.response.UserDummyResponse;
import com.amaristest.amaristest.application.dto.response.UsersListDummyResponse;
import com.amaristest.amaristest.infrastructure.constants.Constants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "dummyAuth", url = "https://dummyjson.com")
public interface IAuthClient {
    @PostMapping(Constants.AUTH_PATH)
    LoginDummyAuthResponse login(@RequestBody LoginDummyAuthRequest loginDummyAuthRequest);

    @GetMapping(Constants.USER_PATH)
    UserDummyResponse getUser();

    @GetMapping(Constants.USERS_PATH)
    UsersListDummyResponse getUsers();

}
