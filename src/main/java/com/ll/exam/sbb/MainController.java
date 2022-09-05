package com.ll.exam.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
