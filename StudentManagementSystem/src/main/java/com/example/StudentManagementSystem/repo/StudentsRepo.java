package com.example.StudentManagementSystem.repo;

import com.example.StudentManagementSystem.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface StudentsRepo extends JpaRepository<Students, Integer> {
    List<Students> findByGroup_GroupId(Integer groupId);
    Students findByCredentials_CredentialsID(Integer credentialsID);
    List<Students> findByGroup_GroupNumber(Integer groupNumber);
    List<Students> findByIntegralist(Boolean integralist);
}
