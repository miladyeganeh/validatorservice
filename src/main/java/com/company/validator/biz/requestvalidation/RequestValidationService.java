package com.company.validator.biz.requestvalidation;

import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;

import java.util.List;

public interface RequestValidationService {
    ResponseDTO persistRequest(RequestDTO req);
    List<String> validate(ResponseDTO response, RequestDTO req);
}
