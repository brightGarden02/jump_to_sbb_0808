package com.ll.exam.sbb.user.repository;

import com.ll.exam.sbb.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

    boolean existsByUsername(String username);
}
