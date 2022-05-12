/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.PostDAO;
import asm.asmjava4.model.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/post/{idPost}")
    public Post getCoursesById(@PathVariable int idPost) {
        return pDao.getById((Integer) idPost);
    }
    
    @PostMapping("/post")
    public String saveCourses(@RequestBody Post post) {
        return pDao.save(post) + "Ay za Chot tit";
    }

}
