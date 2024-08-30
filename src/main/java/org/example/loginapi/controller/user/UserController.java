package org.example.loginapi.controller.user;

import jakarta.validation.Valid;
import org.example.loginapi.annotation.CommonResponse;
import org.example.loginapi.model.entity.UserEntity;
import org.example.loginapi.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @PostMapping("/create")
    @CommonResponse
    ResponseEntity<UserDto> createUser(@RequestBody @Valid UserEntity user);

}
