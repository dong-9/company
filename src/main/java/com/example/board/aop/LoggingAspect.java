package com.example.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect // Aspect 명시
@Component // Bean 등록
@Slf4j
public class LoggingAspect {


	@Around("execution(* com.example.board.service.*Impl.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		long startAt = System.currentTimeMillis();
		log.info("[REQUEST] --> {}	{}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
		// 요기 사이에 log msg 디비에 저장
		Object result = pjp.proceed();
		long endAt = System.currentTimeMillis();
		log.info("[RESPONSE] --> {}	{}	result = {}  {}ms",
																pjp.getSignature().getDeclaringTypeName(),
																pjp.getSignature().getName(),
																result,
																endAt-startAt);
		return result;
	}
}
