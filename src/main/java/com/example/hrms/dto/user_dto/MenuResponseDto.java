package com.example.hrms.dto.user_dto;

import java.util.ArrayList;
import java.util.List;

public class MenuResponseDto {
    private Long menuId;

    private String title;

    private String icon;

    private String type;

    private String link;

    private List<MenuResponseDto> children = new ArrayList<>();
}
