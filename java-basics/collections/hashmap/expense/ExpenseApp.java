package hashmap.expense;

import hashmap.expense.exception.ExpenseNotFoundException;
import hashmap.expense.exception.InvalidCategoryException;
import hashmap.expense.exception.InvalidExpenseAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
        List<Expense> expenseList = expenseService.getAllExpenses();

        for(Expense expense : expenseList){
            System.out.println(expense);
        }
 //// -------------------------

        System.out.println(expenseService.groupByCategory());
         // -------------------------

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

        try{
            expenseService.findExpenseById(99);
        }catch(ExpenseNotFoundException e){
            System.out.println(e.getMessage());
        }



    }
}
