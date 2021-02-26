package com.esportsmore.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.esportsmore.web.configs"})
@MapperScan(basePackages = "com.esportsmore.web.dao")
public class EsportsWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsportsWebApplication.class, args);
    }

}
