package com.ll.exam.sbb.answer.controller;


import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;

    public String detail(Model model, @PathVariable int id, String content) {
        Question question = this.questionService.getQuestion(id);


        //답변 등록 시작
        //답변 등록 끝

        return "redirect:/question/detail/%d".formatted(id);
    }

}
