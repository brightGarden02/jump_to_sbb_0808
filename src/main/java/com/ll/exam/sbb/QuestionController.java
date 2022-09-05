package com.ll.exam.sbb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("list")
    @ResponseBody
    public String showList() {
        questionService.findById(1);

        return "HI";
    }

}
