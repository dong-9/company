package com.example.board.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
//@Configuration
public class TestJob implements Job {
	/*
		Quartz Scheduler는 기능을 수행하는 단위인 Job
		스케줄에 대한 정보를 가진 Trigger를 스케줄러에 걸어 실행하는 구조
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("스케줄에 따라 동작할 Job");
	}

//	@Bean
	// Job을 실행하기 위한 상세 정보, JobBuilder에 의해 생성됨
	public JobDetail jobDetail(){
		return JobBuilder
						.newJob(TestJob.class)
						.withIdentity("job_detail") // job 아이덴티
						.withDescription("Invoke Job service..") // job 설명
						.storeDurably()
						.build();
	}

//	@Bean
	public Trigger trigger(JobDetail job){
		return TriggerBuilder
							.newTrigger()
							.forJob(job) //"job_detail", job 아이덴티
							.withIdentity("trigger")
							.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")) // 10초간격으로 실행
							.build();
	}
}
