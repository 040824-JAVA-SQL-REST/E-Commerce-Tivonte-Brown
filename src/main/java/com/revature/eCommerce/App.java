package com.revature.eCommerce;

import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.services.RoleService;
import com.revature.eCommerce.utils.ConnectionFactory;
import com.revature.eCommerce.dao.UserDao;
import com.revature.eCommerce.dao.RoleDao;
import com.revature.eCommerce.models.User;
import com.revature.eCommerce.Controllers.UserController;

import java.util.Scanner;
import java.sql.SQLException;
import java.io.IOException;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {
    public static void main( String[] args ) throws SQLException, IOException  {
            App app = new App();
            UserController userController = new UserController();

            Javalin.create(config -> {
                config.router.apiBuilder(()-> {
                    path("/user", () -> {
                        post("/register", userController::register);
                    });
                });
            }).start(7070);

    }

        private UserService getUserService(){
            return new UserService(new RoleService(new RoleDao()), new UserDao());
        }

}



