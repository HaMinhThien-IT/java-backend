/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author PC
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderJoin extends Orders {
    String idOrderCourse;
    Integer idCourse;
    Integer priceCourseOrder;
    String imageCourse;
    String title;
    String description;
    String content;
    Integer idCategory;
    
}
