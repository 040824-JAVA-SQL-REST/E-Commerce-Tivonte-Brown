package com.revature.eCommerce.Controllers;

import com.revature.eCommerce.dto.request.NewRegisterRequest;
import com.revature.eCommerce.services.UserService;
import com.revature.eCommerce.models.User;
import io.javalin.http.Context;

public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void register(Context ctx){
        try{
            NewRegisterRequest req = ctx.bodyAsClass(NewRegisterRequest.class);
            //ctx.json(req);
            if (!userService.isValidUsername(req.getName())){
                ctx.status(400); //Bad request
                return;
            }

            if (!userService.isUniqueUsername(req.getName())){
                ctx.status(409); //Conflict
                return;
            }

            if (!userService.isValidPassword(req.getPassword())){
                ctx.status(400); //Bad request
                return;
            }

            User newUser = new User(req);
            newUser = userService.save(newUser);

            ctx.status(201); //Created

        } catch (Exception e){
            ctx.status(500); //Internal Error
            e.printStackTrace();
        }
    }

    public void login(Context ctx){
        ctx.result();
    }

}
