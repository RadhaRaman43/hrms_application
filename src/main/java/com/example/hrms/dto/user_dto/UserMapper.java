package com.example.hrms.dto.user_dto;

import com.example.hrms.Modals.user.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // DTO → Entity
    User toEntity(UserResponseDTO dto);

    // Entity → DTO
    UserResponseDTO toDTO(User user);

    // 🔥 Custom mapping after conversion
    @AfterMapping
    default void setUsername(UserResponseDTO dto, @MappingTarget User user) {

        if (dto.getMiddlename() != null && !dto.getMiddlename().isBlank()) {
            user.setUsername(dto.getFirstname() + " " + dto.getMiddlename() + " " + dto.getLastname());
        } else {
            user.setUsername(dto.getFirstname() + " " + dto.getLastname());
        }
    }
}