package com.ll.exam.sbb.answer.service;

import com.ll.exam.sbb.answer.entity.Answer;
import com.ll.exam.sbb.answer.repository.AnswerRepository;
import com.ll.exam.sbb.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question, String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answerRepository.save(answer);
    }
}
