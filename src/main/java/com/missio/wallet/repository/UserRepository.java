package com.missio.wallet.repository;

import com.missio.wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailEquals(String email);
    Optional<User> findByEmail(String email);
}
