package com.example.book.service;

import com.example.book.dao.BookDao;
import com.example.book.domain.Book;

import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class BookService {
    private BookDao bookDao = null;

    public List<Book> getBookList() throws Exception {
        return bookDao.getBookList();
    }

    public Book getBookById(Integer bookId) throws Exception {
        return bookDao.getBookById(bookId);
    }
}
