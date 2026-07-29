package hashmap.expense;

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

        Expense e1 = new Expense("Market",500);
        Expense e2 = new Expense("Ulaşım",100);
        Expense e3 = new Expense("Yemek",800);
        Expense e4 = new Expense("Eğlence",1000);
        Expense e5 = new Expense("Market",1500);
        Expense e6 = new Expense("Eğlence",750);
        Expense e7 = new Expense("Fatura",2500);
        Expense e8 = new Expense("Ulaşım",80);

        expenses.add(e1);
        expenses.add(e2);
        expenses.add(e3);
        expenses.add(e4);
        expenses.add(e5);
        expenses.add(e6);
        expenses.add(e7);
        expenses.add(e8);

        ExpenseService expenseService = new ExpenseService();

        Map<String, List<Expense>> groupedExpenses = expenseService.groupByCategory(expenses);

        System.out.println(groupedExpenses);



    }
}
