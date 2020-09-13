package com.company.validator.exception;

public class ServerBusyException extends RuntimeException{
    public ServerBusyException() {
        super();
    }

    public ServerBusyException(String message) {
        super(message);
    }

    public ServerBusyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerBusyException(Throwable cause) {
        super(cause);
    }

    protected ServerBusyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
