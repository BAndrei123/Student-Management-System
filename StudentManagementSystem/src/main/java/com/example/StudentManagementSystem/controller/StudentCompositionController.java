package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.StudentCompositionDto;
import com.example.StudentManagementSystem.entity.Credentials;
import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("api/v1/composition")
public class StudentCompositionController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/students/{studentId}")
    public ResponseEntity<StudentCompositionDto> getStudentById(@PathVariable Long studentId) {
        // Call Student Service to get student details
        ResponseEntity<Students> studentResponse = restTemplate.getForEntity("http://localhost:8080/api/v1/students/get/{id}", Students.class, studentId);
        Students student = studentResponse.getBody();

        // Call Credentials Service to get student's credentials
        assert student != null;
        ResponseEntity<Credentials> credentialsResponse = restTemplate.getForEntity("http://localhost:8080/api/v1/credentials/get/{id}", Credentials.class, student.getCredentials().getCredentialsID());
        Credentials credentials = credentialsResponse.getBody();

        // Call Group Service to get student's group
        ResponseEntity<Groups> groupResponse = restTemplate.getForEntity("http://localhost:8080/api/v1/groups/get/{id}", Groups.class, student.getGroup().getGroupId());
        Groups group = groupResponse.getBody();

        // Build a student DTO with credentials and group information
        StudentCompositionDto studentDto = new StudentCompositionDto(student, credentials, group);

        return ResponseEntity.ok(studentDto);
    }
}
