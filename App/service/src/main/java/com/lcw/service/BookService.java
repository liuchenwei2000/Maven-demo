package com.lcw.service;

import com.lcw.entity.book.Book;

import java.util.List;

/**
 * <p></p>
 *
 * @author liuchenwei
 * @date 2015/12/21
 */
public interface BookService
{
    String save(Book book);

    int delete(String pk_book);

    Book getBook(String pk_book);

    List<Book> getBooks();
}
