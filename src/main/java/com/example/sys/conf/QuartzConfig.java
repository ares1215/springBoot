package com.example.sys.conf;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.example.sys.job.SampleJob;

//@Configuration
public class QuartzConfig {

	static final Logger logger = Logger.getLogger(QuartzConfig.class);

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		// scheduler.setTriggers(simpleTriggerFactoryBean().getObject(), cronTriggerFactoryBean().getObject());
		scheduler.setTriggers(cronTriggerFactoryBean().getObject());

		return scheduler;
	}

	@Bean
	public SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
		SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
		simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
		// stFactory.setStartDelay(3000);
		simpleTriggerFactoryBean.setRepeatInterval(5000);
		// stFactory.setRepeatCount(3);

		return simpleTriggerFactoryBean;
	}

	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
		methodInvokingJobDetailFactoryBean.setTargetBeanName("sampleJobService");
		methodInvokingJobDetailFactoryBean.setTargetMethod("task");

		return methodInvokingJobDetailFactoryBean;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean() {
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(jobDetailFactoryBean().getObject());
		// stFactory.setStartDelay(3000);
		// stFactory.setName("sampleJob");
		// stFactory.setGroup("sampleJobGroup");
		stFactory.setCronExpression("0/10 * * * * ? *");

		return stFactory;
	}

	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(SampleJob.class);
		// factory.setName("sampleJobDetail");
		// factory.setGroup("sampleJobDetailGroup");

		return factory;
	}
}
