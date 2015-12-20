package com.lcw.dao;

import com.lcw.entity.book.Book;

import java.util.List;

/**
 * Created by vic on 2015/12/20.
 */
public interface BookDao {

    String insert(Book book);

    void update(Book book);

    void delete(String pk_book);

    Book find(String id);

    List<Book> findAll();
}
