package com.company.validator.exception;

import com.company.validator.model.enums.ResponseStatus;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.Locale;

@ControllerAdvice
public class AppExceptionHandler {

    private final MessageSource messageSource;

    public AppExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleBadInput(WebRequest request, Locale locale) {
        String message = messageSource.getMessage("request.validation", new Object[]{},locale);
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .withDate(new Date())
                .withTitle(ResponseStatus.INPUT_VALIDATION_FAIL.getDesc())
                .withStatus(ResponseStatus.INPUT_VALIDATION_FAIL.getValue())
                .withDescription(message)
                .build();
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(RequestValidationException.class)
    public ResponseEntity<ErrorMessage> handleRequestValidationException(Exception ex){
        ErrorMessage errorMessage = ErrorMessage
                .builder()
                .withDate(new Date())
                .withTitle(ResponseStatus.INPUT_VALIDATION_FAIL.getDesc())
                .withStatus(ResponseStatus.INPUT_VALIDATION_FAIL.getValue())
                .withDescription(ex.getMessage())
                .build();
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
