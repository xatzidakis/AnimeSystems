package com.animesystems.services;



import com.animesystems.dtos.UserDto;
import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user);

    void deleteUser(Integer userId);

    UserDto authenticate(String email, String password);
}