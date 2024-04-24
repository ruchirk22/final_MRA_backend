package com.project.mra.service;

import com.project.mra.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(long UserId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long UserId, UserDto updateduser);

    void deleteUser(Long UserId);
}
