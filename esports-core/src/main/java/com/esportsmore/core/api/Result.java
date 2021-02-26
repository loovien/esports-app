package com.esportsmore.core.api;

import com.esportsmore.core.errors.BizException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private int code;

    private String message;

    private T data;

    public static <T> Result<T> wrapOKResult(T data) {
        return new Result<>(0, "success", data);
    }

    public static <T> Result<T> wrapErrResult(int code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> wrapErrResult(BizException exception) {
        return new Result<>(exception.getCode(), exception.getMessage(), null);
    }

}
