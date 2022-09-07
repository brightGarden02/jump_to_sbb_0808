package com.ll.exam.sbb.question.service;

import com.ll.exam.sbb.DataNotFoundException;
import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(int id) {

        return questionRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("no %d question not found,".formatted(id)));
    }

    public void create(String subject, String content) {

        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

    }
}
