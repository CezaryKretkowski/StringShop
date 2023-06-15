package com.example.StringShop.repositories;

import com.example.StringShop.entites.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepositories extends JpaRepository<User,UUID> {
    Optional<User> findUserByEmail(String email);
}
