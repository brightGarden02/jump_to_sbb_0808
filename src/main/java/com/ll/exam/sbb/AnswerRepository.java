package com.ll.exam.sbb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @Transactional
    @Modifying
    @Query(value = "trauncate answer", nativeQuery = true)
    void truncate();

    @Transactional
    @Modifying
    @Query(value = "SET FORGIN_KEY_CHECKS = 0", nativeQuery = true)
    void disableForeignKeyChecks();


    @Transactional
    @Modifying
    @Query(value = "SET FORGIN_KEY_CHECKS = 1", nativeQuery = true)
    void enableForeignKeyChecks();

}
