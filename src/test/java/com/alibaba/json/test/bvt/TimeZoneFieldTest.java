package com.alibaba.json.test.bvt;

import java.util.TimeZone;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class TimeZoneFieldTest extends TestCase {

    public void test_codec() throws Exception {
        User user = new User();
        user.setValue(TimeZone.getDefault());

        SerializeConfig mapping = new SerializeConfig();
        mapping.setAsmEnable(false);
        String text = JSON.toJSONString(user, mapping, SerializerFeature.WriteMapNullValue);

        User user1 = JSON.parseObject(text, User.class);

        Assert.assertEquals(user1.getValue(), user.getValue());
    }

    public void test_codec_null() throws Exception {
        User user = new User();
        user.setValue(null);

        SerializeConfig mapping = new SerializeConfig();
        mapping.setAsmEnable(false);
        String text = JSON.toJSONString(user, mapping, SerializerFeature.WriteMapNullValue);

        User user1 = JSON.parseObject(text, User.class);

        Assert.assertEquals(user1.getValue(), user.getValue());
    }

    public static class User {

        private TimeZone value;

        public TimeZone getValue() {
            return value;
        }

        public void setValue(TimeZone value) {
            this.value = value;
        }

    }
}
