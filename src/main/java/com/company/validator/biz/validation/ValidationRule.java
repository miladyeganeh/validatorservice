package com.company.validator.biz.validation;

import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;

import java.util.function.BiConsumer;

public interface ValidationRule {
    void validate(ResponseDTO response, RequestDTO request);

    default BiConsumer<ResponseDTO, RequestDTO> performValidation() {
        return this::validate;
    }
}
