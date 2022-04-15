/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.OrderCourse;
import asm.asmjava4.model.OrderJoin;
import asm.asmjava4.model.OrderPagination;
import asm.asmjava4.model.Orders;
import java.util.List;

/**
 *
 * @author PC
 */
public interface OrderDAO {
     int addOrder(Orders orders);
     int addOrderCourse(OrderCourse orderCourse);
     List<OrderJoin> getListOrderById(OrderPagination orderP);
     List<OrderJoin> getTotalPage(int idUser);
}
