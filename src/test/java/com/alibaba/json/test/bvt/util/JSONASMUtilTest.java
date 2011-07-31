package com.alibaba.json.test.bvt.util;

import java.util.HashMap;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.util.ASMUtils;

public class JSONASMUtilTest extends TestCase {

    public void test_0() throws Exception {
        Assert.assertEquals("()I", ASMUtils.getDesc(HashMap.class.getMethod("size")));
        Assert.assertEquals("(Ljava/lang/Object;)Ljava/lang/Object;", ASMUtils.getDesc(HashMap.class.getMethod("get", Object.class)));
        Assert.assertEquals("(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", ASMUtils.getDesc(HashMap.class.getMethod("put", Object.class, Object.class)));
    }

    public void test_1() throws Exception {
        Assert.assertEquals("I", ASMUtils.getType(int.class));
        Assert.assertEquals("java/lang/Integer", ASMUtils.getType(Integer.class));
    }

    public void test_2() throws Exception {
        Assert.assertEquals("[I", ASMUtils.getType(int[].class));
        Assert.assertEquals("[Ljava/lang/Integer;", ASMUtils.getType(Integer[].class));
    }
}
