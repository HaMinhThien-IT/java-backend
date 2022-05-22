/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CategoryDAO {
   int save(Category cate);
   int update(Category cate,int id);
   int delete (int id);
   List<Category> getAll(); 
   List<Category> sreachByName(String name); 
   Category getById(int id);
    
}
