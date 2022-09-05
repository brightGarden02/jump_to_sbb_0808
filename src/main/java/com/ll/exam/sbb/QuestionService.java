package com.ll.exam.sbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {


    @Autowired
    private QuestionRepository questionRepository;

    public Question findById(int id) {
        Question q1 = questionRepository.findById(2).get();
        Question q2 = questionRepository.findById(2).get();

        System.out.println(q2.getAnswerList());

        return q2;
    }

}
