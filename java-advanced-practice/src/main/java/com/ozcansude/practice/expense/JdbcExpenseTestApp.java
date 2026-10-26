package com.ozcansude.practice.expense;

import java.sql.SQLException;
import java.util.List;

public class JdbcExpenseTestApp {
    public static void main(String[] args){
        JdbcExpenseRepository repository = new JdbcExpenseRepository(
                "jdbc:postgresql://localhost:5432/expense_db",
                "postgres",
                System.getenv("DB_PASSWORD")
        );

        ExpenseService expenseService = new ExpenseService(repository);

//        Expense expense1 = repository.findById(10);
//        System.out.println(expense1);
//
//
//        List<Expense> expenses = repository.findAll();
//        for(Expense expense2 :expenses){
//            System.out.println(expense2);
//        }

     //   repository.save(new Expense(14, "Market", 750));
//
//        Expense expense = new Expense(14,"Eğlence",1400);
//        System.out.println(repository.update(14,expense));
//
//        System.out.println(repository.deleteById(199));

        System.out.println(repository.findById(99999)); // null
        System.out.println(repository.deleteById(99999)); //false

        Expense expense = new Expense(12,"Market",500);
        System.out.println(repository.update(99999,expense)); // false

        try{
            Expense expense1 = new Expense(17,"Eğlence",700);
            repository.save(expense1);
            System.out.println(repository.findAll());
        }catch (RuntimeException e){
            System.out.println("Test  başarılı, aynı ID tekrar eklenemedi.");
        }

        try{
            Expense expense2 = new Expense(18,"Teknoloji",700);
            repository.save(expense2);
            System.out.println(repository.findAll());
        }catch (IllegalArgumentException e){
            System.out.println("Test başarılı: "+e);
        }

        try{
            Expense e3 = new Expense(21,"Market",1000);
            repository.save(e3);
            System.out.println("Ekleme başarılı 🧠");
        }catch (RuntimeException e){
            System.out.println("Ekleme başarısız. " + e);
        }

        try{
            Expense e4 = new Expense(3,"Yeme-içme",1000);
           boolean updated = repository.update(3,e4);
           if(updated){
               System.out.println("Güncelleme başarılı");
           }else{
               System.out.println("Expense bulunamadı, güncelleme yapılmadı.");
           }
        }catch (RuntimeException e){
            System.out.println("Güncelleme başarısız. "+ e);
        }


    }
}
