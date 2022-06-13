/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.Course;
import asm.asmjava4.model.CourseArr;
import asm.asmjava4.model.CourseFull;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CourseDAO {
   int save(Course course);
   int update(Course course,int id);
   int delete (int id);
   List<CourseFull> getAll(); 
   List<CourseFull> getCourse(String name); 
   Course getById(int id);
}
