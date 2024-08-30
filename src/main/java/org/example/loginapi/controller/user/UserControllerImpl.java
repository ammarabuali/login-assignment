package org.example.loginapi.controller.user;

import jakarta.validation.Valid;
import org.example.loginapi.model.entity.UserEntity;
import org.example.loginapi.model.dto.UserDto;
import org.example.loginapi.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserEntity user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

}


