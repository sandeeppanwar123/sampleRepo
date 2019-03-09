package org.mapper.memory.service;

import org.mapper.memory.dto.SignUpDTO;
import org.mapper.memory.entity.User;
import org.mapper.memory.repository.UserRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class LoginService {
    private UserRepo userRepo;

    public LoginService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Mono<User> createUser(SignUpDTO signUpDTO) {

        User user = new User();
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(signUpDTO.getPassword());
        user.setUserId(UUID.randomUUID().toString().substring(0, 8));

        return Mono.just(user)
                .flatMap(userRepo::save);
    }
}
