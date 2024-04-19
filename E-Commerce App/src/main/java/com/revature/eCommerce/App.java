package com.revature.eCommerce;

import java.util.Scanner;
import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;

public class App {
    public static void main( String[] args )  {
        Scanner scan = new Scanner(System.in);

        new RouterService(new UserService(), scan)
             .navigate("/start").startInterface();

        scan.close();
    }
}
