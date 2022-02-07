package com.example.demo.config.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {
//	@Before (이전) : 어드바이스 타겟 메소드가 호출되기 전에 어드바이스 기능을 수행
//	@After (이후) : 타겟 메소드의 결과에 관계없이(즉 성공, 예외 관계없이) 타겟 메소드가 완료 되면 어드바이스 기능을 수행
//	@AfterReturning (정상적 반환 이후)타겟 메소드가 성공적으로 결과값을 반환 후에 어드바이스 기능을 수행
//	@AfterThrowing (예외 발생 이후) : 타겟 메소드가 수행 중 예외를 던지게 되면 어드바이스 기능을 수행
//	@Around (메소드 실행 전후) : 어드바이스가 타겟 메소드를 감싸서 타겟 메소드 호출전과 후에 어드바이스 기능을 수행
	
//	-> "*" 는 모든 값을 의미
//	-> ".." 는 0개 이상 의미
//	 execution([수식어] [리턴타입] [클래스이름] [이름]([파라미터])
	@Before("execution(* com.example.demo.portal.PortalController.*(..))")
    public void doSomethingBefore(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
        System.out.println("AOP Test : PortalController 내의 모든 메소드 실행 전 /"+methodName);
    }
    @After("execution(* com.example.demo.portal.PortalController.signup(..))")
    public void doSomethingAfter(JoinPoint jp) {
    	System.out.println(Arrays.toString(jp.getArgs()));
    	String methodName = jp.getSignature().getName();
    	System.out.println("AOP Test : 아이디 등록 후 /"+methodName);
    }

}
