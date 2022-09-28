package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.domain.Cart;
import com.example.book.domain.CartItem;
import com.example.book.domain.User;
import com.example.book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class CartController {

    private CartItemService cartItemService = null;

    public String addCart(Integer bookId , HttpSession session) throws Exception {
        //将指定的图书添加到当前用户的购物车中，如果当前用户的购物车已经存在这个图书了，那么将购物车中该书的数量+1，否则新增这本图书的CartItem
        User user = (User)session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId) , 1 , user);
        cartItem.setBook(bookId);
        cartItem.setUserBean(user.getId());
        cartItemService.addOrUpdateCartItem(cartItem , user.getCart());
        return "redirect:cart.do";
    }

    //加载当前用户的购物车信息
    public String index(HttpSession session) throws Exception {
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser",user);
        return "cart/cart";
    }


    public String editCart(Integer cartItemID , Integer buyCount) throws Exception {
        cartItemService.updateCartItem(new CartItem(cartItemID,buyCount));
        return "redirect:cart.do";
    }
}
