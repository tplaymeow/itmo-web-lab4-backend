package com.tplaymeow.itmoweblab4backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {
    private String code;
    private String message;
}
