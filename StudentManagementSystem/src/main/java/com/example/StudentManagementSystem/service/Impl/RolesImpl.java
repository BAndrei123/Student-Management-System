package com.example.StudentManagementSystem.service.Impl;

import com.example.StudentManagementSystem.dto.RolesAddRequestDto;
import com.example.StudentManagementSystem.dto.RolesAddResponseDto;
import com.example.StudentManagementSystem.dto.RolesGetResponseDto;
import com.example.StudentManagementSystem.entity.Roles;
import com.example.StudentManagementSystem.mapper.IMapper;
import com.example.StudentManagementSystem.repo.RolesRepo;
import com.example.StudentManagementSystem.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesImpl implements RolesService {

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private IMapper mapper;

    @Override
    public RolesGetResponseDto getRole(Integer id) {
        Roles roleResponse = rolesRepo.getReferenceById(id);
        return mapper.rolesToDTORead(roleResponse);
    }

    @Override
    public RolesAddResponseDto addRole(RolesAddRequestDto dto) {
        Roles role = mapper.DTOToRolesAdd(dto);
        Roles response = rolesRepo.save(role);
        return mapper.rolesToDTOAdd(response);
    }
}
