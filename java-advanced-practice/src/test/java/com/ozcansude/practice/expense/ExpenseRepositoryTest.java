package com.ozcansude.practice.expense;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseRepositoryTest {
    ExpenseRepository expenseRepository;

    @BeforeEach
    void setUp(){
        expenseRepository = new ExpenseRepository();
    }


    @Test
    void shouldSaveExpense(){
        Expense expense = new Expense(1,"Market",500);
        expenseRepository.save(expense);

        assertEquals("Market",expenseRepository.findById(1).getCategory());
    }

    @Test
    void shouldReturnNullWhenExpenseNotFound(){
        Expense expense = expenseRepository.findById(99); // bulunamayan id'li

        assertNull(expense);
    }

    @Test
    void shouldDeleteExpense(){
        Expense expense = new Expense(1,"Market",500);
        expenseRepository.save(expense);

        boolean deleted = expenseRepository.deleteById(1); // silerse true

        assertTrue(deleted); // pass

        assertNull(expenseRepository.findById(1));
    }

    @Test
    void shouldReturnFalseWhenDeletingNonExistingExpense() {
        boolean deleted = expenseRepository.deleteById(99);

        assertFalse(deleted);
    }

    @Test
    void shouldUpdateExistingExpense() {
        Expense expense1 = new Expense(1,"Market",500);
        Expense expense2 = new Expense(1, "Teknoloji", 3000);

        expenseRepository.save(expense1);

        boolean isUpdated = expenseRepository.update(1,expense2);
        assertTrue(isUpdated);

        Expense expense = expenseRepository.findById(1);
        assertEquals(expense2.getCategory(),expense.getCategory());
        assertEquals(expense2.getAmount(),expense.getAmount());
    }

    @Test
    void shouldReturnFalseWhenUpdatingNonExistingExpense(){
        Expense expense = new Expense(5,"Eğlence",700);

       boolean isUpdated = expenseRepository.update(99,expense);

       assertFalse(isUpdated);
       assertTrue(expenseRepository.findAll().isEmpty()); // NOT : BAŞARISIZ GÜNCELLEME SONUCUNDA REPOSIORY'YE YENİ BİR HARCAMA EKLENMEMİŞ OLMALI!!!!
        //başarısız bir güncellemenin verileri değiştirmediğini doğrulamak.
    }

    @Test
    void shouldReturnAllExpenses(){
        Expense expense1 = new Expense(1,"Eğlence", 700);
        Expense expense2 = new Expense(2,"Market",1000);

        expenseRepository.save(expense1);
        expenseRepository.save(expense2);

        assertEquals(2,expenseRepository.findAll().size());
        assertTrue(expenseRepository.findAll().contains(expense1) && expenseRepository.findAll().contains(expense2));
    }


}
