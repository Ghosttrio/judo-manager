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


    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("myJob", jobRepository)
                .start(step)
//                .next(step1)
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
        return new StepBuilder("myStep", jobRepository)
                .tasklet(myTasklet, transactionManager)
                .build();
    }
}