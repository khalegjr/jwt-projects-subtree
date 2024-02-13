package dev.khaled.backendtest.mappers;

import org.mapstruct.Mapper;

import dev.khaled.backendtest.dto.UserDto;
import dev.khaled.backendtest.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
}
