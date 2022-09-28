package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @彭新宇出品
 * @please respect copyringht
 */
public class BookController {
    private BookService bookService = null;

    public String index(HttpSession session) throws Exception {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList" , bookList);
        return "index";
    }

}
