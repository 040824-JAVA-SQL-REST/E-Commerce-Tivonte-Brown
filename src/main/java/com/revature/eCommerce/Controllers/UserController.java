package com.revature.eCommerce.Controllers;

import io.javalin.http.Context;

public class UserController {
    public void register(Context ctx){
        ctx.result("User");
    }

}
