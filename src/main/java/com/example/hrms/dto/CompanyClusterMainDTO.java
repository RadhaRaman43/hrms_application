package com.example.hrms.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyClusterMainDTO {
    private String flag;
    private List<CompanyClusterDTO> clusterList;
}
