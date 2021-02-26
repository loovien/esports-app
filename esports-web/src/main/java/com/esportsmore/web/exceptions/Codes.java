package com.esportsmore.web.exceptions;

import com.esportsmore.core.errors.IBizException;

public enum Codes implements IBizException {
    ERR_NOT_LOGIN(-10000, "not login yet!"),
    ERR_RECORD_NOT_FOUND(10000, "data not found");

    private final int code;

    private final String message;

    Codes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
