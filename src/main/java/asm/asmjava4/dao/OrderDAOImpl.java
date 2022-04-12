/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.dao;

import asm.asmjava4.model.OrderCourse;
import asm.asmjava4.model.Orders;
import asm.asmjava4.model.User;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int addOrder(Orders orders) {
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        return jdbcTemplate.update("INSERT INTO orders ( idOrders ,timeOrder , status ,idUser ,paymentMethods ,bankNumber ) VALUES (?, ?, ?, ?, ?, ?)", new Object[]{orders.getIdOrders(), timestamp2, orders.getStatus(), orders.getIdUser(), orders.getPaymentMethods(), orders.getBankNumber()});
    }

    @Override
    public int addOrderCourse(OrderCourse orderCourse) {
        return jdbcTemplate.update("INSERT INTO ordercourse (idOrderCourse, idOrders, idCourse, priceCourseOrder) VALUES (?,?,?,?)", new Object[]{orderCourse.getIdOrderCourse(),orderCourse.getIdOrders(),orderCourse.getIdCourse(),orderCourse.getPriceCourseOrder()});
    }

}
