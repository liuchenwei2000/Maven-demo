package com.lcw.entity.book;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>Book 类</p>
 * 这是一个 JavaBean
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 6883539317714754543L;

    private String pk_book;
    private String title;
    private String author;
    private double price;
}
