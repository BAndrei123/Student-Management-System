package com.example.StudentManagementSystem.service.Impl;

import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.mapper.IMapper;
import com.example.StudentManagementSystem.repo.GroupsRepo;
import com.example.StudentManagementSystem.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupsImpl implements GroupsService {

    @Autowired
    private GroupsRepo groupsRepo;
    @Autowired
    private IMapper mapper;
    @Override
    public GroupsGetResponseDto getGroups(Integer id) {
        Groups group = groupsRepo.getReferenceById(id);
        return mapper.groupsToDtoRead(group);
    }

    @Override
    public GroupsAddResponseDto addGroups(GroupsAddRequestDto dto) {
        Groups group = mapper.DtoToGroupsAdd(dto);
        group.setGroupYear(((dto.getGroupNumber())/10)%10);
        Groups response = groupsRepo.save(group);
        return mapper.groupsToDtoAdd(response);
    }

    @Override
    public GroupsDeleteResponseDto deleteGroups(Integer id) {
        Groups group = groupsRepo.getReferenceById(id);
        groupsRepo.delete(group);
        return mapper.groupsToDtoDelete(group);
    }

    @Override
    public GroupsUpdateResponseDto updateGroups(GroupsUpdateRequestDto dto) {
        Groups group = mapper.DtoToGroupsUpdate(dto);
        group.setGroupYear(((dto.getGroupNumber())/10)%10);
        Groups objectToUpdate = groupsRepo.getReferenceById(group.getGroupId());
        objectToUpdate.setGroupYear(group.getGroupYear());
        objectToUpdate.setGroupNumber(group.getGroupNumber());
        Groups response = groupsRepo.save(objectToUpdate);
        return mapper.groupsToDtoUpdate(response);
    }



    @Override
    public List<GroupsGetResponseDto> getAllGroups() {
        List<Groups> allGroups = groupsRepo.findAll();
        return allGroups.stream()
                .map(mapper::groupsToDtoRead)
                .collect(Collectors.toList());
    }

    @Override
    public List<GroupsGetResponseDto> getGroupsByYear(Integer groupYear) {
        List<Groups> groupsByYear = groupsRepo.findByGroupYear(groupYear);
        return groupsByYear.stream()
                .map(mapper::groupsToDtoRead)
                .collect(Collectors.toList());
    }
}
