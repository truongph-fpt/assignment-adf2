package assignment.entity;

import java.util.Date;

public class Employee {
    private String account;
    private String name;
    private String address;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;
    private int status;

    public Employee() {
    }

    public Employee(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Employee(String account, String name, String address, String email, String password, Date createdAt, Date updatedAt, int status) {
        this.account = account;
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Date getCreatedAt() {
        return (java.sql.Date) createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public java.sql.Date getUpdatedAt() {
        return (java.sql.Date) updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
