package com.alamgir.l_spring_boot_security_jwt.user.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alamgir.l_spring_boot_security_jwt.user.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    Integer deleteByEmail(String email);
    // Optional<User> findByEmail(String email);
    User findByEmail(String email);
}
