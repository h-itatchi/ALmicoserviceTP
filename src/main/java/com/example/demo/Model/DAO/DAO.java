package com.example.demo.Model.DAO;

import java.util.List;

public interface DAO {
    public List findAll();
    public Object findById(int id);
    public void save(Object object);
    public void update(Object object);
}
