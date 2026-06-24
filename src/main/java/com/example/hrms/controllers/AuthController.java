package com.example.hrms.controllers;

import com.example.hrms.entity.user.LoginRequest;
import com.example.hrms.entity.user.LoginResponse;
import com.example.hrms.entity.user.User;
import com.example.hrms.security.JwtUtil;
import com.example.hrms.service.user_service.user_service.UserService;
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
    public ResponseEntity<?> register(@RequestBody User user) {
        if(user.getEmail()==null||user.getEmail().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Valid Email", null, null));
        }
        //  Check email already exists
        if (service.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Email is already used. Use another email", null, null));
        }
        //System.out.println("print pass "+user.getPassword());
        if(user.getPassword()==null||user.getPassword().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Valid Password", null, null));
        }
        user.setEmployeeId(service.generateEmployeeId());
        System.out.println(user.getEmployeeId());
        if(user.getFirstname()==null||user.getFirstname().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter First Name", null, null));
        }
        if(user.getLastname()==null||user.getLastname().isEmpty()){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Last Name", null, null));
        }
        if(user.getMiddlename()!=null || user.getMiddlename().equals("")){
            System.out.println("middle name is not empty ");
            user.setUsername(user.getFirstname()+" "+user.getMiddlename()+" "+user.getLastname());
        }
        else {
            user.setUsername(user.getFirstname()+" "+user.getLastname());
        }

        if(user.getAddress1()==null||user.getAddress1().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Address1", null, null));
        }
        if(user.getAddress2()==null||user.getAddress2().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Address2", null, null));
        }
        if(user.getCity()==null||user.getCity().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter City", null, null));
        }
        if(user.getPostCode()==null||user.getPostCode().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Post Code", null, null));
        }
        if(user.getState()==null||user.getState().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter State", null, null));
        }
        if(user.getPhoneNo()==null||user.getPhoneNo().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Mobile No", null, null));
        }
        if(user.getGender()==null||user.getGender().equals("")){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new LoginResponse(false, "Please Enter Gender", null, null));
        }
        user.setIsActive(true);


        //  Default role
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("employee");
        }

        User savedUser = service.register(user);
        //UserResponseDTO response = mapper.toDTO(savedUser);

        return ResponseEntity.ok(
                new LoginResponse(true, "User registered successfully", null, savedUser)
        );
    }
    @PostMapping("/api/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        try {
            User user;
            try {
                user = service.findByEmail(request.getEmail());
            } catch (UsernameNotFoundException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new LoginResponse(false, "Enter valid email", null, null));
            }

            // ✅ Step 2: Check password manually
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new LoginResponse(false, "Enter valid password", null, null));
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
                    new LoginResponse(true, "Login successful", token, user)
            );


        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginResponse(false, "Login failed", null, null));
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