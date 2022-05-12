/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import Helper.HashPassword;
import Helper.SendMails;
import asm.asmjava4.model.Login;
import asm.asmjava4.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
       return jdbcTemplate.update("INSERT INTO user(name, imgUser, password, email, role) VALUES (?,?,?,?,?)",new Object[]{user.getName(),user.getImgUser(),user.getPassword(),user.getEmail(),"user"});
    }

    @Override
    public int update(User user, int idUser) {
          return jdbcTemplate.update("UPDATE user SET name= ? ,imgUser=? ,password=? ,email=?,role= ? WHERE = ?",new Object[]{user.getName(),user.getImgUser(),user.getPassword(),user.getEmail(),"user",idUser});
    }

    @Override
    public int delete(int id) {
         return jdbcTemplate.update("DELETE from user where idUser=?",id);
    }

    @Override
    public List<User> getAll() {
       return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User getById(Login logins) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user where email = ? and password = ?", new BeanPropertyRowMapper<User>(User.class), logins.getEmail(), HashPassword.encrypt(logins.getPassword()));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String testApi() {
        String a = "Aaaaaa";
        return a;
    }

    @Override
    public int register(User user) {
        try {
            SendMails.sendEmail(user.getEmail(), user.getEmail());
             return jdbcTemplate.update("INSERT INTO user(name, imgUser, password, email, role) VALUES (?,?,?,?,?)",new Object[]{"null","null",HashPassword.encrypt(user.getPassword()),user.getEmail(),"user"});
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public User getMe(int idUser) {
         return jdbcTemplate.queryForObject("SELECT * FROM course where idCourse=?", new BeanPropertyRowMapper<User>(User.class),idUser);
    }

    

   

}
