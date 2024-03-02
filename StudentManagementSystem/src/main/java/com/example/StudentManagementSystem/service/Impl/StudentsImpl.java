package com.example.StudentManagementSystem.service.Impl;

import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.entity.Dorms;
import com.example.StudentManagementSystem.entity.Scholarship;
import com.example.StudentManagementSystem.entity.Students;
import com.example.StudentManagementSystem.mapper.IMapper;
import com.example.StudentManagementSystem.repo.*;
import com.example.StudentManagementSystem.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsImpl implements StudentsService {

    @Autowired
    private StudentsRepo studentsRepo;
    @Autowired
    private CredentialsRepo credentialsRepo;
    @Autowired
    private DormsRepo dormsRepo;
    @Autowired
    private ScholarshipRepo scholarshipRepo;
    @Autowired
    private GroupsRepo groupsRepo;
    @Autowired
    private IMapper mapper;

    @Override
    public StudentsGetResponseDto getStudents(Integer id) {
        Students student = studentsRepo.getReferenceById(id);
        return mapper.studentsToDtoRead(student);
    }

    @Override
    public StudentsGetResponseDto getStudentsByCredentialsID(Integer id) {
        Students student = studentsRepo.findByCredentials_CredentialsID(id);
        return mapper.studentsToDtoRead(student);
    }

    @Override
    public StudentsAddResponseDto addStudents(StudentsAddRequestDto dto) {
        //Students student = mapper.DtoToStudentsAdd(dto);
        Students student = new Students();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setCredentials(credentialsRepo.getReferenceById(dto.getCredentials()));
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setGroup(groupsRepo.getReferenceById(dto.getGroup()));
        student.setScholarship(scholarshipRepo.getReferenceById(dto.getScholarship()));
        student.setIntegralist(dto.getIntegralist());
        student.setDorms(dormsRepo.getReferenceById(dto.getDorms()));

        Students response = studentsRepo.save(student);
        return mapper.studentsToDtoAdd(response);
    }

    @Override
    public StudentsDeleteResponseDto deleteStudents(Integer id) {
        Students student = studentsRepo.getReferenceById(id);
        studentsRepo.delete(student);
        return mapper.studentsToDtoDelete(student);
    }

    @Override
    public StudentsUpdateResponseDto updateStudents(StudentsUpdateRequestDto dto) {
        Students student = studentsRepo.getReferenceById(dto.getStudentId());
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setCredentials(credentialsRepo.getReferenceById(dto.getCredentials()));
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setGroup(groupsRepo.getReferenceById(dto.getGroup()));
        student.setScholarship(scholarshipRepo.getReferenceById(dto.getScholarship()));
        student.setIntegralist(dto.getIntegralist());
        student.setDorms(dormsRepo.getReferenceById(dto.getDorms()));

        Students response = studentsRepo.save(student);
        return mapper.studentsToDtoUpdate(response);
    }

    @Override
    public List<StudentsGetResponseDto> getAllStudents() {
        List<Students> allStudents = studentsRepo.findAll();
        return allStudents.stream()
                .map(mapper::studentsToDtoRead)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentsGetResponseDto> getStudentsByGroupId(Integer groupId) {
        List<Students> studentsInGroup = studentsRepo.findByGroup_GroupId(groupId);
        return studentsInGroup.stream()
                .map(mapper::studentsToDtoRead)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentsGetResponseDto> getStudentsByGroupNumber(Integer groupNumber) {
        List<Students> studentsInGroup = studentsRepo.findByGroup_GroupNumber(groupNumber);
        return studentsInGroup.stream()
                .map(mapper::studentsToDtoRead)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentsGetResponseDto> getIntegralist() {
        List<Students> integralistStudents = studentsRepo.findByIntegralist(true);
        return integralistStudents.stream()
                .map(mapper::studentsToDtoRead)
                .collect(Collectors.toList());
    }
}
