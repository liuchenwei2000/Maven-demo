package com.lcw.dao.test;

import com.lcw.dao.BookDao;
import com.lcw.dao.impl.BookDaoImpl;

import com.lcw.entity.book.Book;
import static junit.framework.Assert.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by vic on 2015/12/20.
 */
public class BookDaoTest {

    @Test
    public void testInsert(){
        BookDao dao = new BookDaoImpl();

        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        book.setPrice(100.5);
        String pk_book = dao.insert(book);

        System.out.println(pk_book);
        assertNotNull(pk_book);

        String newTitle = "Thinking in Java 4th Edition";
        book.setPk_book(pk_book);
        book.setTitle(newTitle);
        dao.update(book);

        Book bookByPk = dao.find(pk_book);
        assertNotNull(bookByPk);
        assertEquals(newTitle, bookByPk.getTitle());

        List<Book> books = dao.findAll();
        assertTrue(books.size() > 0);

        dao.delete(pk_book);
        bookByPk = dao.find(pk_book);
        assertNull(bookByPk);
    }
}
