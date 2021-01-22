package com.example.demo.Services;

import com.example.demo.Model.DAO.UserDAO;
import com.example.demo.Model.Entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component()
public class LoginService {

    private UserDAO userDAO;

    public LoginService() {
        userDAO = new UserDAO();
    }

    public boolean authentication(User user) {
        ArrayList<User> users = (ArrayList<User>) userDAO.findAll();
        for (User u : users) {
            if (user.getUsername().equals(u.getUsername()) &&
                    user.getPassword().equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
