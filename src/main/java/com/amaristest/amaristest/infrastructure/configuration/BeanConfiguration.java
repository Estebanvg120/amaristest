package com.amaristest.amaristest.infrastructure.configuration;

import com.amaristest.amaristest.domain.api.ILoginServicePort;
import com.amaristest.amaristest.domain.spi.IDummyClientPort;
import com.amaristest.amaristest.domain.spi.ILoginLogPersistence;
import com.amaristest.amaristest.domain.usecases.LoginUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IDummyClientPort dummyClientPort;
    private final ILoginLogPersistence loginLogPersistence;

    public BeanConfiguration(IDummyClientPort dummyClientPort, ILoginLogPersistence loginLogPersistence) {
        this.dummyClientPort = dummyClientPort;
        this.loginLogPersistence = loginLogPersistence;
    }

    @Bean
    public ILoginServicePort loginServicePort(){
        return new LoginUseCase(dummyClientPort, loginLogPersistence);
    }
}
