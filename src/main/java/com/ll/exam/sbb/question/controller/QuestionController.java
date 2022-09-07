package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @RequestMapping("/question/list")
    @ResponseBody
    public String list() {
        return "question list";
    }

}
