package com.example.book.service;

import com.example.book.dao.CartItemDao;
import com.example.book.dao.OrderDao;
import com.example.book.dao.OrderItemDao;
import com.example.book.domain.CartItem;
import com.example.book.domain.OrderBean;
import com.example.book.domain.OrderItem;
import com.example.book.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OrderService {
    private OrderDao orderDao = null;
    private OrderItemDao orderItemDao = null;
    private CartItemDao cartItemDao = null;


    public Integer getOrderBeanId(OrderBean orderBean) throws Exception {
        return orderDao.getOrderBeanId(orderBean);
    }

    public void addOrderBean(OrderBean orderBean) throws Exception {
        //1.订单表添加一条记录
        orderDao.addOrderBean(orderBean);
        orderBean.setId(getOrderBeanId(orderBean));
        //2.订单详情表添加记录
        User currUser = orderBean.getRealOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setRealBook(cartItem.getRealBook());
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setRealOrderBean(orderBean);
            orderItem.setOrderBean(orderBean.getId());
            orderItemDao.addOrderItem(orderItem);
        }
        //3.购物车项需要删除对应的所有记录
        for(CartItem cartItem : cartItemMap.values()) {
            cartItemDao.deleteCartItem(cartItem);
        }
    }


    public List<OrderBean> getOrderList(User user) throws Exception {
        List<OrderBean> orderBeanList = orderDao.getOrderList(user);
        for (OrderBean orderBean : orderBeanList) {
            Integer totalBookCount = orderDao.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }
        return orderBeanList;

    }
}
