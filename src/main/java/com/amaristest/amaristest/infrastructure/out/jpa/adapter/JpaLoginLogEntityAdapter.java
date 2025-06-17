package com.amaristest.amaristest.infrastructure.out.jpa.adapter;

import com.amaristest.amaristest.domain.models.LoginLogModel;
import com.amaristest.amaristest.domain.spi.ILoginLogPersistence;
import com.amaristest.amaristest.infrastructure.out.jpa.mapper.ILoginLogEntityMapper;
import com.amaristest.amaristest.infrastructure.out.jpa.repository.ILoginLogRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaLoginLogEntityAdapter implements ILoginLogPersistence {

    private final ILoginLogRepository loginLogRepository;
    private final ILoginLogEntityMapper loginLogEntityMapper;

    public JpaLoginLogEntityAdapter(ILoginLogRepository loginLogRepository, ILoginLogEntityMapper loginLogEntityMapper) {
        this.loginLogRepository = loginLogRepository;
        this.loginLogEntityMapper = loginLogEntityMapper;
    }

    @Override
    public void save(LoginLogModel loginLogModel) {
        loginLogRepository.save(loginLogEntityMapper.toLoginLogEntity(loginLogModel));
    }
}
