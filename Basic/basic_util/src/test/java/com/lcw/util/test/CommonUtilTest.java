package com.lcw.util.test;

import com.lcw.util.CommonUtil;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>公共工具类测试用例</p>
 *
 * @author liuchenwei
 * @date 2015/12/20
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
