package com.revature.eCommerce;

import java.util.Scanner;
import java.sql.SQLException;
import java.io.IOException;

import com.revature.eCommerce.services.RouterService;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.utils.ConnectionFactory;
import com.revature.eCommerce.dao.UserDao;


public class App {
    public static void main( String[] args ) throws SQLException, IOException  {
        Scanner scan = new Scanner(System.in);

        System.out.println(ConnectionFactory.getInstance().getConnection());
        scan.nextLine();

        new RouterService(new UserService(new UserDao()), scan)
             .navigate("/start")
             .startInterface();

        scan.close();
    }
}