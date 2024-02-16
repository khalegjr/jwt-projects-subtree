package dev.khaled.backendtest.controllers;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.khaled.backendtest.config.UserAuthProvider;
import dev.khaled.backendtest.dtos.CredentialsDto;
import dev.khaled.backendtest.dtos.SignUpDto;
import dev.khaled.backendtest.dtos.UserDto;
import dev.khaled.backendtest.services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialsDto) {
        UserDto user = userService.login(credentialsDto);

        user.setToken(userAuthProvider.createToken(user));

        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto signUpDto) {
        UserDto user = userService.register(signUpDto);

        user.setToken(userAuthProvider.createToken(user));

        return ResponseEntity.created(URI.create("/user/" + user.getId())).body(user);
    }
}
