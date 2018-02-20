package com.example.sys.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SampleJobService {

	private static final Logger logger = LoggerFactory.getLogger(SampleJobService.class);

	public void task() {
		logger.info("com.example.sys.job.SampleJobService.task()");
	}

}
