/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.ForgotPassword;
import asm.asmjava4.model.Login;
import asm.asmjava4.model.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface UserDAO {

    int save(User user);

    int update(User user, int idUser);

    int forgotPassword(String email,String password);

    int delete(int id);

    List<User> getAll();

    User getById(Login login);

    int register(User user);

    String testApi();

    User getMe(int idUser);

    int forgot(ForgotPassword forgot);

    int checkForgot(int code);
}
