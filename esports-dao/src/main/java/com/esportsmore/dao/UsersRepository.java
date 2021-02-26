package com.esportsmore.dao;

import com.esportsmore.common.entities.UsersEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository {
    UsersEntity findOne(@Param("id") Integer id);
}
