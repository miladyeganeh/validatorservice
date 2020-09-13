package com.company.validator.service.impl;

import com.company.validator.domain.UserEntity;
import com.company.validator.repository.UserRepository;
import com.company.validator.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> findByUUID(String uuid) {
        return this.userRepository.findByUuid(uuid);
    }

    @Override
    public Optional<UserEntity> findByRemoteIP(String ip) {
        return this.userRepository.findByRemoteIP(ip);
    }
}
