package org.example.loginapi.mapper;

import org.example.loginapi.model.entity.UserEntity;
import org.example.loginapi.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
 
@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDto(UserEntity userEntity);
    UserEntity toEntity(UserDto userDto);
}