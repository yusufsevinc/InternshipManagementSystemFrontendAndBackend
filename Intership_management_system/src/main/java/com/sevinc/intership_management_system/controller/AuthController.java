package com.sevinc.intership_management_system.controller;

import com.sevinc.intership_management_system.dto.AuthResponseDTO;
import com.sevinc.intership_management_system.dto.UserLoginRequestDTO;
import com.sevinc.intership_management_system.model.User;
import com.sevinc.intership_management_system.repository.UserRepository;
import com.sevinc.intership_management_system.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    @PostMapping("login")
    public AuthResponseDTO login(@RequestBody UserLoginRequestDTO loginRequest){
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail()
                ,loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(auth);
        User user = userRepository.findByEmail(loginRequest.getEmail());
        authResponseDTO.setId(user.getUserId());
        authResponseDTO.setEmail(user.getEmail());
        authResponseDTO.setFullName(user.getFullName());
        authResponseDTO.setRole(user.getRole());
        authResponseDTO.setToken("Bearer " + jwtToken);
        return authResponseDTO;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserLoginRequestDTO registerRequest) {


        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setEmailPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setEnabled(true);
        user.setFullName(registerRequest.getFullName());
        user.setRole(registerRequest.getRole());
        userRepository.save(user);

        return new ResponseEntity<>("succesfull", HttpStatus.CREATED);
    }
}
