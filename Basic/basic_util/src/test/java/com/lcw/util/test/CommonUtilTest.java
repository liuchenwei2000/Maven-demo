package com.lcw.util.test;

import com.lcw.util.CommonUtil;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by vic on 2015/12/20.
 */
public class CommonUtilTest {

    /**
     * JUnit4 中需要执行的测试方法都应该以 @Test 进行标注。
     */
    @Test
    public void testIsEmpty(){
        assertTrue(CommonUtil.isEmpty((String)null));
        assertTrue(CommonUtil.isEmpty((Object)null));
        assertTrue(CommonUtil.isEmpty(""));
        assertTrue(CommonUtil.isEmpty(new String[]{}));

        assertFalse(CommonUtil.isEmpty(" "));
        assertFalse(CommonUtil.isEmpty(new Object()));
        assertFalse(CommonUtil.isEmpty(new String[]{"A","B"}));
    }
}
