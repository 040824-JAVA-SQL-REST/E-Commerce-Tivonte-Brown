package com.revature.eCommerce;

import java.util.Scanner;
import java.sql.SQLException;
import java.io.IOException;

import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.services.RoleService;
import com.revature.eCommerce.utils.ConnectionFactory;
import com.revature.eCommerce.dao.UserDao;
import com.revature.eCommerce.dao.RoleDao;
import com.revature.eCommerce.models.User;


public class App {
    public static void main( String[] args ) throws SQLException, IOException  {
        Scanner scan = new Scanner(System.in);
        User session = new User();

        System.out.println(ConnectionFactory.getInstance().getConnection());
        scan.nextLine();

/*         new RouterService(new UserService(new UserDao()), scan, session)
             .navigate("/start")

             .startInterface(); */

        new RouterService(new App().getUserService(), scan, session)
             .navigate("/start")
             .startInterface();

        scan.close();
    }

    private UserService getUserService(){
        return new UserService(new RoleService(new RoleDao()), new UserDao());
    }

}



