package assignment.controller;

import assignment.entity.Employee;
import assignment.model.EmployeeModel;

import java.util.Scanner;

public class AuthController {
    private Scanner scanner = new Scanner(System.in);
    public void getRegister() {
        EmployeeModel employeeModel = new EmployeeModel();
        while (true) {
            Employee employee = new Employee();
            System.out.println("Nhập thông tin nhân viên");
            System.out.print("Nhập account: ");
            employee.setAccount(scanner.nextLine());
            System.out.print("Nhập tên: ");
            employee.setName(scanner.nextLine());
            System.out.print("Nhập address: ");
            employee.setAddress(scanner.nextLine());
            System.out.print("Nhập email: ");
            employee.setEmail(scanner.nextLine());
            System.out.print("Nhập password: ");
            employee.setPassword(scanner.nextLine());
            while (true) {
                try {
                    System.out.print("Nhập createdAt(yyyy-dd-mm): ");
                    employee.setCreatedAt(java.sql.Date.valueOf(scanner.nextLine()));
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Nhập sai định dạng ngày, vui lòng nhập lại!");
                }
            }
            while (true) {
                try {
                    System.out.print("Nhập updatedAt(yyyy-dd-mm): ");
                    employee.setUpdatedAt(java.sql.Date.valueOf(scanner.nextLine()));
                    break;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Nhập sai định dạng ngày, vui lòng nhập lại!");
                }
            }
            System.out.print("Nhập status: ");
            employee.setStatus(scanner.nextInt());
            scanner.nextLine();
            if (!employeeModel.checkExistAccount(employee.getAccount())) {
                System.out.print("Bạn có muốn đăng ký với thông tin vừa nhập không(y/n):");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    employeeModel.register(employee);
                    break;
                }
            }

        }
    }

    public void getLogin() {
        EmployeeModel employeeModel = new EmployeeModel();
        System.out.println("Vui lòng nhập thông tin đăng nhập");
        System.out.print("Nhập account: ");
        String account = scanner.nextLine();
        System.out.print("Nhập password: ");
        String password = scanner.nextLine();
        printEmployee(employeeModel.login(account, password));

    }

    private void printEmployee(Employee employee){
        if (employee == null) {
            System.out.println("\n-------------------------------------------------------------------------------------------------");
            System.out.println("|                     Account hoặc password sai, vui lòng nhập lại                                 |");
            System.out.println("-------------------------------------------------------------------------------------------------\n");
        } else {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("| %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s |",
                    "", "Account", "",
                    "", "Name", "",
                    "", "Address", "",
                    "", "Email", "",
                    "", "Password", "",
                    "", "Created At", "",
                    "", "Updated At", "",
                    "", "Status", ""
                    )
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(String.format("| %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s | %5s %10s %5s |\n",
                    "", employee.getAccount(), "",
                    "", employee.getName(), "",
                    "", employee.getAddress(), "",
                    "", employee.getEmail(), "",
                    "", employee.getPassword(), "",
                    "", employee.getCreatedAt(), "",
                    "", employee.getUpdatedAt(), "",
                    "", employee.getStatus(), ""
                    )
            );
        }
    }
}
