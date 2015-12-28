package com.lcw.service.impl;

import com.lcw.dao.BookDao;
import com.lcw.dao.impl.BookDaoImpl;
import com.lcw.entity.book.Book;
import com.lcw.service.BookService;
import com.lcw.util.CommonUtil;

import java.util.List;

/**
 * <p>Book 对象 Service 实现类</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public class BookServiceImpl implements BookService
{
    private BookDao dao = new BookDaoImpl();

    @Override
    public String save(Book book)
    {
        String pk_book = book.getPk_book();
        if(CommonUtil.isEmpty(pk_book)) {// 新增
            pk_book = dao.insert(book);
        }else {// 修改
            dao.update(book);
        }
        return pk_book;
    }

    @Override
    public int delete(String pk_book)
    {
        try {
            dao.delete(pk_book);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
            return 1;
        }

    }

    @Override
    public Book getBook(String pk_book)
    {
        return dao.find(pk_book);
    }

    @Override
    public List<Book> getBooks()
    {
        return dao.findAll();
    }
}
