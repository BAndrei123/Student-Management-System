package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.dto.*;

import java.util.List;

public interface GroupsService {

    GroupsGetResponseDto getGroups(Integer id);

    GroupsAddResponseDto addGroups(GroupsAddRequestDto dto);

    GroupsDeleteResponseDto deleteGroups(Integer id);

    GroupsUpdateResponseDto updateGroups(GroupsUpdateRequestDto dto);

    List<GroupsGetResponseDto> getAllGroups();
    List<GroupsGetResponseDto> getGroupsByYear(Integer groupYear);
}
