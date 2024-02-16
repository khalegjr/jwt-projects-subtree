package dev.khaled.backendtest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dev.khaled.backendtest.dtos.SignUpDto;
import dev.khaled.backendtest.dtos.UserDto;
import dev.khaled.backendtest.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
