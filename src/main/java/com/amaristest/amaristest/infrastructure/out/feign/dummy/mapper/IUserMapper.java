package com.amaristest.amaristest.infrastructure.out.feign.dummy.mapper;

import com.amaristest.amaristest.application.dto.response.UserDummyResponse;
import com.amaristest.amaristest.domain.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IUserMapper {
    UserModel toUserModel (UserDummyResponse userDummyResponse);
}
