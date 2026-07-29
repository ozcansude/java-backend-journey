package hashmap.expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExpenseService {


    public Map<String, List<Expense>> groupByCategory(List<Expense> expenses){

        Map<String, List<Expense>> expensesByCategory = new HashMap<>();


        for(Expense expense : expenses){
            if(!expensesByCategory.containsKey(expense.getCategory())){
                List<Expense> temp = new ArrayList<>();
                expensesByCategory.put(expense.getCategory(), temp) ;
            }
            List<Expense> categoryExpenses = expensesByCategory.get(expense.getCategory());
            categoryExpenses.add(expense);
        }

        return expensesByCategory;
    }
}
