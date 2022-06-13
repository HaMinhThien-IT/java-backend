/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;
import asm.asmjava4.dao.UserDAO;
import asm.asmjava4.model.ForgotPassword;
import asm.asmjava4.model.Login;
import asm.asmjava4.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        System.out.println("login" + logins);
        return uDao.getById(logins);
    }
    
    @PostMapping("/user")
    public int saveUser(@RequestBody User user) {
        return uDao.save(user);
    }
    @PostMapping("/register")
    public int Register(@RequestBody User user) {
        return uDao.register(user);
    }
    @PostMapping("/forgot")
    public int ForgotPassword(@RequestBody ForgotPassword forgot) {
    
     return uDao.forgot(forgot);
    }
    @PutMapping("user/{idUser}")
    public String updateUser(@RequestBody User user, @PathVariable int idUser) {
        return uDao.update(user, idUser) + "Update thanh cong";
    }
    @GetMapping("forgot/{email}/{password}")
    public String forgotPassword(@PathVariable String email,@PathVariable String password) {
        System.out.println("password" + password);
        return uDao.forgotPassword(email,password) + "Update thanh cong";
    }
    @GetMapping("/users")
    public List<User> getListUser() {
        return uDao.getAll();
    }
    @GetMapping("/getMe/{idUser}")
    public User getCoursesById(@PathVariable int idUser) {
        return uDao.getMe(idUser);
    }
    @GetMapping("/fotGot/{code}")
    public int checkForgot(@PathVariable int code) {
        return uDao.checkForgot(code);
    }
    @DeleteMapping("user/{idUser}")
    public String deleteCategory( @PathVariable int idUser) {
        return uDao.delete(idUser) + "delete thanh cong";
    }
}
