package com.judomanager.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;


@Slf4j
@Component
@RequiredArgsConstructor
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final JobConfig jobConfig;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final Tasklet myTasklet;

//    @Scheduled(cron = "0 0 9 * * *", zone = "Asia/Seoul")
    public void runJob() throws
            JobParametersInvalidException,
            JobExecutionAlreadyRunningException,
            JobRestartException,
            JobInstanceAlreadyCompleteException {

        jobLauncher.run(
                jobConfig.job(
                        jobRepository,
                        jobConfig.step(jobRepository, myTasklet, transactionManager)),
                new JobParametersBuilder().addDate("date", new Date()).toJobParameters());
    }

}
