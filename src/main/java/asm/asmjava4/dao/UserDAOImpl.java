/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import Helper.HashPassword;
import Helper.SendMails;
import Helper.SendMails1;
import asm.asmjava4.model.ForgotPassword;
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
        return jdbcTemplate.update("INSERT INTO user(name, imgUser, password, email, role) VALUES (?,?,?,?,?)", new Object[]{user.getName(), user.getImgUser(), user.getPassword(), user.getEmail(), "user"});
    }

    @Override
    public int update(User user, int idUser) {
        return jdbcTemplate.update("UPDATE user SET name= ? ,imgUser=? ,password=? ,email=?,role= ? WHERE = ?", new Object[]{user.getName(), user.getImgUser(), user.getPassword(), user.getEmail(), "user", idUser});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from user where idUser=?", id);
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public User getById(Login logins) {
        try {
            System.out.println("ok" + HashPassword.encrypt(logins.getPassword()));
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

    public User check(String email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user where email = ?", new BeanPropertyRowMapper<User>(User.class), email);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int register(User user) {
        User checkRe = check(user.getEmail());
        System.out.println("checkRe" + checkRe);
        if (checkRe == null) {
            try {
                SendMails.sendEmail(user.getEmail(), user.getEmail());
                return jdbcTemplate.update("INSERT INTO user(name, imgUser, password, email, role) VALUES (?,?,?,?,?)", new Object[]{"null", "null", HashPassword.encrypt(user.getPassword()), user.getEmail(), "user"});
            } catch (Exception e) {
                System.out.println("e" + e);
                return 402;
            }
        } else {
            return 401;
        }
    }

    @Override
    public int forgot(ForgotPassword forgot) {
        User checkRe = check(forgot.getEmail());
          int min = 50;
      int max = 99978;
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
      forgot.setCode(random_int);
        if (checkRe != null) {
            try {
                 SendMails1.sendEmail(forgot.getEmail(), "Mã xác minh ", "Mã  : " + forgot.getCode());
            } catch (Exception e) {
            }
            return jdbcTemplate.update("INSERT INTO forgotpassword(email,code) VALUES (?,?)", new Object[]{forgot.getEmail(), forgot.getCode()});
        }else{
            return 401;
        }
    }

    @Override
    public User getMe(int idUser) {
        return jdbcTemplate.queryForObject("SELECT * FROM course where idCourse=?", new BeanPropertyRowMapper<User>(User.class), idUser);
    }
     public ForgotPassword checkForgotx(int code) {
      try {
            return jdbcTemplate.queryForObject("SELECT code FROM forgotpassword where code = ?", new BeanPropertyRowMapper<ForgotPassword>(ForgotPassword.class), code);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public int checkForgot(int code) {
        ForgotPassword a = checkForgotx(code);
        if(a == null){
            return 405;
        }else{
            return 203;
        }
    }

    @Override
    public int forgotPassword(String email,String password) {
       
        return jdbcTemplate.update("UPDATE user set password = ? where email = ?",HashPassword.encrypt(password), email);
    }

}
