package com.example.StudentManagementSystem.mapper;

import com.example.StudentManagementSystem.dto.*;
import com.example.StudentManagementSystem.entity.Credentials;
import com.example.StudentManagementSystem.entity.Roles;
import com.example.StudentManagementSystem.entity.Groups;
import com.example.StudentManagementSystem.entity.Students;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMapper {

    RolesGetResponseDto rolesToDTORead(Roles role);

    Roles DTOToRolesAdd(RolesAddRequestDto dto);

    RolesAddResponseDto rolesToDTOAdd(Roles role);

    GroupsGetResponseDto groupsToDtoRead(Groups group);

    GroupsAddResponseDto groupsToDtoAdd(Groups group);

    Groups DtoToGroupsAdd(GroupsAddRequestDto dto);

    GroupsDeleteResponseDto groupsToDtoDelete(Groups group);

    Groups DtoToGroupsUpdate(GroupsUpdateRequestDto dto);

    GroupsUpdateResponseDto groupsToDtoUpdate(Groups group);



    //Students DtoToStudentsAdd(StudentsAddRequestDto dto);

    StudentsAddResponseDto studentsToDtoAdd(Students student);

    StudentsDeleteResponseDto studentsToDtoDelete(Students student);

    //Students DtoToStudentUpdate(StudentsUpdateRequestDto dto);

    StudentsUpdateResponseDto studentsToDtoUpdate(Students student);

    CredentialsDeleteResponseDto credentialsToDtoDelete(Credentials credentials);

    Credentials DtoToCredentialsUpdate(CredentialsUpdateRequestDto credentialsDTO);

    CredentialsUpdateResponseDto credentialstoDtoUpdate(Credentials response);

  /*  Students DtoToStudentsAdd(StudentsAddRequestDto dto);

    StudentsAddResponseDto studentsToDtoAdd(Students response);*/

    StudentsGetResponseDto studentsToDtoRead(Students student);

    CredentialsGetResponseDto creadentialsToDtoRead(Credentials credentials);
}
