package assignment.model;

import assignment.entity.Employee;
import assignment.helper.ConnectionHelper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class EmployeeModel {
    private static Scanner scanner = new Scanner(System.in);

    public boolean register(Employee emp) {
        try {
            String queryString = "INSERT INTO employees " +
                    "(account, `name`, address, email, password, created_at, updated_at, status) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(queryString);
            preparedStatement.setString(1, emp.getAccount());
            preparedStatement.setString(2, emp.getName());
            preparedStatement.setString(3, emp.getAddress());
            preparedStatement.setString(4, emp.getEmail());
            preparedStatement.setString(5, emp.getPassword());
            preparedStatement.setDate(6, emp.getCreatedAt());
            preparedStatement.setDate(7, emp.getUpdatedAt());
            preparedStatement.setInt(8, emp.getStatus());
            preparedStatement.execute();
            System.err.println(" Đăng ký thành công");
            return true;
        } catch (SQLException e) {
            System.err.println("Đăng ký thất bại" + e.getMessage());
            return false;
        }

    }

    public boolean checkExistAccount(String account) {
        try {
            String queryString = "select account from employees where account = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(queryString);
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("\nTài khoản đã tồn tại");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Đã xảy ra lỗi" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Đã xảy ra lỗi" + ex.getMessage());
        }
        return false;
    }

    public Employee login(String account, String password) {
        try {
            String queryString = "select * from employees where account = ? AND password = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(queryString);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                Date createdAt = resultSet.getDate("created_at");
                Date updatedAt = resultSet.getDate("updated_at");
                int status = resultSet.getInt("status");
                Employee employee = new Employee(account, name, address, email, password, createdAt, updatedAt, status);
                return employee;
            }
        } catch (SQLException ex) {
            System.out.println("Đã xảy ra lỗi" + ex.getMessage());
        }
        return null;
    }
}
