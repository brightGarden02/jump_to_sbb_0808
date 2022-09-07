package com.ll.exam.sbb.question.controller;

import com.ll.exam.sbb.question.entity.Question;
import com.ll.exam.sbb.question.repository.QuestionRepository;
import com.ll.exam.sbb.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor // 생성자 주입
// 컨트롤러는 Repository가 있는지 몰라야 한다.
// 서비스는 웹브라우저라는것이 이 세상에 존재하는지 몰라야 한다.
// 리포지터리는 서비스를 몰라야 한다.
// 서비스는 컨트롤러를 몰라야 한다.
// DB는 리포지터리를 몰라야 한다.
// SPRING DATA JPA는 MySQL을 몰라야 한다.
// SPRING DATA JPA(리포지터리) -> JPA -> 하이버네이트 -> JDBC -> MySQL Driver -> MySQL
public class QuestionController {

    // @Autowired //필드주입
    private final QuestionService questionService;

    @RequestMapping("/list")
//    @ResponseBody
    // 이 자리에 @ResponseBody가 없으면 resources/question_list/question_list.html 파일을 뷰로 삼는다.
    public String list(Model model) {

        List<Question> questionList = questionService.getList();

        //미래에 실행된 question_list.html에서
        //questionList라는 이름으로 questionList 변수를 사용할 수 있다
        model.addAttribute("questionList", questionList);

        return "question_list";
    }


    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        Question question = questionService.getQuestion(id);

        model.addAttribute("question", question);

        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }


    @PostMapping("/create")
    public String questionCreate(String subject, String content) {
        questionService.create(subject, content);
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

}
