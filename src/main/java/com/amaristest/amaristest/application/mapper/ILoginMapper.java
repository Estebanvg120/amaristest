package com.amaristest.amaristest.application.mapper;

import com.amaristest.amaristest.application.dto.request.LoginDummyAuthRequest;
import com.amaristest.amaristest.application.dto.response.LoginDummyAuthResponse;
import com.amaristest.amaristest.application.dto.response.UserDummyResponse;
import com.amaristest.amaristest.application.dto.response.UsersListDummyResponse;
import com.amaristest.amaristest.domain.models.LoginModel;
import com.amaristest.amaristest.domain.models.UserModel;
import com.amaristest.amaristest.domain.models.UsersListModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ILoginMapper {
    LoginModel toLoginModel (LoginDummyAuthRequest loginDummyAuthRequest);
    LoginDummyAuthResponse toLoginResponse (LoginModel loginModel);
    UserDummyResponse toUserResponse (UserModel userModel);
    UsersListDummyResponse toListUsersResponse (UsersListModel userModels);
}
