package com.ozcansude.practice.expense.exception;

public class ExpenseNotFoundException extends RuntimeException{
    private String message;
    public ExpenseNotFoundException(String message){
        super(message);
    }


}
