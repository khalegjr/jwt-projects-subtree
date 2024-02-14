package dev.khaled.backendtest.mappers;

import dev.khaled.backendtest.dtos.SignUpDto;
import dev.khaled.backendtest.dtos.UserDto;
import dev.khaled.backendtest.entities.User;

// @Mapper(componentModel = "spring")
public class UserMapper {

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setLogin(user.getLogin());

        return userDto;
    }

    // @Mapping(target = "password", ignore = true)
    public User signUpToUser(SignUpDto signUpDto) {
        User user = new User();

        user.setFirstName(signUpDto.firstName());
        user.setLastName(signUpDto.lastName());
        user.setLogin(signUpDto.login());

        return user;
    }
}
