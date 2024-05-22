package com.judomanager.batch.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfig {

    /**
     * 배치 job 리스트
     * 1. 슬랙으로 유저 활동 정보 NOTIFICATION
     * 2. 쌓인 출석 정보를 주기적으로 저장 테이블로 이동
     */


    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("slackJob", jobRepository)
                .start(step)
                .build();
    }

    @Bean
    public Tasklet myTasklet(){
        return ((contribution, chunkContext) -> {
            return RepeatStatus.FINISHED;
        });
    }


    @Bean
    public Step step(JobRepository jobRepository, Tasklet myTasklet, PlatformTransactionManager transactionManager){
        return new StepBuilder("slackStep", jobRepository)
                .tasklet(myTasklet, transactionManager)
                .build();
    }
}