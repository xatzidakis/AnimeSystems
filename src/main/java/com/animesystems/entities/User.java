package com.animesystems.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String address;



    @Enumerated(EnumType.STRING)
    @Column//(nullable = false, columnDefinition = "varchar(255) default 'CUSTOMER'")
    private UserRole userRole;

    public boolean isAdmin() {
        return UserRole.ADMIN.equals(userRole);
    }

    public UserRole getRole() {return this.userRole;}

    public enum UserRole {
        CUSTOMER("Customer"),
        ADMIN("Admin");

        private final String name;

        private UserRole(String name) {this.name = name;}

        public String getName() {return name;}
    }
}



