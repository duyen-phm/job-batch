package com.diendev.jobbatch.job;

import com.diendev.jobbatch.domain.SourceData;
import com.diendev.jobbatch.domain.TargetData;
import com.diendev.jobbatch.job.processor.SourceDataProcessor;
import com.diendev.jobbatch.job.reader.SourceDataReader;
import com.diendev.jobbatch.job.writer.SourceDataToTargetDataWriter;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobStepConfiguration {

    private final StepBuilderFactory stepBuilderFactory;

    private final static String STEP_NAME = "stepName";

    public JobStepConfiguration(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean(name = "myStepBean")
    @JobScope
    public Step stepProcessTargetData() {
        return stepBuilderFactory
                .get(STEP_NAME)
                .allowStartIfComplete(true)
                .<SourceData, TargetData>chunk(10)
                .reader(sourceDataReader())
                .processor(sourceDataProcessor())
                .writer(sourceDataToTargetDataWriter())
                .build();
    }

    private ItemReader<SourceData> sourceDataReader() {
        System.out.println("Reading .....");
        return new SourceDataReader();
    }

    private ItemProcessor<SourceData, TargetData> sourceDataProcessor() {
        System.out.println("Processor .....");
        return new SourceDataProcessor();
    }

    private ItemWriter<TargetData> sourceDataToTargetDataWriter() {
        System.out.println("Writing ....");
        return new SourceDataToTargetDataWriter();
    }
}
