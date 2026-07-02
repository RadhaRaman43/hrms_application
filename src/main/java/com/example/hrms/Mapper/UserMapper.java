package com.example.hrms.Mapper;

import com.example.hrms.Modals.user.User;
import com.example.hrms.dto_request.AuthenticationRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(AuthenticationRequestDto dto) {

        User user = new User();

        user.setFirstname(dto.getFirstname());
        user.setMiddlename(dto.getMiddlename());
        user.setLastname(dto.getLastname());

        if (dto.getMiddlename() != null && !dto.getMiddlename().isBlank()) {
            user.setUsername(dto.getFirstname() + " "
                    + dto.getMiddlename() + " "
                    + dto.getLastname());
        } else {
            user.setUsername(dto.getFirstname() + " "
                    + dto.getLastname());
        }

        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNo(dto.getPhoneNo());
        user.setDepartment(dto.getDepartment());
        user.setDesignation(dto.getDesignation());
        user.setDeviceId(dto.getDeviceId());

        return user;
    }
}
