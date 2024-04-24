package com.project.mra.mapper;

import com.project.mra.dto.UserDto;
import com.project.mra.entity.User;

public class UserMapper {

    public static UserDto maptoUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }

    public static User maptoUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getEmail()
        );
    }
}
