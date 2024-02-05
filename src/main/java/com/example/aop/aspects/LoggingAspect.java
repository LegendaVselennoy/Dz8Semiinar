package com.example.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Around(value = "@annotation(TrackUserAction)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Before the call"+joinPoint.getSignature());
        Object returnVal=joinPoint.proceed();
        System.out.println("After the call"+ Arrays.toString(joinPoint.getArgs()));
        return returnVal;
    }
}
