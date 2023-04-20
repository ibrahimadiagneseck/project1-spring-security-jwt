package sn.esp.project1springsecurity.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
