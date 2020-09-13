package com.company.validator.biz.aggregator;

import com.company.validator.model.request.RequestDTO;
import com.company.validator.model.response.ResponseDTO;

import java.util.List;
import java.util.function.BiConsumer;

public interface ValidationAggregator {
    BiConsumer<ResponseDTO, RequestDTO> getValidationChain();

    default List<String> aggregate(ResponseDTO res, RequestDTO req) {
        getValidationChain().accept(res, req);
        return res.getValidationErrors();
    }
}
