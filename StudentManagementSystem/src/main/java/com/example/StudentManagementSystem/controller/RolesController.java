package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.RolesAddRequestDto;
import com.example.StudentManagementSystem.dto.RolesAddResponseDto;
import com.example.StudentManagementSystem.dto.RolesGetResponseDto;
import com.example.StudentManagementSystem.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<?> getRole(@PathVariable Integer id){
        RolesGetResponseDto getResponse = rolesService.getRole(id);
        return ResponseEntity.ok(getResponse);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addRole(@RequestBody RolesAddRequestDto requestDto){
        RolesAddResponseDto addResponse = rolesService.addRole(requestDto);
        return ResponseEntity.ok(addResponse);
    }
}
