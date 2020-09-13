package com.company.validator.biz.validation;

import com.company.validator.domain.UserEntity;
import com.company.validator.model.UserDTO;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;
import com.company.validator.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service("iPValidationRule")
public class IPValidationRule implements ValidationRule {

    private final UserService userService;

    public IPValidationRule(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void validate(ResponseDTO response, RequestDTO request) {
        if (!validateIP(request.getRemoteIP())) {
            response.addValidationError("Invalid Remote IP...");
        } else {
            Optional<UserEntity> userEntityOptional = this.userService.findByUUID(request.getUserID());
            userEntityOptional.ifPresentOrElse(userEntity -> {
                if (userEntity.getIpBlackList() != null) {
                    response.addValidationError("Invalid Remote IP...");
                }
                response.setUserDTO(UserDTO.from(userEntity));
            }, () -> response.addValidationError("Invalid Remote IP..."));
        }
    }

    private boolean validateIP(final String ip) {
        if (ip== null){
            return false;
        }
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }
}
