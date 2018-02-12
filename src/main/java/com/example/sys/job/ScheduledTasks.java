package com.example.sys.job;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	static final Logger logger = Logger.getLogger(ScheduledTasks.class);

//	@Scheduled(fixedRate = 5000)
	public void rate() {
		logger.info("com.example.sys.job.ScheduledTasks.rate()");
	}
	
	@Scheduled(cron = "0/10 * * * * ?")
	public void cron() {
		logger.info("com.example.sys.job.ScheduledTasks.cron()");
	}

}
