/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CategoryDAO;
import asm.asmjava4.model.Category;
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
@CrossOrigin(origins="*")
public class CategoryController {

    @Autowired
    private CategoryDAO cDao;

    @GetMapping("/categories")
    public List<Category> getListCategory() {
        return cDao.getAll();
    }
    @GetMapping("/search/{name}")
    public List<Category> searchByName(@PathVariable String name) {
        return cDao.sreachByName(name);
    }
    @GetMapping("/category/{idCategory}")
    public Category getCategoryById(@PathVariable int idCategory) {
        return cDao.getById(idCategory);
    }

    @PostMapping("category")
    public String saveCategory(@RequestBody Category cate) {
        return cDao.save(cate) + "Ay za Chot tit";
    }

    @PutMapping("category/{idCategory}")
    public String updateCategory(@RequestBody Category cate, @PathVariable int idCategory) {
        return cDao.update(cate, idCategory) + "Update thanh cong";
    }

    @DeleteMapping("remove/{idCategory}")
    public String deleteCategory( @PathVariable int idCategory) {
        return cDao.delete(idCategory) + "delete thanh cong";
    }
}
