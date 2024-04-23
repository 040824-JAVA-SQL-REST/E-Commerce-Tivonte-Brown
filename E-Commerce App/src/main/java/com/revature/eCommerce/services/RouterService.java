package com.revature.eCommerce.services;

import java.util.Scanner;

import com.revature.eCommerce.screens.BaseScreen;
import com.revature.eCommerce.screens.HomeScreen;
import com.revature.eCommerce.screens.StartScreen;
import com.revature.eCommerce.screens.LoginScreen;
import com.revature.eCommerce.screens.RegisterScreen;
import com.revature.eCommerce.models.User;


public class RouterService {
    private final UserService userService;
    private final Scanner scan;
    private User session;

    public RouterService(UserService userService, Scanner scan){
        this.userService = userService;
        this.scan = scan;
    }

    public RouterService(UserService userService, Scanner scan, User session){
        this.userService = userService;
        this.scan = scan;
        this.session = session;

    }

    public BaseScreen navigate(String path) {

        switch (path) {
            case "/start":
                return new StartScreen(this, scan);
            case "/register":
                return new RegisterScreen(userService, this, scan);
            case "/login":
                return new LoginScreen();
            default:
                throw new IllegalArgumentException("Invalid path" + path);
        }
    }

}
