package org.example.loginapi.service.user;

import org.example.loginapi.model.entity.UserEntity;
import org.example.loginapi.model.dto.UserDto;

public interface UserService {

    UserDto createUser(UserEntity user);

}
