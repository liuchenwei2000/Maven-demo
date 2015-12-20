package com.lcw.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by vic on 2015/12/20.
 */
public class CommonUtil {

    public static boolean isEmpty(String s){
        return StringUtils.isEmpty(s);
    }

    public static boolean isEmpty(Object object){
        return object == null || isEmpty(object.toString());
    }

    public static <T> boolean isEmpty(T[] array){
        return array == null || array.length == 0;
    }
}
