package com.revature.eCommerce.utils;

import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.services.ProductsService;
import com.revature.eCommerce.services.RoleService;
import com.revature.eCommerce.utils.ConnectionFactory;
import com.revature.eCommerce.dao.UserDao;
import com.revature.eCommerce.dao.ProductsDao;
import com.revature.eCommerce.dao.RoleDao;
import com.revature.eCommerce.models.User;
import com.revature.eCommerce.Controllers.ProductsController;
import com.revature.eCommerce.Controllers.UserController;

import java.io.IOException;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class JavalinUtil {

    public Javalin getJavalin(){
        UserController userController = new UserController(getUserService());

        return Javalin.create(config -> {
            config.router.apiBuilder(()-> {
                path("/user", () -> {
                    post("/register", userController::register);
                    get("/login", userController::login);
                });
            });
        });
    }

    private UserService getUserService(){
        return new UserService(new RoleService(new RoleDao()), new UserDao());
    }


    ProductsController productsController = new ProductsController(new ProductsService(new ProductsDao()));

    return Javalin.create(config -> {
        config.router.apiBuilder(()-> {
            path("/products", () -> {
                post("/create", ProductsController::create);
            });
        });
    });
}



