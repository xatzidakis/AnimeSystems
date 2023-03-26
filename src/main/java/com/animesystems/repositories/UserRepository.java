package com.animesystems.repositories;
// extend JpaRepository and pass parameters (first the entity, second the primary key Long

import com.animesystems.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
