package com.br.dlima.projeto_springboot.controller;

import com.br.dlima.projeto_springboot.business.UserService;
import com.br.dlima.projeto_springboot.infrastruture.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping

    public ResponseEntity<Void> createUser(@RequestBody User user) {
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserById(@RequestParam Integer id, @RequestBody User user) {
        //userService.
        return ResponseEntity.ok().build();
    }
}
