package com.vmware.gemfire.example;

import com.vmware.gemfire.example.model.Customer;
import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
import org.apache.geode.cache.RegionShortcut;
import org.apache.geode.cache.server.CacheServer;
import org.apache.geode.distributed.ConfigurationProperties;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class GeodeServer {

  public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext applicationContext =
        new SpringApplicationBuilder(GeodeServer.class).web(WebApplicationType.NONE)
            .run(args);

    Region customerRegion = applicationContext.getBean("CustomerRegion", Region.class);
  }

  @Bean("gemfireCache")
  public Cache getGemFireCache() {
    Cache cache = new CacheFactory().set(ConfigurationProperties.NAME, "demo-server")
        .set(ConfigurationProperties.START_LOCATOR, "localhost[10334]").create();
    try {
      CacheServer cacheServer = cache.addCacheServer();
      cacheServer.setBindAddress("localhost");
      cacheServer.setPort(40404);
      cacheServer.start();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return cache;
  }

  @Bean("CustomerRegion")
  public Region<Object, Object> getCustomerRegion(Cache gemFireCache) {
    RegionFactory<Object, Object> regionFactory =
        gemFireCache.createRegionFactory(RegionShortcut.REPLICATE);
    return regionFactory.create("Customer");
  }
}
