package com.amaristest.amaristest.infrastructure.out.jpa.mapper;

import com.amaristest.amaristest.domain.models.LoginLogModel;
import com.amaristest.amaristest.infrastructure.out.jpa.entity.LoginLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ILoginLogEntityMapper {

LoginLogEntity toLoginLogEntity (LoginLogModel loginLogModel);
}
