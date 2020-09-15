package com.diendev.jobbatch.job.processor;

import com.diendev.jobbatch.domain.SourceData;
import com.diendev.jobbatch.domain.TargetData;
import org.springframework.batch.item.ItemProcessor;

public class SourceDataProcessor implements ItemProcessor<SourceData, TargetData> {

    @Override
    public TargetData process(SourceData sourceData) throws Exception {
        return new TargetData(sourceData.getId(), sourceData.getName());
    }
}
