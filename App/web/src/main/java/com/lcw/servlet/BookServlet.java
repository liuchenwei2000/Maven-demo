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
import java.util.List;

/**
 * <p>Book 操作对应的 Servlet</p>
 *
 * @author liuchenwei
 * @date 2015/12/21
 */
public class BookServlet extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        BookService bookService = new BookServiceImpl();
        List<Book> books = bookService.getBooks();

        req.setAttribute("books", books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("books.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String price = req.getParameter("price");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPrice(Double.parseDouble(price));

        BookService bookService = new BookServiceImpl();
        book.setPk_book(bookService.save(book));

        req.setAttribute("book", book);

        RequestDispatcher dispatcher = req.getRequestDispatcher("book.jsp");
        dispatcher.forward(req, resp);
    }
}

