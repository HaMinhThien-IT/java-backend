/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.PostDAO;
import asm.asmjava4.model.Course;
import asm.asmjava4.model.Post;
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
public class PostController {

    @Autowired
    private PostDAO pDao;

    @GetMapping("/posts")
    public List<Post> getListCourses() {
        return pDao.getAll();
    }
    @GetMapping("/postById/{id}")
    public List<Post> getListPostById(@PathVariable int id) {
        System.out.println("id " + id);
        return pDao.getAllById((Integer)id);
    }
    @GetMapping("/post/{idPost}")
    public Post getCoursesById(@PathVariable int idPost) {
        return pDao.getById((Integer) idPost);
    }
    
    @PostMapping("/post")
    public String saveCourses(@RequestBody Post post) {
        System.out.println("post" + post);
        return pDao.save(post) + "Ay za Chot tit";
    }
     @DeleteMapping("removePost/{idPost}")
    public String deleteCategory( @PathVariable int idPost) {
        return pDao.delete(idPost) + "delete thanh cong";
    }
     @PutMapping("post/{id}")
    public String updateCourses(@RequestBody Post post, @PathVariable int id) {
        return pDao.update(post, id) + "Update thanh cong";
    }


}
