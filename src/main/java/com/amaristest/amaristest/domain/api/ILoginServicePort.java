package com.amaristest.amaristest.domain.api;

import com.amaristest.amaristest.domain.models.LoginModel;
import com.amaristest.amaristest.domain.models.UserModel;
import com.amaristest.amaristest.domain.models.UsersListModel;

import java.util.List;

public interface ILoginServicePort {
    LoginModel login (LoginModel loginModel);
    UserModel getUser ();
    UsersListModel getUsers ();
}
