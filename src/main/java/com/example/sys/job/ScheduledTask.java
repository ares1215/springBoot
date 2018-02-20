package com.example.sys.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);

	// @Scheduled(fixedRate = 5000)
	public void rate() {
		logger.info("com.example.sys.job.ScheduledTasks.rate()");
	}

	// @Scheduled(cron = "0/10 * * * * ?")
	public void cron() {
		logger.info("com.example.sys.job.ScheduledTasks.cron()");
	}

}
