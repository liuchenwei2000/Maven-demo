package com.lcw.jdbc;

import java.util.UUID;

/**
 * Created by vic on 2015/12/20.
 */
public class IDGenerator {

    public static String geneate(){
        return UUID.randomUUID().toString();
    }
}
