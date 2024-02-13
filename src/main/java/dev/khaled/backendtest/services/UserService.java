package dev.khaled.backendtest.services;

import java.nio.CharBuffer;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.khaled.backendtest.dto.CredentialsDto;
import dev.khaled.backendtest.dto.UserDto;
import dev.khaled.backendtest.entities.User;
import dev.khaled.backendtest.exceptions.AppException;
import dev.khaled.backendtest.mappers.UserMapper;
import dev.khaled.backendtest.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.login())
            .orElseThrow(
                () -> new AppException("Unknown user", HttpStatus.NOT_FOUND)
                );

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }

        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }
}
