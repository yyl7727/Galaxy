package com.zxy.galaxy.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDto implements Serializable {
    private String username;

    private String password;
}
