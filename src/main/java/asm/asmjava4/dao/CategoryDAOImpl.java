/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Category;
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
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int save(Category cate) {
      return jdbcTemplate.update("INSERT INTO category(name, descriptionCate, image) VALUES(?, ?, ?)",new Object[]{cate.getName(),cate.getDescriptionCate(),cate.getImage()});
    }

    @Override
    public int update(Category cate, int id) {
        return jdbcTemplate.update("UPDATE category set name =?, descriptionCate=?, image =? where idCategory=?",new Object[]{cate.getName(),cate.getDescriptionCate(),cate.getImage(),id});
    }

    @Override
    public int delete(int id) {
       return jdbcTemplate.update("DELETE from category where idCategory=?",id);
    }

    @Override
    public List<Category> getAll() {
     return jdbcTemplate.query("select * from category ORDER BY idCategory DESC", new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public Category getById(int id) {
      return jdbcTemplate.queryForObject("SELECT * FROM category where idCategory=?", new BeanPropertyRowMapper<Category>(Category.class),id);
    }
    
}
