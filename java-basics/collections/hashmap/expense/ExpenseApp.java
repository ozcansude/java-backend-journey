package hashmap.expense;

import hashmap.expense.exception.ExpenseNotFoundException;
import hashmap.expense.exception.InvalidCategoryException;
import hashmap.expense.exception.InvalidExpenseAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*

Metottan dönen sonucu ayrı bir Map<String, List<Expense>> değişkeninde tut.
Sonucu konsola yazdır.
 */
public class ExpenseApp {
    public static void main(String[] args){

        List<Expense> expenses = new ArrayList<>();

        Expense e1 = new Expense(1,"Market",500);
        Expense e2 = new Expense(2,"Ulaşım",100);
        Expense e3 = new Expense(3,"Yemek",800);
        Expense e4 = new Expense(4,"Eğlence",1000);
        Expense e5 = new Expense(5,"Market",1500);
        Expense e6 = new Expense(6,"Eğlence",750);
        Expense e7 = new Expense(7,"Fatura",2500);
        Expense e8 = new Expense(8,"Ulaşım",80);

        expenses.add(e1);
        expenses.add(e2);
        expenses.add(e3);
        expenses.add(e4);
        expenses.add(e5);
        expenses.add(e6);
        expenses.add(e7);
        expenses.add(e8);

        for(Expense expense : expenses){
            ExpenseService.addExpense(expense);
        }

        ExpenseService expenseService = new ExpenseService();

        Map<String, List<Expense>> groupedExpenses = expenseService.groupByCategory(expenses);

        System.out.println(groupedExpenses);

        try{
            Expense e9 = new Expense(9,"", 1000);
            ExpenseService.addExpense(e9);
        }catch (InvalidCategoryException e){
            System.out.println("Category error : " + e.getMessage());
        }
        System.out.println("Program devam ediyor");

        try{
            Expense e10 = new Expense(10, "Eğlence", -700);
            ExpenseService.addExpense(e10);
        }catch(InvalidExpenseAmountException e){
            System.out.println("Amount error : "+ e.getMessage());
        }
        System.out.println("Program devam ediyor");


        try{
            ExpenseService.findExpenseById(11);
        }catch (ExpenseNotFoundException e){
            System.out.println("Not found error : "+ e.getMessage());
        }
        System.out.println("Program devam ediyor");


    }
}
