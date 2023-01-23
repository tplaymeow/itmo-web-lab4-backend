package com.tplaymeow.itmoweblab4backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tokens {
    private String access;
    private String refresh;
}
