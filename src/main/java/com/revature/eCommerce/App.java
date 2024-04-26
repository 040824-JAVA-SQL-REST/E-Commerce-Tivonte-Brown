package com.revature.eCommerce;

import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.services.RoleService;
import com.revature.eCommerce.utils.ConnectionFactory;
import com.revature.eCommerce.dao.UserDao;
import com.revature.eCommerce.dao.RoleDao;
import com.revature.eCommerce.models.User;
import com.revature.eCommerce.Controllers.UserController;
import com.revature.eCommerce.utils.JavalinUtil;

import java.util.Scanner;
import java.sql.SQLException;
import java.io.IOException;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class App {
    public static void main( String[] args ) throws SQLException, IOException  {

         new JavalinUtil().getJavalin().start(7070);
    }

}



