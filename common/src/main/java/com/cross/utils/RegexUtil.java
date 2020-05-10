package com.cross.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hcy
 * @descrption 正则表达式验证
 * @date 2019-5-20.
 */
public class RegexUtil {
    /**
     * 手机号校验
     * 中国电信号段 133、149、153、173、177、180、181、189、199
     * 中国联通号段 130、131、132、145、155、156、166、175、176、185、186
     * 中国移动号段 134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198
     *
     * @param phone
     * @return
     */
    public static boolean isStrictPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(165)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$|^0\\d{2,3}\\d{7,8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
     * 11位正整数
     *
     * @param phone
     * @return
     */
    public static Boolean isPhone(String phone) {
        String regex = "^\\d{11}$";
        if (phone.length() != 11) {
            return Boolean.FALSE;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
     * 验证8位
     * @param phone
     * @return
     */
    public static Boolean isEightPhone(String phone) {
        String regex = "^\\d{8}$";
        if (phone.length() != 8) {
            return Boolean.FALSE;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            return m.matches();
        }
    }

    /**
     * 验证手机号码或者电话号码
     *
     * @param str
     * @return
     */
    public static boolean isPhoneStr(String str) {
        String s = str.replace("—", "").replace("-", "");
        String regex1 = "^\\d{3,4}\\d{6,9}$";
        String regex2 = "^\\d{3,4}-\\d{6,9}$";
        Pattern r1 = Pattern.compile(regex1);
        Pattern r2 = Pattern.compile(regex2);
        Matcher m = r1.matcher(s);
        Matcher m2 = r2.matcher(s);
        return m.matches() || m2.matches();
    }


    /**
     * 手机号验证
     *
     * @param str
     * @return 验证通过返回true
     */
    public static boolean isMobile(final String str) {

        boolean b = false;
        String pattern = "0?(13|14|15|18|19|17|16)[0-9]{9}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        b = m.matches();
        return b;

    }

    /**
     * 带一位或者两位小数或者整数的判断
     *
     * @param number
     * @return
     */
    public static Boolean isTwoDouble(String number) {

        String regex = "^\\d+(.\\d{1,2})?|\\d$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(number);
        return m.matches();
    }

    /**
     * 带一位小数或者整数的判断
     *
     * @param number
     * @return
     */
    public static Boolean isOneDouble(String number) {

        String regex = "^\\d+(.\\d)?|\\d$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(number);
        return m.matches();
    }

    /**
     * 正整数的判断
     *
     * @param number
     * @return
     */
    public static Boolean isInteger(String number) {

        String regex = "^\\d|\\d+(.[0])?$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(number);
        return m.matches();
    }

    /**
     * 截取支付url中的支付编号：
     *
     * @param str http://clt.canyingdongli.com/transcation/api/pay-we-app/20190711113937237365678521940672?type=1?type=1
     * @return 20190711113937237365678521940672
     */
    public static String interceptStr(String str) {

        String re = "\\d{32}";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(str);
        String result = "";
        while (m.find()) {
            result = m.group();
        }
        return result;
    }

    //三位数字的正整数
    public static Boolean threeNumCheck(String day){
        String re = "^\\d{1,3}$";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(day);
        return m.matches();
    }

    public static void main(String[] args) {

        String s = "028-82617666";
        String regexp = "^[0][1-9]{2,3}—[0-9]{5,10}$";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(s);
        System.out.println(matcher.matches());
        System.out.println(RegexUtil.isPhoneStr(s));
        System.out.println(RegexUtil.isMobile(s));
        System.out.println(RegexUtil.isPhone(s));
        System.out.println(RegexUtil.isEightPhone(s));
    }
}
