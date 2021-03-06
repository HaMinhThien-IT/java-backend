/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Course;
import asm.asmjava4.model.CourseArr;
import asm.asmjava4.model.CourseFull;
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
    public List<CourseFull> getAll() {
         return jdbcTemplate.query("select * from course join category on course.idCategory = category.idCategory ORDER BY course.idCourse DESC", new BeanPropertyRowMapper<CourseFull>(CourseFull.class));
    }

    @Override
    public Course getById(int id) {
         return jdbcTemplate.queryForObject("SELECT * FROM course where idCourse=?", new BeanPropertyRowMapper<Course>(Course.class),id);
    }

    @Override
    public List<CourseFull> getCourse(String name) {
         return jdbcTemplate.query("select * from course where title like '%"+name+"%'", new BeanPropertyRowMapper<CourseFull>(CourseFull.class));
    }
}
