package com.example.book.dao;

import com.example.book.domain.OrderBean;
import com.example.book.domain.User;
import com.example.book.ssm.basedao.BasicDao;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OrderDao extends BasicDao<OrderBean> {
    //添加订单
    public void addOrderBean(OrderBean orderBean) throws Exception {
        String sql = "insert into t_order values(0,?,?,?,?,?)";
        try {
            dml(sql,orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        } catch (SQLException e) {
            throw new RuntimeException("添加订单失败");
        }

    }

    //根据一个订单获取它的id
    public Integer getOrderBeanId(OrderBean orderBean) throws Exception{
        String sql = "select id from t_order where orderNo = ?";
        try {
            Object idObj = queryscalar(sql, orderBean.getOrderNo());
            if (idObj != null) {
                return (Integer) idObj;
            } else {
                throw new RuntimeException("查询订单Id失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException("查询订单Id失败");
        }
    }


    //获取指定用户的订单列表
    public List<OrderBean> getOrderList(User user) throws Exception {
        String sql = "select * from t_order where orderUser = ?";
        try {
            return querymulti(sql, OrderBean.class, user.getId());
        } catch (SQLException e) {
            throw new RuntimeException("获取用户订单失败");
        }
    }

    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "select sum(t3.buyCount) as totalBookCount from" +
                " (select t1.id , t2.buyCount , t2.orderBean from t_order t1 inner join t_order_item t2" +
                " on t1.id = t2.orderBean where t1.orderUser = ?)" +
                " t3 where t3.orderBean = ? group by t3.orderBean";
        try {
            return  ((BigDecimal)queryscalar(sql,orderBean.getOrderUser(),orderBean.getId())).intValue();
        } catch (SQLException e) {
            throw new RuntimeException("获取订单数量失败");
        }
    }
}
