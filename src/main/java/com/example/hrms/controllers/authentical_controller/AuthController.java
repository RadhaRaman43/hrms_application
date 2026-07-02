package com.example.hrms.controllers.authentical_controller;

import com.example.hrms.dto.user_dto.LoginResponseDto;
import com.example.hrms.dto.user_dto.LoginRequestDto;
import com.example.hrms.Modals.user.User;
import com.example.hrms.dto_request.AuthenticationRequestDto;
import com.example.hrms.security.JwtUtil;
import com.example.hrms.service.user_service.user_service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:62610")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    /*@Autowired
    private UserMapper mapper;*/

    @PostMapping("/api/users/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthenticationRequestDto user) {


        User savedUser = service.register(user);
        //UserResponseDTO response = mapper.toDTO(savedUser);

        return ResponseEntity.ok(
                new LoginResponseDto(true, "User registered successfully", null, savedUser)
        );
    }
    @PostMapping("/api/auth/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {
        try {
            User user;
            try {
                user = service.findByEmail(request.getEmail());
            } catch (UsernameNotFoundException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new LoginResponseDto(false, "Enter valid email", null, null));
            }

            // ✅ Step 2: Check password manually
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new LoginResponseDto(false, "Enter valid password", null, null));
            }
            // ✅ Authenticate directly (best practice)
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword())
            );

            // ✅ If authentication passes → get user
           // User user = service.findByEmail(request.getEmail());

            String token = jwtUtil.generateToken(user.getEmail());
            System.out.println("user detail "+user);
            //UserResponseDTO response = mapper.toDTO(user);
            return ResponseEntity.ok(
                    new LoginResponseDto(true, "Login successful", token, user)
            );


        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponseDto(false, "Login failed", null, null));
        }
    }

    @PostMapping("/api/forgot/send-otp")
    public ResponseEntity<?> sendOtp(@RequestParam String input) {
        return ResponseEntity.ok("OTP sent");
    }

    @PostMapping("/forgot/verify-otp")
    public ResponseEntity<?> verifyOtp(
            @RequestParam String input,
            @RequestParam String otp) {

        //boolean valid = otpService.validateOtp(input, otp);

       /* if (!valid) {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }*/

        String token = jwtUtil.generateResetToken(input);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/forgot/reset-password")
    public ResponseEntity<?> resetPassword(
            @RequestHeader("Authorization") String token,
            @RequestParam String newPassword) {

        token = token.substring(7);

        if (!jwtUtil.isResetToken(token)) {
            return ResponseEntity.badRequest().body("Invalid token");
        }

        String emailOrPhone = jwtUtil.extractEmail(token);

        service.updatePassword(emailOrPhone, newPassword);

        return ResponseEntity.ok("Password updated successfully");
    }


}