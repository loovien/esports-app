package com.esportsmore.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDO {
    private Integer id;

    private String nickname;

    private String mobile;

    private String password;

    private String avatar;

    private String inviteCode;

    private Integer status;

    private Integer gender;

    private Date createdDate;
}
