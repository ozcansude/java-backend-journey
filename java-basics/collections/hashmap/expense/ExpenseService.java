package hashmap.expense;

import hashmap.expense.exception.ExpenseNotFoundException;
import hashmap.expense.exception.InvalidCategoryException;
import hashmap.expense.exception.InvalidExpenseAmountException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//1. ExpenseService içinde geçersiz tutar, bulunamayan harcama ve boş kategori durumlarında bu exception’ları fırlat.
public class ExpenseService {
    private static Map<Integer,Expense> expenseMap = new HashMap<>();

    public static Map<String, List<Expense>> groupByCategory(List<Expense> expenses){

        Map<String, List<Expense>> expensesByCategory = new HashMap<>();


        for(Expense expense : expenses){
            if (expense.getCategory() == null || expense.getCategory().isBlank()) {
                throw new InvalidCategoryException("Category cannot be empty");
            }

            if(!expensesByCategory.containsKey(expense.getCategory())){
                List<Expense> temp = new ArrayList<>();
                expensesByCategory.put(expense.getCategory(), temp) ;
            }
            List<Expense> categoryExpenses = expensesByCategory.get(expense.getCategory());
            categoryExpenses.add(expense);
        }

        return expensesByCategory;
    }
    public static void addExpense(Expense expense){

        if(expense.getAmount() <= 0){
            throw new InvalidExpenseAmountException("Expense amount must be greater than 0");
        }
        if(expense.getCategory() == null || expense.getCategory().isBlank()){
            throw new InvalidCategoryException("Category cannot be empty");
        }

        expenseMap.put(expense.getId(), expense);

    }
    public static Expense findExpenseById(int id){

        if(expenseMap.containsKey(id)){
           return expenseMap.get(id);
        }

        throw new ExpenseNotFoundException("Expense not found");

    }

    public static void removeExpense(int id){
        findExpenseById(id);
        expenseMap.remove(id);
    }
    public static void updateExpense(int id, String newCategory, int newAmount){
        Expense expense = findExpenseById(id);
        if(newAmount <= 0){
            throw new InvalidExpenseAmountException("Invalid amount\nExpense amount must be greater than 0");
        }
        if(newCategory == null || newCategory.isBlank()){
            throw new InvalidCategoryException("Category cannot be empty");
        }
        expense.setCategory(newCategory);
        expense.setAmount(newAmount);
    }
    public static void updateExpenseAmount(int id, int newAmount){
        Expense expense = findExpenseById(id);

        if(newAmount <= 0){
            throw new InvalidExpenseAmountException("Invalid amount\nExpense amount must be greater than 0");
        }
        expense.setAmount(newAmount);

    }

    public static void updateExpenseCategory(int id, String newCategory){
        Expense expense = findExpenseById(id);
        if(newCategory == null || newCategory.isBlank()){
            throw new InvalidCategoryException("Category cannot be empty");
        }
        expense.setCategory(newCategory);
    }





}
