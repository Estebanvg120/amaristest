package com.amaristest.amaristest.infrastructure.out.jpa.repository;

import com.amaristest.amaristest.infrastructure.out.jpa.entity.LoginLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginLogRepository extends JpaRepository<LoginLogEntity, Long> {
}
