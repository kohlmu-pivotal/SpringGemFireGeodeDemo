package com.vmware.gemfire.example.client;

import com.vmware.gemfire.example.configuration.ClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;

@SpringBootApplication
@ClientCacheApplication
@ComponentScan(basePackageClasses = {ClientConfiguration.class})
public class GemFireClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(GemFireClientApplication.class, args);
  }

}
