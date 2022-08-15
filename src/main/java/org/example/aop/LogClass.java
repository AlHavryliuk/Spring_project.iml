package org.example.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogClass {

    @Before("execution (* org.example.controllers.StudentController.*())")
    public void logMethod (JoinPoint joinPoint) {
        System.out.println("xxxxxxx");
        System.out.println("Details:" + joinPoint.getSignature().getName());
        System.out.println("xxxxxxx");
    }
}
