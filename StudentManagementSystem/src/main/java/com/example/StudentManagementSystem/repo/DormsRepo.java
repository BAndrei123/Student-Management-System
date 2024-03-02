package com.example.StudentManagementSystem.repo;

import com.example.StudentManagementSystem.entity.Dorms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface DormsRepo extends JpaRepository<Dorms, Integer> {
}
