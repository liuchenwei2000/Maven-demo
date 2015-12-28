package com.lcw.entity.book.test;

import com.lcw.entity.book.Book;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * <p>Book 类测试用例</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public class BookTest {

    @Test
    public void testBook(){
        Book book = new Book();
        book.setPk_book("pk001");
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        book.setPrice(100.5);

        assertNotNull(book.toString());
        System.out.println(book);
    }
}
