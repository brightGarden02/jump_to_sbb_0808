package com.ll.exam.sbb.question.repository;

import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.base.RepositoryUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long>, RepositoryUtil {
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject, String content);

    List<Question> findBySubjectLike(String s);


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE question AUTO_INCREMENT = 1", nativeQuery = true)
    void truncate(); // 이거 지우면 안됨, truncateTable 하면 자동으로 이게 실행됨


    Page<Question> findBySubjectContains(String kw, Pageable pageable);
}
