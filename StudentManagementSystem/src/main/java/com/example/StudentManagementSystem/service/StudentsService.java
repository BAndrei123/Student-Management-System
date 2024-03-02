package com.example.StudentManagementSystem.service;

import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.entity.Students;

import java.util.List;

public interface StudentsService {

    StudentsGetResponseDto getStudents(Integer id);
    StudentsAddResponseDto addStudents(StudentsAddRequestDto dto);
    StudentsDeleteResponseDto deleteStudents(Integer id);
    StudentsUpdateResponseDto updateStudents(StudentsUpdateRequestDto dto);
    List<StudentsGetResponseDto> getAllStudents();
    List<StudentsGetResponseDto> getStudentsByGroupId(Integer groupId);
    List<StudentsGetResponseDto> getStudentsByGroupNumber(Integer groupNumber);

    List<StudentsGetResponseDto> getIntegralist();

    StudentsGetResponseDto getStudentsByCredentialsID(Integer id);
}
