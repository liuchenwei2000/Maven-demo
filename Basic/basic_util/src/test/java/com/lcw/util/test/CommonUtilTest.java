package com.lcw.util.test;

import com.lcw.util.CommonUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by vic on 2015/12/20.
 */
public class CommonUtilTest {

    @Test
    public void testIsEmpty(){
        Assert.assertTrue(CommonUtil.isEmpty((String)null));
        Assert.assertTrue(CommonUtil.isEmpty((Object)null));
        Assert.assertTrue(CommonUtil.isEmpty(""));
        Assert.assertTrue(CommonUtil.isEmpty(new String[]{}));

        Assert.assertFalse(CommonUtil.isEmpty(" "));
        Assert.assertFalse(CommonUtil.isEmpty(new Object()));
        Assert.assertFalse(CommonUtil.isEmpty(new String[]{"A","B"}));
    }
}
