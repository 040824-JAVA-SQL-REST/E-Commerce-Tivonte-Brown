package com.revature.eCommerce.screens;

import java.util.Scanner;
import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;

public class RegisterScreen extends BaseScreen{
    private final UserService userService;
    private final RouterService routerService;
    private final Scanner scan;

    public RegisterScreen(UserService userService, RouterService routerService, Scanner scan) {
        this.userService = userService;
        this.routerService = routerService;
        this.scan = scan;

    @Override
    public void startInterface() {
        while (true) {
            clearScreen();
            System.out.println("Creating user... ");

            System.out.print("\nUsername: ");
            String username = scan.nextLine();

            if (!userService.isValidUsername (username)) {
                clearScreen();
                System.out.println("Invalid username!");
                pause(scan);
                continue;
            }

            System.out.print("\nEmail: ");
            String email = scan.nextLine();

            while (true) {
                System.out.println("Creating user ...");
                clearScreen();
                System.out.print("\nPassword: ");
                String password = scan.nextLine();
                if (!userService.isValidPassword(password)) {
                    clearScreen();
                    System.out.println("Invalid password!");
                    pause(scan);
                    continue;
                }
                break;

            }
            // Save logic
            break;
        }


    }


}
