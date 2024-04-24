package com.revature.eCommerce.screens;

import java.util.Scanner;
import com.revature.eCommerce.services.RouterService;

public class StartScreen extends BaseScreen{
    private final RouterService routerService;
    private final Scanner scan;

    public StartScreen(RouterService routerService, Scanner scan){
        this.routerService = routerService;
        this.scan = scan;
    }

    @Override
    public void startInterface() {
        while (true) {
            clearScreen();
            System.out.println("Interdimensional Shop!");
            System.out.println("\n[1] Login");
            System.out.println("[2] Register");
            System.out.println("[x] Exit");

            System.out.print("\nEnter: ");
            String choice = scan.nextLine();

            switch (choice){
                case "1":
                    break;
                case "2":
                    routerService.navigate("/register").startInterface();
                    break;
                case "x":
                    return;
                default:
                    clearScreen();
                    System.out.println("Invalid input! Please try again");
                    pause(scan);
                    break;
            }
        }
    }
}
