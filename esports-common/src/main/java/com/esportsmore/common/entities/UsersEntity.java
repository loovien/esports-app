package com.esportsmore.common.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersEntity {
    private Integer id;

    private String nickname;

    private String avatar;

    private String mobile;

    private String inviteCode;

    private Integer status;

    private Integer gender;

    private Date createdDate;
}
