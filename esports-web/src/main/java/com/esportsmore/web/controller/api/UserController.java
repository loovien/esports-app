package com.esportsmore.web.controller.api;

import com.esportsmore.core.api.Result;
import com.esportsmore.web.annotations.LoginRequired;
import com.esportsmore.web.dto.UsersDto;
import com.esportsmore.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@LoginRequired
public class UserController {

    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/information/{userId}", method = RequestMethod.GET)
    public Result<UsersDto> getUserInfo(@PathVariable(name = "userId") Integer userId) {
        UsersDto usersDto = this.userService.findUserById(userId);
        return Result.wrapOKResult(usersDto);
    }
}
