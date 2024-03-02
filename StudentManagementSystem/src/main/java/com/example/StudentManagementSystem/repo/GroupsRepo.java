package com.example.StudentManagementSystem.repo;

import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface GroupsRepo extends JpaRepository<Groups, Integer> {
    List<Groups> findByGroupYear(Integer groupYear);
}
