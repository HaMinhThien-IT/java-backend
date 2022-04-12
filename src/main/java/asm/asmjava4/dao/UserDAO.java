/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Login;
import asm.asmjava4.model.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface UserDAO {

    int save(User user);

    int update(User user, int id);

    int delete(int id);

    List<User> getAll();

    User getById(Login login);
    String testApi ();
}
