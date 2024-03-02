package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.service.GroupsService;
import com.example.StudentManagementSystem.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/groups")
public class GroupsController {
    @Autowired
    private GroupsService groupsService;

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<?> getGroups(@PathVariable Integer id){
        GroupsGetResponseDto getResponse = groupsService.getGroups(id);
        return ResponseEntity.ok(getResponse);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addGroups(@RequestBody GroupsAddRequestDto requestDto){
        GroupsAddResponseDto addResponse = groupsService.addGroups(requestDto);
        return ResponseEntity.ok(addResponse);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteGroups(@PathVariable Integer id){
        GroupsDeleteResponseDto deleteResponse = groupsService.deleteGroups(id);
        return ResponseEntity.ok(deleteResponse);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateGroups(@RequestBody GroupsUpdateRequestDto requestDto){
        GroupsUpdateResponseDto updateResponse = groupsService.updateGroups(requestDto);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping(path = "/getall")
    public ResponseEntity<?> getAllStudents(){
        List<GroupsGetResponseDto> getResponse = groupsService.getAllGroups();
        return ResponseEntity.ok(getResponse);
    }

    @GetMapping(path = "/getGroupsByYear/{groupYear}")
    public ResponseEntity<?> getStudentsByGroupId(@PathVariable Integer groupYear){
        List<GroupsGetResponseDto> getResponse = groupsService.getGroupsByYear(groupYear);
        return ResponseEntity.ok(getResponse);
    }

    @GetMapping(path = "/get/all")
    public ResponseEntity<?> getAllCredentials(){
        List<GroupsGetResponseDto> getResponse = groupsService.getAllGroups();
        return ResponseEntity.ok(getResponse);
    }
}
