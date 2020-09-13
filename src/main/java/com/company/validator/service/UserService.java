package com.company.validator.service;

import com.company.validator.domain.UserEntity;

import java.util.Optional;

public interface UserService {
    Optional<UserEntity> findByUUID(String uuid);
    Optional<UserEntity> findByRemoteIP(String ip);
}
