package com.amaristest.amaristest.domain.spi;

import com.amaristest.amaristest.domain.models.LoginLogModel;

public interface ILoginLogPersistence {
    void save (LoginLogModel loginLogModel);
}
