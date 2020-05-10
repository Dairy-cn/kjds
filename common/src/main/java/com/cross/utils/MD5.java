package com.cross.utils;

import com.cross.exception.MD5Exception;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;


/**
 * 功能：MD5签名
 * @author DuYuLiang
 * */
public class MD5 {
    private static final Logger log = LoggerFactory.getLogger(MD5.class);

    private MD5(){}

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param inputCharset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key, String inputCharset) {
        String newText = text + key;
        log.info("wait md5 code string:" + newText);
        return DigestUtils.md5Hex(getContentBytes(newText, inputCharset));
    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param inputCharset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key, String
        inputCharset) {
        String newText = text + key;
        String mySign = DigestUtils.md5Hex(getContentBytes(newText, inputCharset));
        Boolean result = false;
        if(mySign.equals(sign)) {
            result = true;
        }
        return result;
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            log.error("get content bytes exception: {}", e);
            throw new MD5Exception("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

}
