package com.example.sys.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SampleJob implements Job {

	private static final Logger logger = LoggerFactory.getLogger(SampleJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("com.example.sys.job.SampleJob.execute(JobExecutionContext)");
	}
}
