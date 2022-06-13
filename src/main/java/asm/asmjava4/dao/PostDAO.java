/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Post;
import java.util.List;

/**
 *
 * @author PC
 */
public interface PostDAO {

    int save(Post post);

    int update(Post course, int id);

    int delete(int idPost);

    List<Post> getAll();
 List<Post> getAllById(int id);
    Post getById(int idPost);

}
