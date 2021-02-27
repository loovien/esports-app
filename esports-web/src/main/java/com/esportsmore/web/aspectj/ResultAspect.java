package com.esportsmore.web.aspectj;

import com.esportsmore.core.api.Result;
import com.esportsmore.core.errors.BizException;
import com.esportsmore.web.constants.Website;
import com.esportsmore.web.exceptions.Codes;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Aspect
@Component
public class ResultAspect {

    final HttpSession httpSession;

    @Autowired
    public ResultAspect(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)" +
            "&& execution(com.esportsmore.core.api.Result *.*(..))")
    public void api() {
    }

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)" +
            "&& execution(com.esportsmore.core.api.Result com.esportsmore.web.controller.api.stateful.*.*(..))")
    public void stateful() {
    }

    protected Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Result<Object> result = new Result<>();
        try {
            return proceedingJoinPoint.proceed();
        } catch (BizException e) {
            result.setCode(e.getCode());
            result.setMessage(e.getMessage());
        } catch (Throwable throwable) {
            result.setCode(1000000);
            result.setMessage(throwable.getMessage());
        }
        return result;
    }

    @Around(value = "api()")
    public Object api(ProceedingJoinPoint proceedingJoinPoint) {
        return this.around(proceedingJoinPoint);
    }

    @Around(value = "stateful()")
    public Object stateful(ProceedingJoinPoint proceedingJoinPoint) {
        Object identity = this.httpSession.getAttribute(Website.SESSION_USER_IDENTITY);
        if (identity == null) {
            return new Result<>(Codes.ERR_NOT_LOGIN.getCode(), Codes.ERR_NOT_LOGIN.getMessage(), null);
        }
        return this.around(proceedingJoinPoint);
    }

}
