package com.animesystems.API;

import com.animesystems.dtos.UserDto;
import com.animesystems.exception.UserNotFoundException;
import com.animesystems.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer userId){
        try {
            UserDto user = userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
        // user not found error
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Integer userId,
                                        @RequestBody UserDto userDto) {
        userDto.setId(userId);

        try {
            UserDto updatedUser = userService.updateUser(userDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (UserNotFoundException ex) {
            // user not found error
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")  Integer userId){
        try{
            userService.deleteUser(userId);
            return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
        }catch (UserNotFoundException ex) {
            // user not found error
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
