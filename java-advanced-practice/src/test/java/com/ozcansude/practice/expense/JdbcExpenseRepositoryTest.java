package com.ozcansude.practice.expense;

import static org.junit.jupiter.api.Assertions.*;

import com.ozcansude.practice.expense.exception.InvalidExpenseAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

public class JdbcExpenseRepositoryTest {
    private final String url = "jdbc:postgresql://localhost:5432/expense_db";
    private final String username = "postgres";
    private final String password = System.getenv("DB_PASSWORD");

    JdbcExpenseRepository expenseRepository;

    @BeforeEach
    void setUp(){
        assertNotNull(password, "DB_PASSWORD tanımlı değil");
        expenseRepository = new JdbcExpenseRepository(url,username,password);
    }


    @Test
    void shouldSaveExpense(){
        Expense expense = new Expense(24,"Faturalar",1100);

        expenseRepository.save(expense);

        Expense savedExpense = expenseRepository.findById(24);

        assertNotNull(savedExpense);
        assertEquals("Faturalar",savedExpense.getCategory());
        assertEquals(1100,savedExpense.getAmount());

        expenseRepository.deleteById(24);
    }

    @Test
    void shouldNotSaveExpenseWhenCategoryDoesNotExist(){
        Expense expense = new Expense(24,"Sude",30000);

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> expenseRepository.save(expense)
        );
        assertEquals(
                "Kategori bulunamadı : "+expense.getCategory() , exception.getMessage()
        );
        assertNull(expenseRepository.findById(24));
    }

    @Test
    void shouldNotSaveExpenseWhenAmountIsZero() {
            Expense expense = new Expense(24, "Market",0);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> expenseRepository.save(expense)
        );
        assertEquals("Eklenme sırasında hata oluştu", exception.getMessage());

        assertNull(expenseRepository.findById(24));
    }
    @Test
    void shouldNotSaveExpenseWhenAmountNegative(){
        Expense expense = new Expense(25,"Eğlence",0);
        RuntimeException exception = assertThrows(
            RuntimeException.class,
                () -> expenseRepository.save(expense)
        );

        assertNull(expenseRepository.findById(25));

        assertEquals("Eklenme sırasında hata oluştu", exception.getMessage());
    }


    @Test
    void shouldUpdateExpense(){
        Expense expense1 = new Expense(25,"Sağlık",7000);
        expenseRepository.save(expense1);

        Expense expense2 = new Expense(25,"Market",15000);


        boolean updated=expenseRepository.update(expense1.getId(),expense2);
        Expense updatedValue =  expenseRepository.findById(25);

        assertNotNull(expenseRepository.findById(25));
        assertEquals(25, updatedValue.getId());
        assertEquals("Market",updatedValue.getCategory());
        assertEquals(15000,updatedValue.getAmount());

        assertTrue(updated);

        expenseRepository.deleteById(25);
    }

    @Test
    void shouldNotUpdateExpenseWhenCategoryDoesNotExist(){
        Expense originalExpense = new Expense(26, "Market", 500);
        expenseRepository.save(originalExpense);

        Expense invalidExpense = new Expense(26, "Teknoloji", 65000);

        assertThrows(
                IllegalArgumentException.class,
                () -> expenseRepository.update(26, invalidExpense)
        );

        Expense unchangedExpense = expenseRepository.findById(26);

        assertNotNull(unchangedExpense);
        assertEquals("Market", unchangedExpense.getCategory());
        assertEquals(500, unchangedExpense.getAmount());

        expenseRepository.deleteById(26);
    }

    @Test
    void shouldDeleteExpense(){
        Expense expense = new Expense(25,"Eğlence",1230);
        expenseRepository.save(expense);

        assertNotNull(expenseRepository.findById(25));

        expenseRepository.deleteById(25);

        assertNull(expenseRepository.findById(25));
    }

    @Test
    void shouldReturnFalseWhenExpenseDoesNotExist(){
        assertFalse(expenseRepository.deleteById(99)); // olmayan expense'i silmeye çalıştım
    }

    @Test
    void shouldFindExpense(){
        Expense expense = new Expense(28, "Sağlık", 600);
        expenseRepository.save(expense);

        Expense foundExpense = expenseRepository.findById(28);

        assertNotNull(foundExpense);
        assertEquals(28,foundExpense.getId());
        assertEquals("Sağlık",foundExpense.getCategory());
        assertEquals(600,foundExpense.getAmount());

        expenseRepository.deleteById(28);
    }

    @Test
    void shouldNotFindExpense(){
        Expense expense = expenseRepository.findById(99);

        assertNull(expense);
    }
}
