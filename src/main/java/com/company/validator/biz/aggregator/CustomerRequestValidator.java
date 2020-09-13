package com.company.validator.biz.aggregator;

import com.company.validator.biz.validation.ValidationRule;
import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

@Service("customerRequestValidator")
public class CustomerRequestValidator implements ValidationAggregator{

    private final BiConsumer<ResponseDTO, RequestDTO> validationChain;

    public CustomerRequestValidator(ValidationRule userValidationRule,
                                    ValidationRule customerValidationRule,
                                    ValidationRule iPValidationRule) {
       this.validationChain =
               userValidationRule.performValidation()
                            .andThen(customerValidationRule.performValidation())
                            .andThen(iPValidationRule.performValidation());
    }

    @Override
    public BiConsumer<ResponseDTO, RequestDTO> getValidationChain() {
        return validationChain;
    }
}
