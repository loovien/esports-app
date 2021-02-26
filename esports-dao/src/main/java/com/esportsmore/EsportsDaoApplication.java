package com.esportsmore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.esportsmore.dao"})
public class EsportsDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsportsDaoApplication.class, args);
    }

}
