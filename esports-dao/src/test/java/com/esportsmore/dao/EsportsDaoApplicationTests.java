package com.esportsmore.dao;

import com.esportsmore.common.entities.UsersEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("spring.config.name=application")
class EsportsDaoApplicationTests {

    @Autowired
    UsersRepository usersRepository;

    @Test
    void contextLoads() {
        UsersEntity usersEntity = usersRepository.findOne(1);
        System.out.println(usersEntity);
    }

}
