/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Course;
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
public class CourseDAOImpl implements CourseDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Course course) {
       return jdbcTemplate.update("INSERT INTO course ( imageCourse, title, description, content, idCategory) VALUES (?, ?, ?, ?, ?);",new Object[]{course.getImageCourse(),course.getTitle(),course.getDescription(),course.getContent(),course.getIdCategory()});
    }

    @Override
    public int update(Course course, int id) {
       return jdbcTemplate.update("UPDATE course set imageCourse =?, title=?, description =? , content =? , idCategory =? where idCourse=?",new Object[]{course.getImageCourse(),course.getTitle(),course.getDescription(),course.getContent(),course.getIdCategory(),id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE from course where idCourse=?",id);
    }

    @Override
    public List<Course> getAll() {
         return jdbcTemplate.query("select * from course ORDER BY idCourse DESC", new BeanPropertyRowMapper<Course>(Course.class));
    }

    @Override
    public Course getById(int id) {
         return jdbcTemplate.queryForObject("SELECT * FROM course where idCourse=?", new BeanPropertyRowMapper<Course>(Course.class),id);
    }
}
