package com.example.sys.job;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SampleJobService {

	static final Logger logger = Logger.getLogger(SampleJobService.class);

	public void task() {
		logger.info("execute task...");
	}

}
