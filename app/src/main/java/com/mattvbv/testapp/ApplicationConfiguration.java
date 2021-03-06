package com.mattvbv.testapp;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@Configuration
public class ApplicationConfiguration {

  @Bean(name = "org.dozer.Mapper")
  public DozerBeanMapper dozerBean() {
    List<String> mappingFiles = Arrays.asList("dozer-mappings.xml");
    DozerBeanMapper dozerBean = new DozerBeanMapper();
    dozerBean.setMappingFiles(mappingFiles);
    return dozerBean;
  }
  
}