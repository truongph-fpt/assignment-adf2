package assignment.view;

import assignment.controller.AuthController;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);
    private AuthController authController = new AuthController();

    public void generateMenu() {
        try {
            while (true) {
                System.out.println("-----------------------------Human Resource------------------------------");
                System.out.println("|      1. Đăng ký                                                       |");
                System.out.println("|      2. Đăng nhập                                                     |");
                System.out.println("|      3. Thoát                                                         |");
                System.out.println("-------------------------------------------------------------------------");
                System.out.print("Vui lòng chọn(1, 2 hoặc 3): ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        authController.getRegister();
                        break;
                    case 2:
                        authController.getLogin();
                        break;
                    case 3:
                        System.out.println("Goodbye!!");
                        break;
                    default:
                        System.out.println("Vui lòng chọn 1,2 hoặc 3");
                        break;
                }

                if (choice == 3) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Bạn phải nhập vào 1 số nguyên");
        }
    }
}
