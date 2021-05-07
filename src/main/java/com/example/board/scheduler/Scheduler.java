package com.example.board.scheduler;

import com.example.board.service.LogService;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class Scheduler {

	@Autowired
	LogService logService;

//	@Scheduled(cron = "0/30 * * * * *")
//	@Scheduled(cron = "1 0 0 ? * 0") //매달 매주 일요일 0시 0분 1초
	// 미실행시 쓰레기 데이터 처리위해 Between 대신 <=, 일주일치를 조금씩 나눠서 처리해야할때도 있음
	public void scheduleTest(){
		LocalDateTime now = LocalDateTime.now();
		logService.deleteLog(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		log.info("Log Table 삭제");
	}

	@Scheduled(cron = "* 1 * * * *")
	@SchedulerLock(
			name = "1분",
			lockAtLeastFor = "70s",
			lockAtMostFor = "70s"
	)
	public void scheduleLockTest(){
		log.info("Lock Test");
	}
}
