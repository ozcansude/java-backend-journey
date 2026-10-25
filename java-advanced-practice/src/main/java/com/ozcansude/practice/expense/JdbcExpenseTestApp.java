package com.ozcansude.practice.expense;

import java.util.List;

public class JdbcExpenseTestApp {
    public static void main(String[] args){
        JdbcExpenseRepository repository = new JdbcExpenseRepository(
                "jdbc:postgresql://localhost:5432/expense_db",
                "postgres",
                System.getenv("DB_PASSWORD")
        );

        Expense expense1 = repository.findById(10);
        System.out.println(expense1);


        List<Expense> expenses = repository.findAll();
        for(Expense expense2 :expenses){
            System.out.println(expense2);
        }

        repository.save(new Expense(14, "Market", 750));

        Expense expense = new Expense(14,"Eğlence",1400);
        System.out.println(repository.update(14,expense));

        System.out.println(repository.deleteById(199));

    }
}
