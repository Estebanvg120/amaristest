package com.amaristest.amaristest.infrastructure.inputrest;

import com.amaristest.amaristest.application.dto.request.LoginDummyAuthRequest;
import com.amaristest.amaristest.application.dto.response.LoginDummyAuthResponse;
import com.amaristest.amaristest.application.dto.response.UserDummyResponse;
import com.amaristest.amaristest.application.dto.response.UsersListDummyResponse;
import com.amaristest.amaristest.application.handler.ILoginHandler;
import com.amaristest.amaristest.infrastructure.constants.Constants;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.REST_API_LOGIN)
public class LoginRestController {

    private final ILoginHandler loginHandler;

    public LoginRestController(ILoginHandler loginHandler) {
        this.loginHandler = loginHandler;
    }

    @PostMapping(Constants.API_POST_LOGIN)
    public ResponseEntity<LoginDummyAuthResponse> auth (@Validated @RequestBody LoginDummyAuthRequest loginDummyAuthRequest, HttpServletResponse response){
       LoginDummyAuthResponse login = loginHandler.login(loginDummyAuthRequest);
        Cookie cookie = new Cookie(Constants.COOKIE_ACCESS_TOKEN_NAME, login.getAccessToken());
       response.addCookie(cookie);
        cookie.setPath(Constants.COOKIE_PATHS);
        cookie.setMaxAge(Constants.COOKIE_TIME);
       return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @GetMapping(Constants.API_GET_USER)
    public ResponseEntity<UserDummyResponse> getUser (){
        UserDummyResponse userDummyResponse = loginHandler.getUser();
        return new ResponseEntity<>(userDummyResponse, HttpStatus.OK);
    }

    @GetMapping(Constants.API_GET_USERS)
    public ResponseEntity<UsersListDummyResponse> getUsers (){
        UsersListDummyResponse usersDummyResponse = loginHandler.getUsers();
        return new ResponseEntity<>(usersDummyResponse, HttpStatus.OK);
    }
}
