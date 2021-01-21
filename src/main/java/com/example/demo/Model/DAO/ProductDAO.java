package com.example.demo.Model.DAO;

import com.example.demo.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ProductDAO implements DAO {
    private static ArrayList<Product> list = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Product p = new Product(i, "Product" + i, (new Random()).nextInt(100));
            list.add(p);
        }
    }

    public ProductDAO() {
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(int id) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void save(Object object) {
        list.add((Product) object);
    }

    @Override
    public void update(Object object) {
        Product p = (Product) object;
        list.forEach(product -> {
            if(p.getId()==product.getId()){
                product.setNom(p.getNom());
                product.setPrix(p.getPrix());
            }
        });
    }
}
