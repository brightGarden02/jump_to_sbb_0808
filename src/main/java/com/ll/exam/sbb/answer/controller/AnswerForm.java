package com.ll.exam.sbb.answer.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
public class AnswerForm {

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
