package com.animesystems.services;

import com.animesystems.dtos.UserDto;
import com.animesystems.entities.User;
import com.animesystems.exception.UserNotFoundException;
import com.animesystems.mapper.UserMapper;
import com.animesystems.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Convert UserDto into User JPA Entity
        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);

        // Convert User JPA entity to UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found for id: " + userId));
        return UserMapper.mapToUserDto(existingUser);
    }



    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found for id: " + userDto.getId()));


        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setAddress(userDto.getAddress());
        existingUser.setUserRole(User.UserRole.valueOf(userDto.getUserRole().toUpperCase()));

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found for id: " + userId));
        userRepository.deleteById(userId);
    }

}