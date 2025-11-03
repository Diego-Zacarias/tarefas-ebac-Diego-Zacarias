package com.br.dlima.projeto_springboot.infrastruture.repository;

import com.br.dlima.projeto_springboot.infrastruture.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> getUserByEmail(String email);

    @Transactional
    void deleteUserByEmail(String email);
}
