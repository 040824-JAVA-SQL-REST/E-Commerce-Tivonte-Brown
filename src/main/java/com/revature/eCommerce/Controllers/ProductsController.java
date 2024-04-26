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
    }


        public void create(Context ctx){

            try{
                NewProductsRequest req = ctx.bodyAsClass(NewProductsRequest.class);

                Products newProduct = new Products(req);
                newProduct = productsService.save(newProduct);

                ctx.status(201); //Created

            } catch (Exception e){
                ctx.status(500); //Internal Error
                e.printStackTrace();
            }


    }
}
