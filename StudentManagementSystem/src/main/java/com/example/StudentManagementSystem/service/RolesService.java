package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.dto.RolesAddRequestDto;
import com.example.StudentManagementSystem.dto.RolesAddResponseDto;
import com.example.StudentManagementSystem.dto.RolesGetResponseDto;

public interface RolesService {

    RolesGetResponseDto getRole(Integer id);

    RolesAddResponseDto addRole(RolesAddRequestDto dto);
}
