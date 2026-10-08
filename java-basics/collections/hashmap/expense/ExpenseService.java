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

    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }


        public void addExpense(Expense expense) {
            if (expense.getAmount() <= 0) {
                throw new InvalidExpenseAmountException("Amount must be greater than 0");
            }
            if (expense.getCategory() == null || expense.getCategory().isBlank()) {
                throw new InvalidCategoryException("Category cannot be empty");
            }
            expenseRepository.save(expense);
        }
        public Expense findExpenseById(int id){
           Expense e = expenseRepository.findById(id);
           if(e == null){
                throw new ExpenseNotFoundException("Expense not found");
           }
           return e;
        }
        public void removeExpense(int id){
            boolean deleted = expenseRepository.deleteById(id);
            if(!deleted){
                throw new ExpenseNotFoundException("Expense not found!");
            }

        }
        public void updateExpense(int id, String newCategory, int newAmount){
            Expense expense = findExpenseById(id);
            if(newAmount <= 0){
                throw new InvalidExpenseAmountException("Amount must be greater than 0");
            }
            if(newCategory == null || newCategory.isBlank()){
                throw new InvalidCategoryException("Category cannot be empty");
            }
            expense.setCategory(newCategory);
            expense.setAmount(newAmount);

            expenseRepository.update(id,expense);
        }

        public void updateExpenseAmount(int id, int newAmount){
            Expense expense = findExpenseById(id);
            if(newAmount <= 0){
                throw new InvalidExpenseAmountException("Amount must be greater than 0");
            }
            expense.setAmount(newAmount);
            expenseRepository.update(id,expense);
        }
        public void updateExpenseCategory(int id, String newCategory){
            Expense expense = findExpenseById(id);
            if( newCategory == null || newCategory.isBlank() ){
                throw new InvalidCategoryException("Category cannot be empty");
            }
            expense.setCategory(newCategory);
            expenseRepository.update(id,expense);
        }

        public Map<String, List<Expense>> groupByCategory(){
            List<Expense> expenses= expenseRepository.findAll();
            Map<String, List<Expense>> groupExpenses = new HashMap<>();

            for(Expense expense : expenses){
                String category = expense.getCategory();
                if(!groupExpenses.containsKey(category)){
                    List<Expense> categoryExpenses = new ArrayList<>();
                    categoryExpenses.add(expense);
                    groupExpenses.put(category,categoryExpenses);
                }else{
                    List<Expense> existingList = groupExpenses.get(category);
                    existingList.add(expense);
                }
            }
            return groupExpenses;

        }

        public List<Expense> getAllExpenses(){
            return expenseRepository.findAll();
        }

}
