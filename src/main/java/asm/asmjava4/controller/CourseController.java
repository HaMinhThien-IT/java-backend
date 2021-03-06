/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.CourseDAO;
import asm.asmjava4.model.Category;
import asm.asmjava4.model.Course;
import asm.asmjava4.model.CourseArr;
import asm.asmjava4.model.CourseFull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
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
public class CourseController {

    @Autowired
    private CourseDAO cDao;

    @GetMapping("/courses")
    public List<CourseFull> getListCourses() {
        return cDao.getAll();
    }

    @GetMapping("/courses/{name}")
    public List<CourseFull> getListCoursesByName(@PathVariable String name) {
        return cDao.getCourse(name);
    }

    @GetMapping("/course/{id}")
    public Course getCoursesById(@PathVariable int id) {
        return cDao.getById((Integer) id);
    }

    @PostMapping("course")
    public String saveCourses(@RequestBody Course course) {
        return cDao.save(course) + "Ay za Chot tit";

    }

    @PutMapping("course/{id}")
    public String updateCourses(@RequestBody Course course, @PathVariable int id) {
        return cDao.update(course, id) + "Update thanh cong";
    }

    @DeleteMapping("course/{id}")
    public String deleteCourses(@PathVariable int id) {
        return cDao.delete(id) + "delete thanh cong";
    }
}
