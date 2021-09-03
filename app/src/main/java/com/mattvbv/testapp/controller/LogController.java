package com.mattvbv.testapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/trace")
    public void generateTraceLog() {
        logger.debug("This is a TRACE log statement");
    }
    
    @GetMapping("/debug")
    public void generateDebugLog() {
        logger.debug("This is a DEBUG log statement");
    }
    
    @GetMapping("/info")
    public void generateInfogLog() {
        logger.info("This is an INFO log statement");
    } 

    @GetMapping("/warn")
    public void generateWarnLog() {
        logger.warn("This is a WARN log statement");
    }
    
    @GetMapping("/error")
    public void generateErrorLog() {
        logger.debug("This is a ERROR log statement");
    }   
    
    @GetMapping("/fatal")
    public void generateFatalLog() {
        logger.debug("This is a DEBUG log statement");
    }    
    
    @GetMapping("/stacktrace")
    public void generateStacktrace() {
        try {
            throwException();
        } catch (Exception e) {
            logger.error("This is a stacktrace", e);
        }
    }

    private void throwException() {
        throw new RuntimeException("Long live exceptions !");
    }

}