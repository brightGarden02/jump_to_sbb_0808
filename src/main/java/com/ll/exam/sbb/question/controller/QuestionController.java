package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.question.repository.QuestionRepository;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor // 생성자 주입
public class QuestionController {

    // @Autowired //필드주입
    private final QuestionService questionService;

    @RequestMapping("/question/list")
//    @ResponseBody
    // 이 자리에 @ResponseBody가 없으면 resources/question_list/question_list.html 파일을 뷰로 삼는다.
    public String list(Model model) {

        List<Question> questionList = questionService.getList();

        //미래에 실행된 question_list.html에서
        //questionList라는 이름으로 questionList 변수를 사용할 수 있다
        model.addAttribute("questionList", questionList);

        return "question_list";
    }


}
