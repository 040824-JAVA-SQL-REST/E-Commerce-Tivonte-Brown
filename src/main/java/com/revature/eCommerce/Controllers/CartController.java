package com.revature.eCommerce.Controllers;

import java.util.HashMap;
import java.util.Map;

import com.revature.eCommerce.dto.request.NewCartDelete;
import com.revature.eCommerce.dto.request.NewCartRequest;
import com.revature.eCommerce.dto.responses.Principal;
import com.revature.eCommerce.models.Cart;
import com.revature.eCommerce.services.CartService;
import com.revature.eCommerce.services.TokenService;

import io.javalin.http.Context;

public class CartController {
private final CartService cartService;
    private final TokenService tokenService;


    public CartController(CartService cartService, TokenService tokenService) {
        this.cartService = cartService;
        this.tokenService = tokenService;
    }


        public void create(Context ctx){

            try{
                Map<String, String> errors = new HashMap<>();

                String token = ctx.header("auth-token");
                if (token == null || token.isEmpty()) {
                    ctx.status(401);
                    errors.put("Error:", "Invalid token.");
                    ctx.json(errors);
                    return;
                }

                Principal principal = tokenService.parseToken(token);
                if (principal == null) {
                    ctx.status(401);
                    errors.put("Error:", "Invalid token.");
                    ctx.json(errors);
                    return;
                }

                if(!principal.getRole().getRoleName().equalsIgnoreCase("admin")){
                    ctx.status(403);
                    errors.put("Error:", "Invalid authorization");
                    ctx.json(errors);
                    return;
                }

                NewCartRequest req = ctx.bodyAsClass(NewCartRequest.class);

                Cart newProduct = new Cart(req);
                newProduct = cartService.save(newProduct);

                ctx.status(201); //Created

            } catch (Exception e){
                ctx.status(500); //Internal Error
                e.printStackTrace();
            }

        }

        public void delete(Context ctx){

            try{
                Map<String, String> errors = new HashMap<>();

                String token = ctx.header("auth-token");
                if (token == null || token.isEmpty()) {
                    ctx.status(401);
                    errors.put("Error:", "Invalid token.");
                    ctx.json(errors);
                    return;
                }

                Principal principal = tokenService.parseToken(token);
                if (principal == null) {
                    ctx.status(401);
                    errors.put("Error:", "Invalid token.");
                    ctx.json(errors);
                    return;
                }

                if(!principal.getRole().getRoleName().equalsIgnoreCase("admin")){
                    ctx.status(403);
                    errors.put("Error:", "Invalid authorization");
                    ctx.json(errors);
                    return;
                }

                NewCartDelete req = ctx.bodyAsClass(NewCartDelete.class);

                Cart newProduct = new Cart(req);
                newProduct = cartService.delete(newProduct);

                ctx.status(201); //Created

            } catch (Exception e){
                ctx.status(500); //Internal Error
                e.printStackTrace();
            }

        }

}
