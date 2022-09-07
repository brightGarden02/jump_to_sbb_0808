package com.ll.exam.sbb.answer.service;

import com.ll.exam.sbb.DataNotFoundException;
import com.ll.exam.sbb.answer.entity.Answer;
import com.ll.exam.sbb.answer.repository.AnswerRepository;
import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setAuthor(author);
        question.addAnswer(answer);

        answerRepository.save(answer);

        return answer;
    }

    public Answer getAnswer(Long id) {
        return answerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("answer not found"));

    }

    public void modify(Answer answer, String content) {
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);

        answerRepository.save(answer);
    }
}
