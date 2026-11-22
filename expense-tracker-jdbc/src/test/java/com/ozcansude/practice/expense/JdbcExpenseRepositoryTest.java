package com.ozcansude.practice.expense;

import static org.junit.jupiter.api.Assertions.*;

import com.ozcansude.practice.expense.repository.JdbcExpenseRepository;
import com.ozcansude.practice.expense.exception.DuplicateExpenseException;
import com.ozcansude.practice.expense.exception.ExpenseNotFoundException;
import com.ozcansude.practice.expense.exception.InvalidCategoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JdbcExpenseRepositoryTest {

    JdbcExpenseRepository expenseRepository;

    @BeforeEach
    void setUp(){
        assertNotNull(DatabaseConfig.PASSWORD, "DB_PASSWORD tanımlı değil");
        expenseRepository = new JdbcExpenseRepository(
                DatabaseConfig.URL,
                DatabaseConfig.USERNAME,
                DatabaseConfig.PASSWORD
        );
    }


    @Test
    void shouldSaveExpense() {
        Expense expense = new Expense(27, "Faturalar", 11100);

        boolean created = false;

        try {
            expenseRepository.save(expense);
            created = true;

            Expense savedExpense = expenseRepository.findById(27);

            assertNotNull(savedExpense);
            assertEquals("Faturalar", savedExpense.getCategory());
            assertEquals(11100, savedExpense.getAmount());

        } finally {
            if (created) {
                expenseRepository.deleteById(27);
            }
        }
    }

    @Test
    void shouldNotSaveDuplicateId(){
        Expense originalExpense = new Expense(46,"Market",135);
        Expense mock = new Expense(46,"Market",1400);

        boolean created = false;
        try{
            expenseRepository.save(originalExpense);
            created = true;

            assertThrows(
                    DuplicateExpenseException.class,
                    () -> expenseRepository.save(mock)
            );
        }finally {
            if (created) {
                expenseRepository.deleteById(46);
            }
        }

    }

    @Test
    void shouldNotSaveExpenseWhenCategoryDoesNotExist(){
        Expense expense = new Expense(27,"Sude",30000);

        Exception exception = assertThrows(
                InvalidCategoryException.class,
                () -> expenseRepository.save(expense)
        );
        assertEquals(
                "Kategori bulunamadı : "+expense.getCategory() , exception.getMessage()
        );
        assertNull(expenseRepository.findById(27));
    }

    @Test
    void shouldNotSaveExpenseWhenAmountIsZero() {
        Expense expense = new Expense(27, "Market",0);

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> expenseRepository.save(expense)
        );
        assertEquals("Eklenme sırasında hata oluştu", exception.getMessage());

        assertNull(expenseRepository.findById(27));
    }
    @Test
    void shouldNotSaveExpenseWhenAmountNegative(){
        Expense expense = new Expense(25,"Eğlence",-100);
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
        Expense expense2 = new Expense(25,"Market",15000);

        boolean created = false;
        try{
            expenseRepository.save(expense1);
            created = true;

            boolean updated=expenseRepository.update(expense1.getId(),expense2);
            Expense updatedValue =  expenseRepository.findById(25);

            assertNotNull(updatedValue);
            assertEquals(25, updatedValue.getId());
            assertEquals("Market",updatedValue.getCategory());
            assertEquals(15000,updatedValue.getAmount());

            assertTrue(updated);
        }finally {
            if (created) {
                expenseRepository.deleteById(25);
            }
        }
    }

    @Test
    void shouldNotUpdateExpenseWhenCategoryDoesNotExist(){
        Expense originalExpense = new Expense(27, "Market", 500);
        Expense invalidExpense = new Expense(27, "Teknoloji", 65000);

        boolean created = false;

        try{
            expenseRepository.save(originalExpense);
            created = true;
            assertThrows(
                    InvalidCategoryException.class,
                    () -> expenseRepository.update(27, invalidExpense)
            );

            Expense unchangedExpense = expenseRepository.findById(27);

            assertNotNull(unchangedExpense);
            assertEquals("Market", unchangedExpense.getCategory());
            assertEquals(500, unchangedExpense.getAmount());
        }finally {
            if(created){
                expenseRepository.deleteById(27);
            }
        }
    }
    @Test
    void shouldNotUpdateExpenseWhenIdNotFound(){
        Expense newExpense = new Expense(27,"Yeme-içme",500);

        assertThrows(
                ExpenseNotFoundException.class,
                () -> expenseRepository.update(27,newExpense)
        );
        assertNull(expenseRepository.findById(27));

    }

    @Test
    void shouldDeleteExpense(){
        Expense expense = new Expense(25,"Eğlence",1230);
        boolean created = false;
        try{
            expenseRepository.save(expense);
            created = true;

            boolean isDeleted=expenseRepository.deleteById(25);
            assertTrue(isDeleted);
            assertNull(expenseRepository.findById(25));
        }finally {
            if(created && expenseRepository.findById(25) != null ){
                expenseRepository.deleteById(25);
            }
        }
    }

    @Test
    void shouldThrowExpenseNotFoundExceptionWhenDeletingNonExistingExpense() {
        assertThrows(
                ExpenseNotFoundException.class,
                () -> expenseRepository.deleteById(99)
        );
        assertNull(expenseRepository.findById(99));
    }

    @Test
    void shouldFindExpense(){
        Expense expense = new Expense(28, "Sağlık", 600);
        boolean created = false;
        try {
            expenseRepository.save(expense);
            created = true;
            Expense foundExpense = expenseRepository.findById(28);

            assertNotNull(foundExpense);
            assertEquals(28,foundExpense.getId());
            assertEquals("Sağlık",foundExpense.getCategory());
            assertEquals(600,foundExpense.getAmount());
        }finally {
            if(created){
                expenseRepository.deleteById(28);
            }
        }
    }

    @Test
    void shouldNotFindExpense(){
        Expense expense = expenseRepository.findById(99);

        assertNull(expense);
    }
}
