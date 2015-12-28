package com.lcw.dao;

import com.lcw.entity.book.Book;

import java.util.List;

/**
 * <p>Book 对象 Dao</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public interface BookDao {

    /**
     * 插入新的 Book 对象
     *
     * @param book Book 对象
     * @return Book 对象主键
     */
    String insert(Book book);

    /**
     * 更新 Book 对象
     *
     * @param book Book 对象
     */
    void update(Book book);

    /**
     * 根据主键删除对应的 Book 对象
     *
     * @param id Book 对象主键
     */
    void delete(String id);

    /**
     * 根据主键查询对应的 Book 对象
     *
     * @param id Book 对象主键
     * @return Book 对象
     */
    Book find(String id);

    /**
     * 查询所有的 Book 的对象
     *
     * @return Book 对象列表
     */
    List<Book> findAll();
}
