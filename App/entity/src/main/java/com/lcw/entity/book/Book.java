package com.lcw.entity.book;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by vic on 2015/12/20.
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 6883539317714754543L;

    private String pk_book;
    private String title;
    private String author;
    private double price;
}
