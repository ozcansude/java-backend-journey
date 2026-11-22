package com.ozcansude.practice.expense.exception;

public class DuplicateExpenseException extends RuntimeException {
    public DuplicateExpenseException(String message, Throwable cause) {
        super(message,cause);
    }
}
