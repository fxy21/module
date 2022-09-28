package com.example.book.service;

import com.example.book.dao.CartItemDao;
import com.example.book.domain.Book;
import com.example.book.domain.Cart;
import com.example.book.domain.CartItem;
import com.example.book.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class CartItemService {

    private CartItemDao cartItemDao = null;
    private BookService bookService = null;

    public void addCartItem(CartItem cartItem) throws Exception {
        cartItemDao.addCartItem(cartItem);
    }

    public void updateCartItem(CartItem cartItem) throws Exception {
        cartItemDao.updateCart(cartItem);
    }

    public void addOrUpdateCartItem(CartItem cartItem , Cart cart) throws Exception {
        //判断当前用户的购物车是否有这本书
        if(cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if(cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            if(cartItemMap.containsKey(cartItem.getRealBook().getId())){
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount()+1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        } else {
            addCartItem(cartItem);
        }
    }


    //加载指定用户的购物车信息
    public Cart getCart(User user) throws Exception {
        List<CartItem> cartItemList = cartItemDao.getCartItemList(user);
        Map<Integer,CartItem> cartItemMap = new HashMap<>();
        cartItemList.forEach(cartItem->{
            Book book = null;
            try {
                book = bookService.getBookById(cartItem.getBook());
                cartItem.setRealBook(book);
                cartItemMap.put(cartItem.getBook(),cartItem);
            } catch (Exception e) {
                throw new RuntimeException("加载购物车失败");
            }
        });
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }
}
