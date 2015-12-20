package com.lcw.entity.book.test;

import com.lcw.entity.book.Book;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by vic on 2015/12/20.
 */
public class BookTest {

    @Test
    public void testBook(){
        Book book = new Book();
        book.setPk_book("pk001");
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        book.setPrice(100.5);

        Assert.assertNotNull(book.toString());
        System.out.println(book);
    }
}
