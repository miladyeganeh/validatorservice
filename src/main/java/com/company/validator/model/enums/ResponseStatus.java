package com.company.validator.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum ResponseStatus {

    SUCCESS(0, "SUCCESS"),
    INPUT_VALIDATION_FAIL(1, "Input validation failed"),
    DATE_VALIDATION_FAIL(2, "Date validation failed");

    int value;
    String desc;

    ResponseStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static final Map<Integer, ResponseStatus> lookup = Arrays.stream(ResponseStatus.values()).
            collect(Collectors.toMap(ResponseStatus::getValue, responseCode -> responseCode));

    public static ResponseStatus getByValue(int value) {
        return lookup.get(value);
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
