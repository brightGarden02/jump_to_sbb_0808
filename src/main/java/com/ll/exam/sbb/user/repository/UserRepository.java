package com.ll.exam.sbb.user.repository;

import com.ll.exam.sbb.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

    boolean existsByUsername(String username);

    Optional<SiteUser> findByUsername(String username);
}
