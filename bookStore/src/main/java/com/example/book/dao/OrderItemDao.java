package com.example.book.dao;

import com.example.book.domain.OrderItem;
import com.example.book.ssm.basedao.BasicDao;

import java.sql.SQLException;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OrderItemDao extends BasicDao<OrderItem> {
    //添加订单项
    public void addOrderItem(OrderItem orderItem) throws Exception {
        String sql = "insert into  t_order_item values(0,?,?,?)";
        try {
            dml(sql,orderItem.getBook(),orderItem.getBuyCount(),orderItem.getOrderBean());
        } catch (SQLException e) {
            throw new RuntimeException("添加订单项失败");
        }
    }
}
