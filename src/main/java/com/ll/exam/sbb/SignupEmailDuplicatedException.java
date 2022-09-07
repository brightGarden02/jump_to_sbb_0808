package com.ll.exam.sbb;

public class SignupEmailDuplicatedException extends RuntimeException {

    public SignupEmailDuplicatedException(String message) {
        super(message);
    }
}
