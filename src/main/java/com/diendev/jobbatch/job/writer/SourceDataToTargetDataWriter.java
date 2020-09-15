package com.diendev.jobbatch.job.writer;

import com.diendev.jobbatch.domain.TargetData;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class SourceDataToTargetDataWriter implements ItemWriter<TargetData> {
    @Override
    public void write(List<? extends TargetData> list) throws Exception {
        for (TargetData targetData: list) {
            // write logic here
            System.out.println("-- Target " + targetData.toString());
        }
    }
}
