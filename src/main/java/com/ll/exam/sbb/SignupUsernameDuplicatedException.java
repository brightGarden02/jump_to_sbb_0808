package com.ll.exam.sbb;

public class SignupUsernameDuplicatedException extends RuntimeException {

    public SignupUsernameDuplicatedException(String message) {
        super(message);
    }
}
