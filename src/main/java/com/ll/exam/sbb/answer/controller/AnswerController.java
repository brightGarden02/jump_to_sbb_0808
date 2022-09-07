package com.ll.exam.sbb.answer.controller;


import com.ll.exam.sbb.answer.service.AnswerService;
import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/answer")
@Controller
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    public String detail(Model model, @PathVariable Long id, @Valid AnswerForm answerForm, BindingResult bindingResult) {

        Question question = this.questionService.getQuestion(id);

        if(bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }


        //답변 등록 시작
        answerService.create(question, answerForm.getContent());
        //답변 등록 끝

        return "redirect:/question/detail/%d".formatted(id);
    }

}
