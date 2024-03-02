package com.example.StudentManagementSystem.controller;

import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<?> getStudents(@PathVariable Integer id){
        StudentsGetResponseDto getResponse = studentsService.getStudents(id);
        return ResponseEntity.ok(getResponse);
    }

    @GetMapping(path = "/get/credentials/{id}")
    public ResponseEntity<?> getStudentsByCredentialsEmail(@PathVariable Integer id){
        StudentsGetResponseDto getResponse = studentsService.getStudentsByCredentialsID(id);
        return ResponseEntity.ok(getResponse);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addStudents(@RequestBody StudentsAddRequestDto requestDto){
        StudentsAddResponseDto addResponse = studentsService.addStudents(requestDto);
        return ResponseEntity.ok(addResponse);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteStudents(@PathVariable Integer id){
        StudentsDeleteResponseDto deleteResponse = studentsService.deleteStudents(id);
        return ResponseEntity.ok(deleteResponse);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> updateStudents(@RequestBody StudentsUpdateRequestDto requestDto){
        StudentsUpdateResponseDto updateResponse = studentsService.updateStudents(requestDto);
        return ResponseEntity.ok(updateResponse);
    }

    @GetMapping(path = "/get/all")
    public ResponseEntity<?> getAllStudents(){
        List<StudentsGetResponseDto> getResponse = studentsService.getAllStudents();
        return ResponseEntity.ok(getResponse);
    }

    @GetMapping(path = "/getByGroup/{id}")
    public ResponseEntity<?> getStudentsByGroupId(@PathVariable Integer id){
        List<StudentsGetResponseDto> getResponse = studentsService.getStudentsByGroupId(id);
        return ResponseEntity.ok(getResponse);
    }

    @GetMapping(path = "/getByGroupNumber/{id}")
    public ResponseEntity<?> getStudentsByGroupNumber(@PathVariable Integer id){
        List<StudentsGetResponseDto> getResponse = studentsService.getStudentsByGroupNumber(id);
        return ResponseEntity.ok(getResponse);
    }

    @GetMapping(path = "/getIntegralistStudents")
    public ResponseEntity<?> getIntegralistStudents(){
        List<StudentsGetResponseDto> getResponse = studentsService.getIntegralist();
        return ResponseEntity.ok(getResponse);
    }
}