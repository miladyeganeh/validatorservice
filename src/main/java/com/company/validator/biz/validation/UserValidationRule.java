package com.company.validator.biz.validation;

import com.company.validator.domain.UserEntity;
import com.company.validator.model.UserDTO;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;
import com.company.validator.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidationRule implements ValidationRule {

    private final UserService userService;

    public UserValidationRule(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void validate(ResponseDTO response, RequestDTO request) {
        Optional<UserEntity> userEntityOptional = this.userService.findByUUID(request.getUserID());
        userEntityOptional.ifPresentOrElse(userEntity -> {
            if (userEntity.getUaBlackList() != null) {
                response.addValidationError("Invalid User...");
            }
            response.setUserDTO(UserDTO.from(userEntity));
        }, () -> response.addValidationError("Invalid User..."));
    }
}
