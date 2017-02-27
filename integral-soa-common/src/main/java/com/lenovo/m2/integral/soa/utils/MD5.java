package com.lenovo.m2.integral.soa.utils;

import org.apache.commons.codec.digest.DigestUtils;

import static org.apache.commons.httpclient.HttpConstants.getContentBytes;

/**
 * Created by admin on 2017/2/27.
 */
public class MD5 {

    public static String sign(String text, String key, String input_charset) {
        text = text + key;
        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

}
