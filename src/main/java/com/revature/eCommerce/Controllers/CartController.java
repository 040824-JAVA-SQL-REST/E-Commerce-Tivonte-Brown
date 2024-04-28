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


        public void addTo(Context ctx){

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

                //add String productName, int quantity to Cart object

                NewCartRequest req = ctx.bodyAsClass(NewCartRequest.class);

                Cart newItem = new Cart(req);

                ////add String cartID, String buyer,
                newItem.setCartID(principal.getUserID());
                newItem.setBuyer(principal.getName());

                newItem = cartService.save(newItem);

                ctx.status(201); //Created

            } catch (Exception e){
                ctx.status(500); //Internal Error
                e.printStackTrace();
            }

        }

        public void deleteItem(Context ctx){

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


                NewCartDelete req = ctx.bodyAsClass(NewCartDelete.class);
                if (req.getProductName() == null ){
                    ctx.status(401);
                    errors.put("Error:", "Invalid delete request.");
                    ctx.json(errors);
                    return;
                }

                req.setCartID(principal.getUserID());

                Cart newProductDelete = new Cart(req);
                newProductDelete = cartService.deleteItem(newProductDelete);

                ctx.json(newProductDelete);
                ctx.status(200); //ok

            } catch (Exception e){
                ctx.status(500); //Internal Error
                e.printStackTrace();
            }

        }

}
