package com.revature.eCommerce.services;

import com.revature.eCommerce.dao.ProductsDao;
import com.revature.eCommerce.models.Products;

public class ProductsService {
    private final ProductsDao productsDao;

    public ProductsService(ProductsDao productsDao){
        this.productsDao = productsDao;
    }


        public Products save(Products products){

            ProductsDao.save(products);
            return products;
        }

}


