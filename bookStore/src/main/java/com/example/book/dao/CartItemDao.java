package com.example.book.dao;

import com.example.book.domain.Book;
import com.example.book.domain.CartItem;
import com.example.book.domain.User;
import com.example.book.ssm.basedao.BasicDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class CartItemDao extends BasicDao<CartItem>  {
    //新增购物车项
    public void addCartItem(CartItem cartItem) throws RuntimeException{
        String sql = "insert into t_cart_item values(0,?,?,?)";
        try {
            dml(sql,cartItem.getBook(),cartItem.getBuyCount(),cartItem.getUserBean());
        } catch (SQLException e) {
            throw new RuntimeException("添加购物车失败");
        }
    }

    //修改特定的购物车项
    public void updateCart(CartItem cartItem) throws Exception{
        String sql = "update t_cart_item set buyCount = ? where id = ?";
        try {
            dml(sql,cartItem.getBuyCount(), cartItem.getId());
        } catch (SQLException e) {
            throw new RuntimeException("添加购物车失败");
        }
    }

    //获取特定用户的所有购物车项
    public List<CartItem> getCartItemList(User user) throws Exception{
        String sql = "select * from t_cart_item where userBean = ?";
        try {
            return querymulti(sql, CartItem.class, user.getId());
        } catch (SQLException e) {
            throw new RuntimeException("获取购物车失败");
        }
    }

    //删除指定的购物车项
    public void deleteCartItem(CartItem cartItem) throws Exception{
        String sql = "delete from t_cart_item where id = ?";
        try {
            dml(sql,cartItem.getId());
        } catch (SQLException e) {
            throw new RuntimeException("删除购物车项失败");
        }
    }
}
