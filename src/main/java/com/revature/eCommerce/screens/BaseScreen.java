package com.revature.eCommerce.screens;

import java.util.Scanner;


public abstract class BaseScreen {

    public abstract void startInterface();

    protected void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected void pause(Scanner scan){

        System.out.print("Press enter to continue...");
        scan.nextLine();
    }

}
