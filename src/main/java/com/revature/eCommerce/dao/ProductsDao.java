package com.revature.eCommerce.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.eCommerce.models.*;
import com.revature.eCommerce.utils.ConnectionFactory;

public class ProductsDao implements CrudDao<Products> {

    @Override
    public void save(Products obj) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement ps = conn
        .prepareStatement("INSERT INTO products (productID, productName, productValue) VALUES (?, ?, ?)")) {
            ps.setString(1, obj.getProductID());
            ps.setString(2, obj.getProductName());
            ps.setLong(3, obj.getProductValue());


            ps.executeUpdate();
            } catch (SQLException e) {
            throw new RuntimeException("Error inserting user into database", e);
            } catch (IOException e) {
            throw new RuntimeException("Can't find application.properties file", e);
        }
    }

    @Override
    public void update(Products obj) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Products> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Products findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }


}
