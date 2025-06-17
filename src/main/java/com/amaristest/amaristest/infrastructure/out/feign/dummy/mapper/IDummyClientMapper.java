package com.amaristest.amaristest.infrastructure.out.feign.dummy.mapper;

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
public interface IDummyClientMapper {
    LoginModel toLoginModel (LoginDummyAuthResponse loginDummyAuthResponse);
    LoginDummyAuthRequest toLoginDummyRequest (LoginModel loginModel);
    UserModel toUserModel (UserDummyResponse userDummyResponse);
    UsersListModel toListUserModel (UsersListDummyResponse usersListDummyResponse);
}
