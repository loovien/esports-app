package com.esportsmore.core.errors;

public class BizException extends RuntimeException {
    private final int code;

    public BizException(int code) {
        this.code = code;
    }

    public BizException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(IBizException exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
