package com.example.demoSecurity.controller;

import com.example.demoSecurity.config.JwtUtil;
import com.example.demoSecurity.dto.AuthRequest;
import com.example.demoSecurity.dto.AuthResponse;
import com.example.demoSecurity.model.User;
import com.example.demoSecurity.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    public AuthController(AuthenticationManager authenticationManager,UserRepository userRepository,JwtUtil jwtUtil,PasswordEncoder passwordEncoder){
        this.authenticationManager=authenticationManager;
        this.jwtUtil=jwtUtil;
        this.passwordEncoder=passwordEncoder;
        this.userRepository=userRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request){
        User user=new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        userRepository.save(user);
        return  ResponseEntity.ok("user registered");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        String token=jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String header){
        String token=header.substring(7);
        String username=jwtUtil.extractUsername(token);
        boolean valid=jwtUtil.isTokenValid(token,username);
        return valid ? ResponseEntity.ok("Token is valid") : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
    }
}
