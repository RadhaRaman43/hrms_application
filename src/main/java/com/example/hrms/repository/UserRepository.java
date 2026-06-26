package com.example.hrms.repository;

import com.example.hrms.Modals.user.User;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByPhoneNo(String phoneNo);

    @Query("SELECT u FROM User u WHERE u.email = :identifier OR u.phoneNo = :identifier")
    Optional<User> findByEmailOrPhone(@Param("identifier") String identifier);
    boolean existsByEmail(String email);

    @Query(value = "SELECT employee_id FROM users ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findLastEmployeeId();
}
