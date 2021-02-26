package com.esportsmore.web.dao;

import com.esportsmore.core.model.UsersDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository {
    UsersDO findById(@Param("id") Integer id);
}
