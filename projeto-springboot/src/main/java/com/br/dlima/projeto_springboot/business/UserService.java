package com.br.dlima.projeto_springboot.business;

import com.br.dlima.projeto_springboot.infrastruture.entities.User;
import com.br.dlima.projeto_springboot.infrastruture.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(User user){
        repository.saveAndFlush(user);
    }

    public User getUserByEmail(String email) {
        return repository.getUserByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado!")
        );
    }

    public void deleteUserByEmail(String email) {
        repository.deleteUserByEmail(email);
    }

    public void updateUserByEmail(String email, User user) {
        User userEntity = getUserByEmail(email);
        User userNew = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userNew);
    }
}
