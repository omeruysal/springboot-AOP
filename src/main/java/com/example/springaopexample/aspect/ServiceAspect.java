package com.example.springaopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
//@AfterReturning
//@AfterThrowing
//@After
//@Before
//@Aspect
//@Around
//@EnableAspectJAutoProxy    // <-- aspect kullanimi icin gerekli olan anotasyonlar
@Aspect
@Configuration
public class ServiceAspect {
    //com.example.springaopexample.service bu paket altindaki butun classlardaki getUser methodlarindan once
    //beforeda calisacak method icine cok zaman alacak islemler koymamaliyiz cevap verme suresini geciktirir
    @Before("execution(* com.example.springaopexample.service.*.getUser(..))")
    public void logBeforeGetUser(JoinPoint joinPoint){
        System.out.println("LOG : before getUser method, args : " + joinPoint.getArgs()[0] + " " +  joinPoint.getArgs()[1] +  joinPoint.getArgs()[2]);
        //gercek senaryoda parametre gelmedigi senaryo dusunulmeli.

        System.out.println(joinPoint.getSignature());
    }

    //com.example.springaopexample.service bu paket altindaki butun classlardaki getUser methodlarindan sonra
    @After("execution(* com.example.springaopexample.service.*.getUser(..))")
    public void logAfterGetUserOnService(JoinPoint joinPoint){
        System.out.println("LOG : after getUser method from all services");
     }

    //com.example.springaopexample.service.UserService1 classindaki getUser methodlarindan once
    @Before("execution(* com.example.springaopexample.service.UserService1.getUser(..))")
    public void logBeforeGetUserOnClass(JoinPoint joinPoint){
        System.out.println("LOG : before getUser method from UserService1 , args : " + joinPoint.getArgs()[0] + " " +  joinPoint.getArgs()[1]);
        //gercek senaryoda parametre gelmedigi senaryo dusunulmeli.

        System.out.println(joinPoint.getSignature());
    }

    //com.example.springaopexample.service.UserService1 classindaki butun methodlarindan once
    @Before("execution(* com.example.springaopexample.service.UserService1.*(..))")
    public void logBeforeAllMethods(JoinPoint joinPoint){
        System.out.println("LOG : before all methods");

        System.out.println(joinPoint.getSignature());
    }
}
