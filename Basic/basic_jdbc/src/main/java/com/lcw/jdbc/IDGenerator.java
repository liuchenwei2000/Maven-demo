package com.lcw.jdbc;

import java.util.UUID;

/**
 * <p>主键生成器</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
 */
public class IDGenerator {

    /**
     * 生成 UUID 式主键
     *
     * @return 36 位字符串
     */
    public static String generate(){
        return UUID.randomUUID().toString();
    }
}
