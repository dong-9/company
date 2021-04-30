package com.example.board.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Scheduler {

	// TODO Quartz Test

	@Scheduled(cron = "0/30 * * * * *")
	public void scheduleTest(){
		log.info("스케줄 테스트");
	}
}
