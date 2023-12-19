package com.ntreddy.dd.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByOrderByIdAsc();

    Page<User> findAllByOrderByIdAsc(Pageable pageable);

    Optional<User> findByActivationCode(String code);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

//    @Query("SELECT user.email FROM ddcloud.Users user WHERE user.password_Reset_Code = :code")
//    Optional<String> getEmailByPasswordResetCode(String code);
}
