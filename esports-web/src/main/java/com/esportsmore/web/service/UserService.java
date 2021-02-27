package com.esportsmore.web.service;

import com.esportsmore.web.dto.UsersDto;

public interface UserService {
    UsersDto findUserById(Integer userId);
}
