package com.example.book.domain;

import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OrderBean {
    private Integer id;
    private String orderNo;
    private String orderDate;
    private Integer orderUser;
    private User realOrderUser;
    private Double orderMoney;
    private Integer orderStatus;
    private Integer totalBookCount;
    private List<OrderItem> orderItems;

    public OrderBean() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Integer orderUser) {
        this.orderUser = orderUser;
    }

    public Double getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Double orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public User getRealOrderUser() {
        return realOrderUser;
    }

    public void setRealOrderUser(User realOrderUser) {
        this.realOrderUser = realOrderUser;
    }

    public Integer getTotalBookCount() {

        return totalBookCount;
    }

    public void setTotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }
}
