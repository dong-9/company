package com.example.board.aop;

import com.example.board.model.Log;
import com.example.board.service.LogService;
import com.fasterxml.jackson.core.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect // Aspect 명시
@Component // Bean 등록
@Slf4j
public class LoggingAspect {

	@Autowired
	private LogService logService;

	@Around("execution(* com.example.board.service.BoardServiceImpl.*(..))")
	public Object logging(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		Log systemLog = new Log();
		String request = "[REQUEST] " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		request += " " + pjp.getSignature().getDeclaringTypeName();
		request += " method: " + pjp.getSignature().getName();
		systemLog.setLogMessage(request);
		logService.insertLog(systemLog);
		log.info("[REQUEST] {} {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName());
		stopWatch.start();
		Object result = pjp.proceed();
		stopWatch.stop();
		String response = "[RESPONSE] " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		response += " " + pjp.getSignature().getName();
		response += " time : " + stopWatch.getTotalTimeMillis();
		systemLog.setLogMessage(response);
		logService.insertLog(systemLog);
		log.info("[RESPONSE] {}	{} result : {}", pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), result);
		return result;
	}
}
