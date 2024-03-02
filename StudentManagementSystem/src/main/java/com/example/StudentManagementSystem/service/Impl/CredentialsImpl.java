package com.example.StudentManagementSystem.service.Impl;

import com.example.StudentManagementSystem.aop.CredentialsAspect;
import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.entity.Credentials;
import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.entity.Students;
import com.example.StudentManagementSystem.mapper.IMapper;
import com.example.StudentManagementSystem.repo.CredentialsRepo;
import com.example.StudentManagementSystem.response.RegistrationResponse;
import com.example.StudentManagementSystem.service.CredentialsService;
import com.example.StudentManagementSystem.response.LoginResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Transactional
public class CredentialsImpl implements CredentialsService {

    @Autowired
    private IMapper mapper;
    @Autowired
    private CredentialsRepo credentialsRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public RegistrationResponse addCredentials(CredentialsDTO credentialsDTO) {

        Credentials credentials = new Credentials(
                credentialsDTO.getCredentialsID(),
                credentialsDTO.getEmail(),
                credentialsDTO.getPassword(),
                credentialsDTO.getUsername(),

                credentialsDTO.getRole()
        );

        if (credentials.getEmail().equals(""))
            return new RegistrationResponse("insert all fields",false);
        if(credentials.getUsername().equals(""))
            return new RegistrationResponse("insert all fields",false);
        if(credentials.getPassword().equals(""))
            return new RegistrationResponse("insert all fields",false);
        if(credentials.getRole()==null)
            return new RegistrationResponse("insert all fields",false);

        String emailRe="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat=Pattern.compile(emailRe, Pattern.CASE_INSENSITIVE);
        Matcher matcher=emailPat.matcher(credentials.getEmail());
        if (!matcher.find()){
            return new RegistrationResponse("Insert valid email", false);
        }

        Credentials findEmail = credentialsRepo.findByEmail(credentials.getEmail());
        if(findEmail != null)
            return new RegistrationResponse("Email already exists",false);

        Credentials credentialsToSave = new Credentials(
                credentialsDTO.getCredentialsID(),
                credentialsDTO.getEmail(),
                this.passwordEncoder.encode(credentialsDTO.getPassword()),
                credentialsDTO.getUsername(),

                credentialsDTO.getRole()
        );
        credentialsRepo.save(credentialsToSave);

        return new RegistrationResponse("succed",true);
    }

    @Override
    public LoginResponse loginCredentials(LoginDTO loginDTO) {
        String msg ="";
        Credentials credentials1 = credentialsRepo.findByEmail(loginDTO.getEmail());
        if(credentials1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = credentials1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);

            if(isPwdRight){
                Optional<Credentials> credentials = credentialsRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if (credentials.isPresent()){
                    return new LoginResponse(credentials.get().getCredentialsID(),credentials.get().getRole(), "logged in successfully",true);
                }
                else {
                    return new LoginResponse(null,null,"Login Failed",false);
                }
            }else {
                return new LoginResponse(null,null,"Password not match",false);
            }

        }
        return new LoginResponse(null,null,"Email does not exist", false);
    }
    @Override
    public CredentialsDeleteResponseDto deleteCredentials(Integer id) {
        Credentials credentials = credentialsRepo.getReferenceById(id);
        credentialsRepo.delete(credentials);
        return mapper.credentialsToDtoDelete(credentials);
    }

    @Override
    public CredentialsUpdateResponseDto updateCredentials(CredentialsUpdateRequestDto credentialsDTO) {
        Credentials credentials = mapper.DtoToCredentialsUpdate(credentialsDTO);
        Credentials credentialsToUpdate = credentialsRepo.getReferenceById(credentials.getCredentialsID());
        credentialsToUpdate.setRole(credentials.getRole());
        credentialsToUpdate.setEmail(credentials.getEmail());
        credentialsToUpdate.setUsername(credentials.getUsername());
        credentialsToUpdate.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
        Credentials response = credentialsRepo.save(credentialsToUpdate);
        return mapper.credentialstoDtoUpdate(response);

    }

    @Override
    public List<CredentialsGetResponseDto> getAllCredentials() {
        List<Credentials> allCredentials = credentialsRepo.findAll();
        return allCredentials.stream()
                .map(mapper::creadentialsToDtoRead)
                .collect(Collectors.toList());
    }

    @Override
    public CredentialsGetResponseDto getCredentials(Integer id) {
        Credentials credentials = credentialsRepo.getReferenceById(id);
        return mapper.creadentialsToDtoRead(credentials);
    }

}
