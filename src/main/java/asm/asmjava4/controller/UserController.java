/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;
import asm.asmjava4.dao.UserDAO;
import asm.asmjava4.model.Login;
import asm.asmjava4.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserDAO uDao;
    
    @PostMapping("/login")
    public User login(@RequestBody Login logins) {
        return uDao.getById(logins);
    }
    
    @GetMapping("/aaaa")
    public String getA() {
        return uDao.testApi();
    }
    
}
