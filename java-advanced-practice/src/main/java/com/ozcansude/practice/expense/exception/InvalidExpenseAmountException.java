package com.ozcansude.practice.expense.exception;

public class InvalidExpenseAmountException extends RuntimeException{
    private String message;

    public InvalidExpenseAmountException(String message){
       super(message);
    }

}
