package org.example.loginapi.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.loginapi.mapper.UserMapper;
import org.example.loginapi.model.entity.UserEntity;
import org.example.loginapi.model.dto.UserDto;
import org.example.loginapi.exception.UserAlreadyExistsException;
import org.example.loginapi.exception.UserServiceException;
import org.example.loginapi.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDto createUser(UserEntity user) {
        try {
            validateUserNonExistence(user);
            String[] permissions = {"read", "write"};
            String[] roles = {"user"};
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roles);
            user.setPermissions(permissions);
            userRepository.save(user);
            return UserMapper.INSTANCE.toDto(user);
        } catch (UserAlreadyExistsException e) {
            log.error("User with this email {} already exists ", user.getEmail());
            throw new UserAlreadyExistsException("User already exists " + user.getEmail());
        } catch (Exception e) {
            throw new UserServiceException("An error occurred while creating user " + " " + user.getEmail());
        }
    }

    private void validateUserNonExistence(UserEntity user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()
                || userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
    }

}

