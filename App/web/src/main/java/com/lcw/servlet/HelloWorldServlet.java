package com.lcw.servlet;

import com.lcw.entity.book.Book;
import com.lcw.service.BookService;
import com.lcw.service.impl.BookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p></p>
 *
 * @author liuchenwei
 * @date 2015/12/21
 */
public class HelloWorldServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String pk_book = req.getParameter("book_id");
        BookService bookService = new BookServiceImpl();
        Book book = bookService.getBook(pk_book);

        req.setAttribute("book", book);

        RequestDispatcher dispatcher = req.getRequestDispatcher("book.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}

