package com.ll.exam.sbb.base;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RepositoryUtil {

    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 0", nativeQuery = true)
    void disableForeignKeyChecks();

    @Transactional
    @Modifying
    @Query(value = "SET FORIGN_KEY_CHECKS = 1", nativeQuery = true)
    void enableForeignKeyChecks();

    void truncate();

    default void truncateTable() {
        disableForeignKeyChecks();
        truncate();
        enableForeignKeyChecks();
    }

}
