package com.esportsmore.web.aspectj;

import com.esportsmore.core.api.Result;
import com.esportsmore.core.errors.BizException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResultAspect {

    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)" +
            "&& execution(com.esportsmore.core.api.Result *.* (..))")
    public void api() {
    }

    @Around(value = "api()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
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

}
