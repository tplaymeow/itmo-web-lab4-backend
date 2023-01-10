package com.tplaymeow.itmoweblab4backend.Models;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
