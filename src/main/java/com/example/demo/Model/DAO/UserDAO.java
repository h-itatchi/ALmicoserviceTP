package com.example.demo.Model.DAO;

import com.example.demo.Model.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO implements DAO{
    private static ArrayList<User> users = new ArrayList();

    static {
        for(int i=0;i<4;i++){
            users.add(new User(i,"user"+i,"pass"+i));
        }
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void save(Object object) {
        users.add((User)object);
    }

    @Override
    public void update(Object object) {
        User u = (User) object;
        users.forEach(user -> {
            if(u.getId()==user.getId()){
                user.setUsername(u.getUsername());
                user.setPassword(u.getPassword());
            }
        });
    }
}
