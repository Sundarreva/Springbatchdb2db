package com.example.jdbc2datasource.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobExecutionListnerSupport implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Before Job");
		log.info("started");
		log.info("Status: {}", jobExecution.getStatus());
		log.info("getId {}", jobExecution.getId());
		log.info("Job Id {}", jobExecution.getJobId());
		log.info("Job Instance {} ", jobExecution.getJobInstance());
		log.info("Job paramenter {}", jobExecution.getJobParameters());
		log.info("Job Config name {} ", jobExecution.getJobConfigurationName());	
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("After job");
		log.info("started");
		log.debug("Status: {}", jobExecution.getStatus());
		log.debug("getId {}", jobExecution.getId());
		log.debug("Job Id {}", jobExecution.getJobId());
		log.debug("Job Instance {}", jobExecution.getJobInstance());
		log.debug("Job paramenter {} ", jobExecution.getJobParameters());
		log.debug("Job Config name {} ", jobExecution.getJobConfigurationName());
		log.debug("Status: {} ",jobExecution.getStatus());

	}

}
