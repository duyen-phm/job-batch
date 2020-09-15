package com.diendev.jobbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyJobRunner {

    private final JobLauncher jobLauncher;

    private final Job myJob;

    public MyJobRunner(JobLauncher jobLauncher, @Qualifier("runJob") Job myJob) {
        this.jobLauncher = jobLauncher;
        this.myJob = myJob;
    }

    public void runJob() throws Exception{
        jobLauncher.run(myJob, new JobParameters());
    }

}
