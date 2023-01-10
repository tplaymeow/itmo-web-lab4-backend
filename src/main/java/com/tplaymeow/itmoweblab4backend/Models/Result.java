package com.tplaymeow.itmoweblab4backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private Long id;
    private Double x;
    private Double y;
    private Double r;
    private String timestamp;
    private Boolean success;
}
