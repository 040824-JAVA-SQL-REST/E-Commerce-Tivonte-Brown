package com.revature.eCommerce.Controllers;

import com.revature.eCommerce.services.ProductsService;
import com.revature.eCommerce.models.Products;

import com.revature.eCommerce.dto.request.NewLoginRequest;
import com.revature.eCommerce.dto.request.NewProductsRequest;
import com.revature.eCommerce.dto.request.NewRegisterRequest;
import com.revature.eCommerce.services.UserService;

import io.javalin.http.Context;
import java.util.*;


import java.util.Optional;

public class ProductsController {
    private final ProductsService productsService;


    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;

        //TODO edit into Product creat controller
        public void create(Context ctx){
            try{
                NewProductsRequest req = ctx.bodyAsClass(NewProductsRequest.class);
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

    }
}
