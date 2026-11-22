package com.ozcansude.practice.expense.exception;

public class InvalidExpenseAmountException extends RuntimeException{

    public InvalidExpenseAmountException(String message){

        super(message);
    }

}