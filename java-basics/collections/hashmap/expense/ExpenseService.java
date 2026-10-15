package hashmap.expense;

import hashmap.expense.exception.ExpenseNotFoundException;
import hashmap.expense.exception.InvalidCategoryException;
import hashmap.expense.exception.InvalidExpenseAmountException;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import java.util.stream.Collectors;

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

        public List<Expense> findExpensesAboveAmount(int amount) {
            List<Expense> expenseList = new ArrayList<>();
            Predicate<Expense> predicate = expense -> expense.getAmount() > amount;
            for (Expense expense : getAllExpenses()) {
                if (predicate.test(expense)) {
                    expenseList.add(expense);
                }
            }
            return expenseList;
        }

        public List<Expense> findExpensesByCategory(String category){
            List<Expense> expenseList = new ArrayList<>();
            Predicate<Expense> control = expense -> expense.getCategory().equals(category);

            for (Expense expense : getAllExpenses()){
                if(control.test(expense)){
                    expenseList.add(expense);
                }
            }
            return expenseList;
        }
        public List<String> getExpenseNames(){
            List<String> liste = new ArrayList<>();
            Function<Expense, String> donustur = expense -> expense.getCategory().toUpperCase();
            for(Expense expense : getAllExpenses()){
                liste.add(donustur.apply(expense));
            }
            return liste;
        }
        public void printAllExpenses(){
            Consumer<Expense> islem = expense -> System.out.println(expense);
            for(Expense expense : getAllExpenses()){
                islem.accept(expense);
            }
        }

        public List<Expense> getExpensesAbove500(){
            List<Expense> expenseList = expenseRepository.findAll();
            List<Expense> expenses= expenseList.stream()
                     .filter(e-> e.getAmount()>500)
                     .collect(Collectors.toList());
            return expenses;
        }

    public List<Expense> getExpensesSortedByAmount() {
        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream()
                .sorted(Comparator.comparingDouble(Expense::getAmount).reversed())
                .collect(Collectors.toList());
    }
    public double getTotalExpenseAmount() {
        List<Expense> expenseList = expenseRepository.findAll();
        double total = expenseList.stream()
                .map(e -> (double)e.getAmount())
                .reduce(0.0, (a,b) -> a + b);
        return total;

        }
        public Optional<Expense> getMostExpensiveExpense() {
            List<Expense> expenseList = expenseRepository.findAll();
            Optional<Expense> mostExpensiveOptional = expenseList.stream()
                .max(Comparator.comparingInt(Expense::getAmount));
            return mostExpensiveOptional;
        }
        public Map<String, List<Expense>> getExpensesGroupedByCategory(){
            List<Expense> expenseList = expenseRepository.findAll();
            Map<String,List<Expense>> grouped= expenseList.stream()
                    .collect(Collectors.groupingBy(Expense::getCategory));
            return grouped;
        }
    public Map<String, Integer> getPriceGroupedByCategory(){
        List<Expense> expenseList = expenseRepository.findAll();
        Map<String,Integer> grouped= expenseList.stream()
                .collect(Collectors.groupingBy(Expense::getCategory,Collectors.summingInt(Expense::getAmount)));
        return grouped;
    }


}
