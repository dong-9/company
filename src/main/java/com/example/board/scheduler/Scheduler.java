package com.example.board.scheduler;

import com.example.board.mapper.LogMapper;
import com.example.board.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component
@Slf4j
public class Scheduler {

	@Autowired
	LogService logService;

//	@Scheduled(cron = "0/30 * * * * *")
	//@Scheduled(cron = "1 0 0 ? * 0") 매달 매주 일요일 0시 0분 1초
	public void scheduleTest(){
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime ago = now.minusDays(7);
		logService.deleteLog(
							ago.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
							now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		log.info("스케줄 테스트");
	}
}
