package com.revature.eCommerce.services;

import com.revature.eCommerce.screens.BaseScreen;
import com.revature.eCommerce.screens.HomeScreen;
import com.revature.eCommerce.screens.StartScreen;
import com.revature.eCommerce.screens.LoginScreen;
import com.revature.eCommerce.screens.RegisterScreen;

public class RouterService {
    private final UserService userService;
    private final Scanner scan;


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
