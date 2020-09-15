package com.diendev.jobbatch.job.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;

public abstract class AbstractIteratorItemReader<T> implements ItemReader<T> {

    protected Iterator<T> iterator;

    @Override
    public synchronized T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (iterator == null) {
            iterator = newIterator();
        }

        if (iterator.hasNext()) {
            return iterator.next();
        }

        iterator = null;
        return null;
    }

    protected abstract Iterator<T> newIterator() throws Exception;
}
