package com.self.user.auth;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class SelfCheckLoginAspect {

    @Around("@annotation(com.self.user.auth.SelfCheckLogin)")
    public Object checkLogin(ProceedingJoinPoint point) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userId = request.getHeader("userId");
        if (StringUtils.isBlank(userId)) {
            throw new RuntimeException("没有userId");
        }
        return point.proceed();
    }

    @Around("@annotation(com.self.user.auth.SelfCheckAuthorization)")
    public Object checkAuthorization(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        SelfCheckAuthorization annotation = method.getAnnotation(SelfCheckAuthorization.class);
        String value = annotation.value();
        System.out.println("checkAuthorization: " + value);
        return point.proceed();
    }

}
