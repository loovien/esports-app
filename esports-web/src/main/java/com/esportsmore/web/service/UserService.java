package com.esportsmore.web.service;

import com.esportsmore.web.dto.UsersDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UsersDto findUserById(Integer userId);
}
