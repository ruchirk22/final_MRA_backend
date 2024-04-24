package com.project.mra.service.impl;

import com.project.mra.dto.UserDto;
import com.project.mra.entity.User;
import com.project.mra.exception.ResourceNotFoundException;
import com.project.mra.mapper.UserMapper;
import com.project.mra.repository.UserRepository;
import com.project.mra.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.maptoUser(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.maptoUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(long UserId) {
        User user = userRepository.findById(UserId)
                .orElseThrow(()-> new ResourceNotFoundException("User does not exist with given ID : " + UserId));

        return UserMapper.maptoUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users= userRepository.findAll();

        return users.stream().map(UserMapper::maptoUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long UserId, UserDto updateduser) {

        User user = userRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with given ID : " + UserId)
        );

        user.setFirstname(updateduser.getFirstname());
        user.setLastname(updateduser.getLastname());
        user.setEmail(updateduser.getEmail());

        User updateduserobj = userRepository.save(user);

        return UserMapper.maptoUserDto(updateduserobj);
    }

    @Override
    public void deleteUser(Long UserId) {

        User user = userRepository.findById(UserId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with given ID : " + UserId)
        );

        userRepository.deleteById(UserId);

    }


}
