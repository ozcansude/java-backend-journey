package com.ozcansude.practice.expense;

import com.ozcansude.practice.expense.exception.ExpenseNotFoundException;
import com.ozcansude.practice.expense.exception.InvalidCategoryException;
import com.ozcansude.practice.expense.exception.InvalidExpenseAmountException;

import java.util.List;



public class ExpenseApp {
    public static void main(String[] args){

        ExpenseRepository expenseRepository = new ExpenseRepository();

        ExpenseService expenseService = new ExpenseService(expenseRepository);

        Expense e1 = new Expense(1,"Market",1000);
        Expense e2 = new Expense(2,"Ulaşım",150);
        Expense e3 = new Expense(3,"Market",400);
        Expense e4 = new Expense(4,"Yemek",350);
        Expense e5 = new Expense(5,"Eğlence",700);

        expenseService.addExpense(e1);
        expenseService.addExpense(e2);
        expenseService.addExpense(e3);
        expenseService.addExpense(e4);
        expenseService.addExpense(e5);


        List<Expense> expenseList = expenseService.getAllExpenses();

        for(Expense expense : expenseList){
            System.out.println(expense);
        }
 //// -------------------------
        System.out.println(expenseService.findExpenseById(3));

        expenseService.updateExpense(3,"Yemek",450);
        System.out.println(expenseService.findExpenseById(3));
//// -------------------------


        expenseService.removeExpense(4);
        List<Expense> expenseList1 = expenseService.getAllExpenses();

        for(Expense expense : expenseList1){
            System.out.println(expense);
        }
 //// -------------------------

        System.out.println(expenseService.getExpensesGroupedByCategory());


        Expense e6 = new Expense(6,"Ulaşım",-500);
        try{
            expenseService.addExpense(e6);
        }catch(InvalidExpenseAmountException e){
            System.out.println(e.getMessage());
        }

        Expense e7 = new Expense(7, "",500);
        try{
            expenseService.addExpense(e7);
        }catch(InvalidCategoryException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\nFind expense by id");
        try{
            expenseService.findExpenseById(99);
        }catch(ExpenseNotFoundException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Total Expenses : " + expenseService.getTotalExpenseAmount());


        System.out.println("\n--- STREAM API TESTS ---");

        System.out.println("Expenses above amount:");
        expenseService.getExpensesAboveAmount(150)
                .forEach(System.out::println);

        System.out.println("\nSorted expenses:");
        expenseService.getExpensesSortedByAmount()
                .forEach(System.out::println);

        System.out.println("\nTotal expense amount:");
        System.out.println(expenseService.getTotalExpenseAmount());


        System.out.println("\nMost expensive expense:");
        expenseService.getMostExpensiveExpense()
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No expenses found")
                );

        System.out.println("\nExpenses grouped by category:");
        expenseService.getExpensesGroupedByCategory()
                .forEach((category, expenses) -> {
                    System.out.println(category + ":");
                    expenses.forEach(System.out::println);
                });

        System.out.println("\nTotal amount by category:");
        expenseService.getTotalAmountByCategory()
                .forEach((category, total) ->
                        System.out.println(category + ": " + total)
                );

    }
}
