package com.example.book.dao;

import com.example.book.domain.Book;
import com.example.book.ssm.basedao.BasicDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class BookDao extends BasicDao<Book> {

    public List<Book> getBookList() throws Exception{
        String sql = "select * from t_book where bookStatus = 0";
        try {
            return querymulti(sql, Book.class);
        } catch (SQLException e) {
            throw new RuntimeException("查询图书列表失败");
        }
    }

    public Book getBookById(Integer bookId) throws Exception{
        String sql = "select * from t_book where id = ?";
        try {
            return querysingle(sql, Book.class, bookId);
        } catch (SQLException e) {
            throw new RuntimeException("根据Id获取Book失败");
        }
    }
}
