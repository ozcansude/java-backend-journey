# Expense Management Practice

A Java backend practice project developed step by step to understand repository design, service-layer responsibilities, testing, PostgreSQL, and JDBC.

## Current Structure

The project separates business logic from data access through a generic repository abstraction.

```text
                                                 InMemoryExpenseRepository -----> PostgreSQL
                                                    |
                                                    |
                                                    |
ExpenseService  --- Repository<Expense,Integer> ---> 
                                                    |
                                                    |
                                                    |
                                                 JdbcExpenseRepository ----->  HashMap
```

## Technologies

- Java
- Maven
- JUnit 5
- PostgreSQL
- JDBC

## Features

- Add expenses
- Find an expense by ID
- List all expenses
- Update expenses
- Delete expenses
- Validate expense amount and category
- Store expenses in memory using
- Store expenses persistently in PostgreSQL using JDBC

## Repository Implementations

### InMemoryExpenseRepository

Stores expense data in a Java `HashMap`.

This implementation is useful for practicing repository logic and testing the service layer without requiring a database connection.

### JdbcExpenseRepository

Stores and retrieves expense data from PostgreSQL using JDBC.

The implementation currently uses:

- `Connection`
- `PreparedStatement`
- `ResultSet`
- try-with-resources

The repository converts category names used by the Java model into the corresponding `category_id` stored in PostgreSQL.

## Database

The PostgreSQL structure contains two related tables:

```text
categories
-----------
category_id
category_name

expenses
--------
expense_id
category_id
expense_amount
description
```

`expenses.category_id` references `categories.category_id`.

Database constraints are used to protect data integrity, including primary keys, foreign keys, unique category names, and positive expense amounts.

## What I Practiced

Through this project I practiced:

- Generic repository design
- Separation of concerns
- Service and repository layers
- Polymorphism through repository implementations
- Exception handling
- JUnit testing
- Relational database design
- Primary and foreign keys
- SQL CRUD operations
- JOIN and GROUP BY queries
- JDBC database connections
- Parameterized SQL with `PreparedStatement`
- Mapping `ResultSet` data into Java objects
- Resource management with try-with-resources
