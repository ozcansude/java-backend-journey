package com.ozcansude.practice.expense;

public class DatabaseConfig {
    public static final String URL = "jdbc:postgresql://localhost:5432/expense_db";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = System.getenv("DB_PASSWORD");
}
