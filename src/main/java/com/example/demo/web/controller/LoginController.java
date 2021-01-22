package com.example.demo.web.controller;

import com.example.demo.Model.DAO.UserDAO;
import com.example.demo.Model.Entities.User;
import com.example.demo.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean updateProduct(@RequestBody User user) {
        return loginService.authentication(user);
    }
}
