package com.example.StudentManagementSystem.controller;


import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.response.RegistrationResponse;
import com.example.StudentManagementSystem.service.CredentialsService;
import com.example.StudentManagementSystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/credentials")
public class CredentialsController {

    @Autowired
    private CredentialsService credentialsService;


    @PostMapping(path = "/save")
    public ResponseEntity<?> saveCredentials(@RequestBody CredentialsDTO credentialsDTO){
        RegistrationResponse id = credentialsService.addCredentials(credentialsDTO);
        return ResponseEntity.ok(id);
    }

    @PostMapping(path = "/login")

    public ResponseEntity<?>  loginCredentials(@RequestBody LoginDTO loginDTO){
           LoginResponse loginMessage = credentialsService.loginCredentials(loginDTO);
           return ResponseEntity.ok(loginMessage);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<?> getCredentials(@PathVariable Integer id){
        CredentialsGetResponseDto getResponse = credentialsService.getCredentials(id);
        return ResponseEntity.ok(getResponse);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> loginDelete(@PathVariable Integer id){
        CredentialsDeleteResponseDto credentialsDeleteResponseDto = credentialsService.deleteCredentials(id);
        return ResponseEntity.ok(credentialsDeleteResponseDto);

    }
    @PutMapping(path = "/update")
    public ResponseEntity<?> updateCredentials(@RequestBody CredentialsUpdateRequestDto credentialsDTO){
        CredentialsUpdateResponseDto updateResponse = credentialsService.updateCredentials(credentialsDTO);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping(path = "/get/all")
    public ResponseEntity<?> getAllCredentials(){
        List<CredentialsGetResponseDto> getResponse = credentialsService.getAllCredentials();
        return ResponseEntity.ok(getResponse);
    }
}
