package com.amaristest.amaristest.domain.usecases;

import com.amaristest.amaristest.domain.api.ILoginServicePort;
import com.amaristest.amaristest.domain.models.LoginLogModel;
import com.amaristest.amaristest.domain.models.LoginModel;
import com.amaristest.amaristest.domain.models.UserModel;
import com.amaristest.amaristest.domain.models.UsersListModel;
import com.amaristest.amaristest.domain.spi.IDummyClientPort;
import com.amaristest.amaristest.domain.spi.ILoginLogPersistence;

import java.time.LocalDateTime;

public class LoginUseCase implements ILoginServicePort {

    private final IDummyClientPort dummyClientPort;
    private final ILoginLogPersistence loginLogPersistence;

    private void saveLog (LoginModel loginModel){
        LoginLogModel loginLogModel = new LoginLogModel();
        loginLogModel.setUsername(loginModel.getUsername());
        loginLogModel.setAccess_token(loginModel.getAccessToken());
        loginLogModel.setRefresh_token(loginModel.getRefreshToken());
        loginLogModel.setLogin_time(LocalDateTime.now());

        loginLogPersistence.save(loginLogModel);

    }

    public LoginUseCase(IDummyClientPort dummyClientPort, ILoginLogPersistence loginLogPersistence) {
        this.dummyClientPort = dummyClientPort;
        this.loginLogPersistence = loginLogPersistence;
    }

    @Override
    public LoginModel login(LoginModel loginModel) {
        LoginModel response = dummyClientPort.login(loginModel);
        saveLog(response);
        return response;
    }

    @Override
    public UserModel getUser() {
        return dummyClientPort.getUser();
    }

    @Override
    public UsersListModel getUsers() {
        return dummyClientPort.getUsers();
    }
}
