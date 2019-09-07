package com.example.demo.dto;

import lombok.Data;

@Data
public class commentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
