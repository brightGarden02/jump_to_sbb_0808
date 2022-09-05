package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

    private int increaseNo = -1;


    @RequestMapping("/sbb")

    @ResponseBody
    public String index() {
        System.out.println("Hello");
        return "안녕하세요~";
    }


    @GetMapping("/page1")
    @ResponseBody
    public String showPage1() {
        return """
                <form method="POST" action="/page2">
                    <input type="number" name="age" placeholder="나이" />
                    <input type="submit" value="page2로 POST 방식으로 이동">
                    </form>
                """;
    }


    @PostMapping("/page2")
    @ResponseBody
    public String showPage2Post(@RequestParam(defaultValue = "0") int age) {
        return """
               <h1>입력된 나이 : %d</h1>
               <h1>안녕하세요, POST 방식으로 오렸군요.</h1>
               """.formatted(age);
    }


    @GetMapping("/page2")
    @ResponseBody
    public String showPage2Get(@RequestParam(defaultValue = "0") int age) {
        return """
               <h1>입력된 나이 : %d</h1>
               <h1>안녕하세요, POST 방식으로 오렸군요.</h1>
               """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public int showPlus(int a, int b) {
        return a + b;
    }


    @GetMapping("/plus2")
    @ResponseBody
    public void showPlus2(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int a = Integer.parseInt(req.getParameter("a"));
        int b = Integer.parseInt(req.getParameter("b"));

        resp.getWriter().append(a + b + "");
    }



    @GetMapping("/minus")
    @ResponseBody
    public int showMinus(int a, int b) {
        return a - b;
    }

    @GetMapping("/gugudan")
    @ResponseBody
    public String showGugudan(Integer dan, Integer limit) { // Integer: null 허용

        if(limit == null) {
            limit = 9;
        }

        if(dan == null) {
            dan = 9;
        }

//        final Integer finalDan = dan;
        Integer finalDan = dan;

        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> "%d * %d = %d".formatted(finalDan, i, finalDan * i))
                .collect(Collectors.joining("<br>\n"));
    }


    @GetMapping("/mbti/{name}")
    @ResponseBody
    public String showMbti(@PathVariable String name) {
        return switch (name) {
            case "홍길순" -> {
                char j = 'J';
                yield "INF" + j; // yield: switch문 안에서의 return
            }
            case "임꺽정" -> "ENFP";
            case "장희성", "홍길동" -> "INFP";
            default -> "모름";
        };
    }


    @GetMapping("/saveSession/{name}/{value}")
    @ResponseBody
    public String saveSession(@PathVariable String name, @PathVariable String value, HttpServletRequest req) {

        HttpSession session = req.getSession();
        session.setAttribute(name, value);

        return "세션변수 %s의 값이 %s(으)로 설정되었습니다.".formatted(name, value);
    }


    @GetMapping("/getSession/{name}")
    @ResponseBody
    public String getSession(@PathVariable String name, HttpSession session) {
        String value = (String) session.getAttribute(name);

        return "세션변수 %s의 값이 %s입니다.".formatted(name, value);
    }


}
