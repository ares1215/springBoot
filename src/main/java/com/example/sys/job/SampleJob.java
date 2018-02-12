package com.example.sys.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SampleJob implements Job {

	static final Logger logger = Logger.getLogger(SampleJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		logger.info("com.example.sys.job.SampleJob.execute(JobExecutionContext)");
	}
}
