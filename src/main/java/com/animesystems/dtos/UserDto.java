package com.animesystems.dtos;

import com.animesystems.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String userRole;


//    public User.UserRole getRoleEnum() {
//        if (this.userRole != null) {
//            return User.UserRole.valueOf(this.userRole.toUpperCase());
//        } else {
//            return null;
//        }
//    }

    public void setRoleEnum(User.UserRole role) {
        this.userRole = role.getName();
    }
}
