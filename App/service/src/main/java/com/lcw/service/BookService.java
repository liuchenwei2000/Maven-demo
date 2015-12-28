package com.lcw.service;

import com.lcw.entity.book.Book;

import java.util.List;

/**
 * <p>Book 对象 Service</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public interface BookService
{
    /**
     * 保存操作
     *
     * @param book 对象
     * @return 主键
     */
    String save(Book book);

    /**
     * 删除操作
     *
     * @param pk_book 主键
     * @return 影响行数
     */
    int delete(String pk_book);

    /**
     * 根据主键进行查询
     *
     * @param pk_book 主键
     * @return Book 对象
     */
    Book getBook(String pk_book);

    /**
     * 查询所有的 Book 对象
     *
     * @return Book 对象列表
     */
    List<Book> getBooks();
}
