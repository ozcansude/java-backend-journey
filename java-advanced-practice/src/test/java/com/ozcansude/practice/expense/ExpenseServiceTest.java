package com.ozcansude.practice.expense;

import com.ozcansude.practice.expense.exception.ExpenseNotFoundException;
import com.ozcansude.practice.expense.exception.InvalidCategoryException;
import com.ozcansude.practice.expense.exception.InvalidExpenseAmountException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseServiceTest {
    private InMemoryExpenseRepository expenseRepository;
    private ExpenseService expenseService;

    @BeforeEach
    void setUp(){
        expenseRepository = new InMemoryExpenseRepository();
        expenseService = new ExpenseService(expenseRepository);
    }

    @Test
    void shouldAddValidExpense(){
        Expense expense = new Expense(1,"Market", 500);

        expenseService.addExpense(expense);

        assertEquals("Market",expenseRepository.findById(1).getCategory());
        assertEquals(500,expenseRepository.findById(1).getAmount());
    }

    @Test
    void shouldThrowWhenExpenseAmountIsNegative(){
        Expense expense = new Expense(2,"Market",-100);

        assertThrows(
                InvalidExpenseAmountException.class,
                () -> expenseService.addExpense(expense)
        );
        assertTrue(expenseRepository.findAll().isEmpty());
    }

    @Test
    void shouldThrowWhenExpenseAmountIsZero(){
        Expense expense = new Expense(2,"Eğlence", 0);

        assertThrows(
                InvalidExpenseAmountException.class,
                () -> expenseService.addExpense(expense)
        );
        assertTrue(expenseRepository.findAll().isEmpty());

    }

    @Test
    void shouldThrowWhenCategoryIsBlank(){
        Expense expense = new Expense(3, "   ", 500);

        assertThrows(
                InvalidCategoryException.class,
                () -> expenseService.addExpense(expense)
        );
        assertTrue(expenseRepository.findAll().isEmpty());
    }

    @Test
    void shouldThrowWhenCategoryIsNull(){
        Expense expense = new Expense(3, null, 500);

        assertThrows(
                InvalidCategoryException.class,
                () -> expenseService.addExpense(expense)
        );
        assertTrue(expenseRepository.findAll().isEmpty());
    }

    @Test
    void shouldThrowWhenExpenseNotFound(){
        assertThrows(
                ExpenseNotFoundException.class,
                () -> expenseService.findExpenseById(99)
        );
        assertTrue(expenseRepository.findAll().isEmpty());
    }

    @Test
    void shouldFindExistingExpenseById(){
        Expense expense = new Expense(1,"Market",500);
        expenseService.addExpense(expense);

        Expense expense1= expenseService.findExpenseById(1);
        assertEquals(500,expense1.getAmount());
        assertEquals(1, expense1.getId());
        assertEquals("Market", expense1.getCategory());
    }

    @Test
    void shouldRemoveExistingExpense(){
        Expense expense = new Expense(2,"Eğlence",700);
        expenseService.addExpense(expense);

        expenseService.removeExpense(2);

        assertNull(expenseRepository.findById(2));
        assertTrue(expenseRepository.findAll().isEmpty());
    }

    @Test
    void shouldThrowWhenRemovingNonExistingExpense(){
        assertThrows(
                ExpenseNotFoundException.class,
                () -> expenseService.removeExpense(99)
        );
    }

    @Test
    void shouldUpdateExistingExpense(){
        Expense expense = new Expense(3, "Teknoloji",7000);
        expenseService.addExpense(expense);

        expenseService.updateExpense(3,"Market",1500);

        Expense expense1 = expenseService.findExpenseById(3);
        assertEquals("Market",expense1.getCategory());
        assertEquals(1500,expense1.getAmount());
    }

    @Test
    void shouldThrowWhenUpdatingWithInvalidAmount(){
        Expense expense= new Expense(1,"Market",500);
        expenseService.addExpense(expense);

        assertThrows(InvalidExpenseAmountException.class,
        () -> expenseService.updateExpense(1,"Eğlence",-100));

        Expense expense1 = expenseService.findExpenseById(1);
        assertEquals("Market",expense1.getCategory());
        assertEquals(500,expense1.getAmount());
    }
    @Test
    void shouldThrowWhenUpdatingWithInvalidCategory(){
        Expense expense= new Expense(1,"Market",500);
        expenseService.addExpense(expense);

        assertThrows(
                InvalidCategoryException.class,
                () -> expenseService.updateExpense(1," ",100));

        Expense expense1 = expenseService.findExpenseById(1);
        assertEquals("Market",expense1.getCategory());
        assertEquals(500,expense1.getAmount());
    }



}
