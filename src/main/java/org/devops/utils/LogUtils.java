package org.devops.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志 Util
 */
public class LogUtils {
    public static void logInfo(Class clz, String message) {
        Logger logger = LoggerFactory.getLogger(clz);
        logger.info(message);
    }

    public static void logError(Class clz, String message, Throwable ex) {
        Logger logger = LoggerFactory.getLogger(clz);
        logger.error(message, ex);
    }

    public static void logError(Class clz, String message) {
        Logger logger = LoggerFactory.getLogger(clz);
        logger.error(message);
    }

    public static void logError(Class clz, Throwable ex) {
        logError(clz, "", ex);
    }


    public static void logWarn(Class clz, String message, Throwable ex) {
        Logger logger = LoggerFactory.getLogger(clz);
        logger.warn(message, ex);
    }

    public static void logWarn(Class clz, String message) {
        Logger logger = LoggerFactory.getLogger(clz);
        logger.error(message);
    }

    public static void logWarn(Class clz, Throwable ex) {
        logWarn(clz, "", ex);
    }
}
