package com.example.feelerbackend.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class DataSource {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DataSource(String type){
        logger.info(String.format("Using %s: %s", type, this.getClass().getSimpleName()));
    }
}
