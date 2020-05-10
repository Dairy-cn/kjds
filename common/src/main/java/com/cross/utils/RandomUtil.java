package com.cross.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * Utility class for generating random Strings.
 */
public final class RandomUtil {

    private static final int DEF_COUNT = 20;

    private RandomUtil() {
    }

    /**
     * Generate a password.
     *
     * @return the generated password
     */
    public static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(DEF_COUNT);
    }

    /**
     * Generate an activation key.
     *
     * @return the generated activation key
     */
    public static String generateActivationKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    /**
    * Generate a reset key.
    *
    * @return the generated reset key
    */
    public static String generateResetKey() {
        return RandomStringUtils.randomNumeric(DEF_COUNT);
    }

    /**
     * 随机生成验证码
     *
     * @return
     */
    public static Long generateValidateCode(){
        return RandomUtils.nextLong(100000, 999999);
    }

    /**
     * 随机两位数生成验证码
     *
     * @return
     */
    public static Long generateTwoValidateCode(){
        return RandomUtils.nextLong(10, 99);
    }

    /**
     * 根据传参 随机n位数生成验证码
     *
     * @return
     */
    public static Long generateTwoValidateCode(long startInclusive, long endExclusive){
        return RandomUtils.nextLong(startInclusive, endExclusive);
    }

    public static Long shippingValidateCode(){
        return RandomUtils.nextLong(1000, 9999);
    }

    public static String generateRandomValue(Integer count){
        return String.format("%s", RandomUtils.nextLong(100000000000000000L, 999999999999999999L));
    }

    /**
     * Generate an activation key.
     *
     * @return the generated activation key
     */
    public static String generateFoldName() {
        return String.format("%s%s", RandomStringUtils.randomNumeric(DEF_COUNT), RandomStringUtils.randomNumeric(DEF_COUNT));
    }

    /**
     * 随机生成验证码10位
     *
     * @return
     */
    public static Long tenValidateCode(){
        return RandomUtils.nextLong(1000000000, 9999999999L);
    }

    /**
     * 随机生成验证码12位
     *
     * @return
     */
    public static Long twelveValidateCode(){
        return RandomUtils.nextLong(100000000000L, 999999999999L);
    }


    public static Long generateMerchantCode(){
        return RandomUtils.nextLong(1000000000000000L, 9999999999999999L);
    }


    /**
     * 生成八位数字
     *
     * @return
     */
    public static String randomId() {

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            String result = "";
            for (int j = 0; j < 8; j++) {
                result += random.nextInt(10);
            }
            return result;
        }
        return null;
    }
}
