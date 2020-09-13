package com.company.validator.repository;

import com.company.validator.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUuid(String uuid);
    Optional<UserEntity> findByRemoteIP(String ip);
}
