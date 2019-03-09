package org.mapper.memory.resources;

import org.mapper.memory.dto.SignUpDTO;
import org.mapper.memory.entity.User;
import org.mapper.memory.service.LoginService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class LoginResources {

    private LoginService loginService;

    public LoginResources(LoginService loginService) {
        this.loginService = loginService;
    }

    @PutMapping("/{signup}")
    public Mono<User> signUp(@RequestBody SignUpDTO signUpDTO) {
        return loginService.createUser(signUpDTO);

    }

}
