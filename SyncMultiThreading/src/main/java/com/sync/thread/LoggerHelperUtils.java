package com.sync.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoggerHelperUtils {

    public static Log getLog(Class<?> clazz) {
        return LogFactory.getLog(clazz);
    }
}
