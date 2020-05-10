package com.cross.utils;


import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * @author maxiaolin
 * @date 2019/11/11
 */
public class Encodes {
    static char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    static char[] DIGITS_UPPER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static SecureRandom random = new SecureRandom();
    static String MD5="MD5";
    /**
     * Md5方式加密，生成随机的 16 位salt并经过1024次 md5 hash
     *
     * @return 加密后的字符串
     * @see Digests
     */
    public static String entryptMd5(String plainText, boolean toLowerCase) {
        byte[] salt = Digests.generateSalt(8);
        byte[] hashText = Digests.md5(plainText.getBytes(), salt, 1024);
        return Encodes.encodeHex(salt, toLowerCase) + Encodes.encodeHex(hashText, toLowerCase);
    }

    public static void main(String[] args) {
        System.out.println(entryptMd5("123456",false));
        System.out.println(entryptMd5("123456",false));
        System.out.println(entryptMd5("123456",false));
        System.out.println(entryptMd5("123456",false));
    }

    /**
     * 对输入字符串进行md5散列.
     */
    public static byte[] md5(byte[] input, byte[] salt, int iterations) {
        return digest(input, MD5, salt, iterations);
    }

    /**
     * 对字符串进行散列, 支持md5与sha1算法.
     */
    private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);

            if (salt != null) {
                digest.update(salt);
            }

            byte[] result = digest.digest(input);

            for (int i = 1; i < iterations; i++) {
                digest.reset();
                result = digest.digest(result);
            }
            return result;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成随机的Byte[]作为salt.
     *
     * @param numBytes byte数组的大小
     */
    public static byte[] generateSalt(int numBytes) {
        if (numBytes <= 0) {
            throw new RuntimeException("numBytes argument must be a positive integer (1 or larger)");
        }
        byte[] bytes = new byte[numBytes];

        random.nextBytes(bytes);
        return bytes;
    }

    /**
     * Hex编码.
     */
    public static String encodeHex(byte[] input, boolean toLowerCase) {
        return new String(toLowerCase ? encodeHexText(input, DIGITS_LOWER) : encodeHexText(input, DIGITS_UPPER));
    }

    /**
     * Hex编码
     */
    protected static char[] encodeHexText(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for (int var5 = 0; i < l; ++i) {
            out[var5++] = toDigits[(240 & data[i]) >>> 4];
            out[var5++] = toDigits[15 & data[i]];
        }
        return out;
    }
}
