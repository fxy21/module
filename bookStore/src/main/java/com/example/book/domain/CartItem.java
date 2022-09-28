package com.example.book.domain;

import java.math.BigDecimal;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class CartItem {
    private Integer id;
    private Integer book;
    private Book realBook;
    private Integer buyCount;
    private Integer userBean;
    private User realUserBean;
    private Double xj;

    public CartItem() {
    }

    public CartItem(Book realBook, Integer buyCount, User realUserBean) {
        this.realBook = realBook;
        this.buyCount = buyCount;
        this.realUserBean = realUserBean;
    }

    public CartItem(Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
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

    public Book getRealBook() {
        return realBook;
    }

    public void setRealBook(Book realBook) {
        this.realBook = realBook;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Integer getUserBean() {
        return userBean;
    }

    public void setUserBean(Integer userBean) {
        this.userBean = userBean;
    }

    public User getRealUserBean() {
        return realUserBean;
    }

    public void setRealUserBean(User realUserBean) {
        this.realUserBean = realUserBean;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal(getRealBook().getPrice()+"");
        BigDecimal bigDecimalBuyCount = new BigDecimal(buyCount+"");
        BigDecimal bigDecimalXJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
        xj = bigDecimalXJ.doubleValue();
        return xj;
    }
}
