package com.revature.eCommerce.screens;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.models.User;

public class RegisterScreen extends BaseScreen{
    private final UserService userService;
    private final RouterService routerService;
    private final Scanner scan;

    public RegisterScreen(UserService userService, RouterService routerService, Scanner scan) {
        this.userService = userService;
        this.routerService = routerService;
        this.scan = scan;
    }

    private String username = "";
    private String password = "";
    private String email = "";

    @Override
    public void startInterface() {

        while (true) {
            clearScreen();
            System.out.println("Creating user... ");

            System.out.print("\nUsername: ");
            username = scan.nextLine();

            if (!userService.isValidUsername (username)) {
                clearScreen();
                System.out.println("Invalid username!");
                pause(scan);
                continue;
            }

            System.out.print("\nEmail: ");
            email = scan.nextLine();


            System.out.print("\nPassword: ");
            password = scan.nextLine();
            if (!userService.isValidPassword(password)) {
                    clearScreen();
                    System.out.println("Invalid password!");
                    pause(scan);
                    continue;
                }


            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

            // Save logic
            User newUser = new User(username, hashedPassword, email);
            userService.save(newUser);

            clearScreen();
            System.out.println("Account created successfully!") ;
            pause(scan);
            break;
        }


    }

}
