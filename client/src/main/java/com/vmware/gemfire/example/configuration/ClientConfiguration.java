package com.vmware.gemfire.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@ComponentScan(
    basePackages = {"com.vmware.gemfire.example.controller",
        "com.vmware.gemfire.example.repository",
        "com.vmware.gemfire.example.service"})
@EnableGemfireRepositories(basePackages = "com.vmware.gemfire.example.repository")
@EnableEntityDefinedRegions(basePackages = "com.vmware.gemfire.example.model")
public class ClientConfiguration {
}
