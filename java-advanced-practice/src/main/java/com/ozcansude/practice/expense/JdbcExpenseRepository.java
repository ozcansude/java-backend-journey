package com.ozcansude.practice.expense;

import com.ozcansude.practice.expense.exception.ExpenseNotFoundException;
import com.ozcansude.practice.expense.repository.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcExpenseRepository implements Repository<Expense, Integer> {

    private final String url;
    private final String username;
    private final String password;

    public JdbcExpenseRepository(String url, String username, String password){
        this.password = password;
        this.url = url;
        this.username = username;
    }

    @Override
    public void save(Expense entity) {
        String sql = """
                SELECT category_id
                FROM categories
                WHERE category_name = ?;
                """;
        String sql2 = """
                INSERT INTO expenses
                 (expense_id, category_id ,expense_amount)
                 VALUES(?,?,?);
                """;
        try(
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setString(1,entity.getCategory());
            try(ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    int category_id = rs.getInt("category_id");
                    try(PreparedStatement pr = connection.prepareStatement(sql2)){
                        pr.setInt(1,entity.getId());
                        pr.setInt(2,category_id);
                        pr.setInt(3,entity.getAmount());

                        pr.executeUpdate();
                }
                }else{
                    throw new IllegalArgumentException("Kategori bulunamadı");
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Hata oluştu." ,e);
        }
    }

    @Override
    public Expense findById(Integer id) {
        String sql = """
                SELECT
                    e.expense_id,
                    c.category_name,
                    e.expense_amount
                FROM expenses e
                    JOIN categories c
                    ON e.category_id = c.category_id
                WHERE e.expense_id = ?
                """;
        try(
                Connection connection = DriverManager.getConnection(url,username, password);
                PreparedStatement statement = connection.prepareStatement(sql)
                ){
            statement.setInt(1, id);

            try(ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    Expense expense = new Expense(
                            rs.getInt("expense_id"),
                            rs.getString("category_name"),
                            rs.getInt("expense_amount")
                    );
                    return expense;
                }
                return null;
            }

        }catch (SQLException e){
            throw new RuntimeException("Hata oluştu ",e);
        }
    }

    @Override
    public List<Expense> findAll() {
        List<Expense> expenseList = new ArrayList<>();
        String sql = """
               SELECT e.expense_id,
                    c.category_name,
                    e.expense_amount
               FROM expenses e
                    JOIN categories c
                     ON c.category_id = e.category_id
               ORDER BY e.expense_id;
                """;

        try(
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement statement = connection.prepareStatement(sql)){
            try(ResultSet rs = statement.executeQuery()){
                while(rs.next()){
                    Expense expense = new Expense(
                            rs.getInt("expense_id"),
                            rs.getString("category_name"),
                            rs.getInt("expense_amount"));

                    expenseList.add(expense);
                }
                return expenseList;
            }
        }catch (SQLException e){
            throw new RuntimeException("Hata oluştu",e);
        }

    }

    @Override
    public boolean deleteById(Integer id) {
        String sql = """
                DELETE FROM expenses
                WHERE expense_id = ?;
                """;

        try(
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1,id);

            int affecedRows = statement.executeUpdate();
            return affecedRows > 0;

        }catch(SQLException e){
            throw new RuntimeException("Hata oluştu",e);
        }
    }

    @Override
    public boolean update(Integer id, Expense entity) {
        String sql1 = """
                SELECT category_id
                FROM categories
                WHERE category_name = ?;
                """;
        String sql2 = """
                UPDATE expenses
                SET category_id = ? , expense_amount = ?
                WHERE expense_id = ?
                """;
        try(
                Connection connection = DriverManager.getConnection(url,username,password);
                PreparedStatement statement = connection.prepareStatement(sql1);
        ){
            statement.setString(1,entity.getCategory());
            try(ResultSet rs = statement.executeQuery()){
                if(rs.next()){
                    int category_id = rs.getInt("category_id");
                    try(PreparedStatement statement1 = connection.prepareStatement(sql2)){
                        statement1.setInt(1,category_id);
                        statement1.setInt(2,entity.getAmount());
                        statement1.setInt(3, id);

                        int affectedRows = statement1.executeUpdate();
                        return affectedRows > 0;
                    }
                }else{
                    throw new IllegalArgumentException("Kategori bulunamadı" + entity.getCategory());
                }
            }
        }catch(SQLException e){
            throw new RuntimeException("Hata oluştu",e);
        }

    }


}
