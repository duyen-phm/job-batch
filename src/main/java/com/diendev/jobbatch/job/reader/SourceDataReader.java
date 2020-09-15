package com.diendev.jobbatch.job.reader;

import com.diendev.jobbatch.domain.SourceData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SourceDataReader extends AbstractIteratorItemReader<SourceData> {

    @Override
    protected Iterator<SourceData> newIterator() throws Exception {
        // data reading logic here,
        // i just simple add a mock iterator due to the fact i don't want to create DB implementation :p

        List<SourceData> sourceDataList = new ArrayList<>();
        sourceDataList.add(new SourceData(1l, "source-1"));
        sourceDataList.add(new SourceData(2l, "source-2"));
        sourceDataList.add(new SourceData(3l, "source-3"));
        return sourceDataList.iterator();
    }
}
