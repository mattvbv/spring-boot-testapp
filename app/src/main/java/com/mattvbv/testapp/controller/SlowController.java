package com.mattvbv.testapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowController {

  private static final long LOOP_ITERATIONS = 20000000000L;
  
  private final Logger logger = LoggerFactory.getLogger(getClass());

  @GetMapping("/slow")
  public void simulateSlowMethod() {
      logger.info("Starting very long computation operation");
      for (long i=0; i<LOOP_ITERATIONS; i++) {
      }
      logger.info("Finished with very long computation operation");
  }
  
}
