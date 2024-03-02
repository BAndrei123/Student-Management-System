package com.example.StudentManagementSystem.repo;

import com.example.StudentManagementSystem.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CredentialsRepo extends JpaRepository<Credentials,Integer> {
    Credentials findByEmail(String email);
    Optional<Credentials> findOneByEmailAndPassword(String email, String encodedPassword);
}
