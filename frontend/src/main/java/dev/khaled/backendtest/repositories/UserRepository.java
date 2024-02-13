package dev.khaled.backendtest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.khaled.backendtest.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
