/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.controller;

import asm.asmjava4.dao.OrderDAO;
import asm.asmjava4.model.Category;
import asm.asmjava4.model.OrderCourse;
import asm.asmjava4.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@CrossOrigin(origins = "*")
public class OrderController {
     @Autowired
    private OrderDAO oDao;
    @PostMapping("/addOrder")
    public String saveOrder(@RequestBody Orders orders) {
         System.out.println(orders);
        return oDao.addOrder(orders) + "Ay za Chot tit";
    }
    @PostMapping("/addOrderCourse")
    public String saveOrderCourse(@RequestBody OrderCourse orderCourse) {
        return oDao.addOrderCourse(orderCourse) + "Ay za Chot tit";
    }
}
