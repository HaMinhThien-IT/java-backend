/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.model;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseArr extends Category{
     Course[] cout;

    public CourseArr(Course[] cout, Integer idCategory, String name, String image, String description) {
        super(idCategory, name, image, description);
        this.cout = cout;
    }
     
}
