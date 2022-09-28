package com.example.book.domain;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class OrderItem {
    private Integer id;
    private Integer book;
    private Book realBook;
    private Integer buyCount;
    private Integer orderBean;
    private OrderBean realOrderBean;

    public OrderItem() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(Integer orderBean) {
        this.orderBean = orderBean;
    }

    public Book getRealBook() {
        return realBook;
    }

    public void setRealBook(Book realBook) {
        this.realBook = realBook;
    }

    public OrderBean getRealOrderBean() {
        return realOrderBean;
    }

    public void setRealOrderBean(OrderBean realOrderBean) {
        this.realOrderBean = realOrderBean;
    }
}
