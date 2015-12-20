package com.lcw.dao.impl;

import com.lcw.dao.BookDao;
import com.lcw.db.DBUtil;
import com.lcw.entity.book.Book;
import com.lcw.jdbc.IDGenerator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vic on 2015/12/20.
 */
public class BookDaoImpl implements BookDao {

    private static final String SQL_INSERT = "INSERT INTO tb_book(pk_book,title,author,price) VALUES(?,?,?,?)";

    public String insert(Book book) {
        Connection connection = null;
        PreparedStatement stmt = null;

        String pk_book = IDGenerator.geneate();

        try {
            connection = DBUtil.getConnection();

            stmt = connection.prepareStatement(SQL_INSERT);
            stmt.setString(1, pk_book);
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setDouble(4, book.getPrice());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            DBUtil.closeQiuetly(connection, stmt, null);
        }
        return pk_book;
    }

    private static final String SQL_UPDATE = "UPDATE tb_book SET title=?,author=?,price=? WHERE pk_book=?";

    public void update(Book book) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();

            stmt = connection.prepareStatement(SQL_UPDATE);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setDouble(3, book.getPrice());
            stmt.setString(4, book.getPk_book());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            DBUtil.closeQiuetly(connection, stmt, null);
        }
    }

    private static final String SQL_DELETE = "DELETE FROM tb_book WHERE pk_book=?";

    public void delete(String pk_book) {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = DBUtil.getConnection();

            stmt = connection.prepareStatement(SQL_DELETE);
            stmt.setString(1, pk_book);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            DBUtil.closeQiuetly(connection, stmt, null);
        }
    }

    private static final String SQL_QUERY_BY_ID = "SELECT pk_book,title,author,price FROM tb_book WHERE pk_book=?";

    public Book find(String id) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Book book = null;
        try {
            connection = DBUtil.getConnection();
            stmt = connection.prepareStatement(SQL_QUERY_BY_ID);
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                book = buildBook(rs);
                break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            DBUtil.closeQiuetly(connection, stmt, rs);
        }
        return book;
    }

    private Book buildBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setPk_book(rs.getString(1));
        book.setTitle(rs.getString(2));
        book.setAuthor(rs.getString(3));
        book.setPrice(rs.getDouble(4));
        return book;
    }

    private static final String SQL_QUERY = "SELECT pk_book,title,author,price FROM tb_book";

    public List<Book> findAll() {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Book> books = new ArrayList<Book>();
        try {
            connection = DBUtil.getConnection();
            stmt = connection.prepareStatement(SQL_QUERY);
            rs = stmt.executeQuery();

            while (rs.next()) {
                books.add(buildBook(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e);
        } finally {
            DBUtil.closeQiuetly(connection, stmt, rs);
        }
        return books;
    }
}
