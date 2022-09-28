package com.example.book.controller;

import com.example.book.dao.OrderItemDao;
import com.example.book.domain.OrderBean;
import com.example.book.domain.User;
import com.example.book.service.OrderService;
import com.example.book.ssm.utils.DateUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OrderController {
    private OrderService orderService = null;

    //结账
    public String checkOut(HttpSession session) throws Exception {
        OrderBean orderBean = new OrderBean();
        orderBean.setOrderNo(DateUtils.getUUIDDate());
        orderBean.setOrderDate(DateUtils.getDateString());
        User user = (User)session.getAttribute("currUser");
        orderBean.setRealOrderUser(user);
        orderBean.setOrderUser(user.getId());
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);
        orderService.addOrderBean(orderBean);
        return "index";
    }


    //查看订单列表
    public String getOrderList(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser" , user);

        return "order/order";
    }
}
