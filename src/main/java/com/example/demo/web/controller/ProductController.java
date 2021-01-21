package com.example.demo.web.controller;

import com.example.demo.Model.DAO.ProductDAO;
import com.example.demo.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value="/Products", method= RequestMethod.GET)
    public List<Product> allProducts() {
        return productDAO.findAll();
    }

    @RequestMapping(value = "/Products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        return productDAO.findById(id);
    }

    @RequestMapping(value = "/Products/save", method = RequestMethod.POST)
    public String addProduct(@RequestBody Product product) {
        productDAO.save(product);
        return "Product has been saved";
    }

    @RequestMapping(value = "/Products/update", method = RequestMethod.POST)
    public String updateProduct(@RequestBody Product product) {
        productDAO.update(product);
        return "Product has been updated";
    }

}
