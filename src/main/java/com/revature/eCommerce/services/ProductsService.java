package com.revature.eCommerce.services;

import com.revature.eCommerce.dao.ProductsDao;
import com.revature.eCommerce.models.Products;

public class ProductsService {
    private final ProductsDao productsDao;

    public ProductsService(ProductsDao productsDao){
        this.productsDao = productsDao;
    }


        public Products save(Products products){

            productsDao.save(products);
            return products;

        }

        public Products delete(Products products){

            productsDao.delete(products.getProductID());
            return products;

        }

        public Products update(Products products){

            productsDao.update(products);
            return products;

        }

        public String getProductIDByName(String name){

            return productsDao.findAll().stream()
            .filter(p -> p.getProductName().equals(name))
            .findFirst().get().getProductID();
        }

        public Long getProductValueByName(String name){

            return productsDao.findAll().stream()
            .filter(p -> p.getProductName().equals(name))
            .findFirst().get().getProductValue();
        }


}


