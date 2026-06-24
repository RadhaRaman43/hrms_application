package com.example.hrms.service.user_service.user_service;

import com.example.hrms.entity.user.User;
import com.example.hrms.repository.user_repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));
    }
    public boolean existsByEmail(String email) {
        return repo.existsByEmail(email);
    }
    public String generateEmployeeId() {
        String lastId = repo.findLastEmployeeId();
        if (lastId == null) {
            return "CUSEMP001";
        }
        // Extract number
        int num = Integer.parseInt(lastId.substring(6));
        num++;
        return String.format("CUSEMP%03d", num);
    }
    public void updatePassword(String emailOrPhone, String password) {
        //User user = repo.findUser(emailOrPhone);
        //user.setPassword(passwordEncoder.encode(password));
        //repo.save(user);
    }
}
