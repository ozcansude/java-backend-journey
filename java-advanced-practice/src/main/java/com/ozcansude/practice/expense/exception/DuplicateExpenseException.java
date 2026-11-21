package com.ozcansude.practice.expense.exception;


public class DuplicateExpenseException extends RuntimeException {
    private String message;
    public DuplicateExpenseException(String message, Throwable cause) {
        super(message);
    }
}
