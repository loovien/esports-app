package com.esportsmore.web.service.impl;

import com.esportsmore.core.errors.BizException;
import com.esportsmore.core.model.UsersDO;
import com.esportsmore.web.dao.UsersRepository;
import com.esportsmore.web.dto.UsersDto;
import com.esportsmore.web.exceptions.Codes;
import com.esportsmore.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDto findUserById(Integer userId) {
        UsersDO usersDO = this.usersRepository.findById(userId);
        if (usersDO == null) {
            throw new BizException(Codes.ERR_RECORD_NOT_FOUND);
        }
        return UsersDto.builder()
                .id(usersDO.getId())
                .nickname(usersDO.getNickname())
                .avatar(usersDO.getAvatar())
                .mobile(usersDO.getMobile())
                .createdDate(usersDO.getCreatedDate())
                .build();
    }
}
