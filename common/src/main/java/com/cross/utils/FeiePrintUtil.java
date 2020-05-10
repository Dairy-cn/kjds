package com.cross.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.Result;
import com.cross.enumtype.PrintTypeNums;
import com.cross.model.MerchantPrinterModel;
import com.cross.model.ShopOrderPrintContent;
import com.cross.model.TableFee;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/*************************************************************
 * Description:  飞鹅自动打印机字符拼接工具类
 * Author: Dair
 * CreateTime: 2019/6/18
 ************************************************************/

public class FeiePrintUtil {


    private static String ORDER_TYPE_NET_ORDER = "NETWORK";

    //标签说明：
    //单标签:
    //"<BR>"为换行,"<CUT>"为切刀指令(主动切纸,仅限切刀打印机使用才有效果)
    //"<LOGO>"为打印LOGO指令(前提是预先在机器内置LOGO图片),"<PLUGIN>"为钱箱或者外置音响指令
    //成对标签：
    //"<CB></CB>"为居中放大一倍,"<B></B>"为放大一倍,"<C></C>"为居中,<L></L>字体变高一倍
    //<W></W>字体变宽一倍,"<QR></QR>"为二维码,"<BOLD></BOLD>"为字体加粗,"<RIGHT></RIGHT>"为右对齐
    //拼凑订单内容时可参考如下格式
    //根据打印纸张的宽度，自行调整内容的格式，可参考下面的样例格式
    public static String buildContent(ShopOrderPrintContent shopOrderPrintContent, MerchantPrinterModel merchantPrinterModel) {
        StringBuilder sb = new StringBuilder();

        //1 后厨 2 前台
        if (PrintTypeNums.FRONTDESK.toString().equals(merchantPrinterModel.getType())) {
            buildShopOrderPrintContent(shopOrderPrintContent, sb, merchantPrinterModel.isPrintPrice(), merchantPrinterModel.getUrl(), true);
        } else if (PrintTypeNums.KITCHEN.toString().equals(merchantPrinterModel.getType())) {
            buildShopOrderPrintContent(shopOrderPrintContent, sb, merchantPrinterModel.isPrintPrice(), merchantPrinterModel.getUrl(), false);
        }
        return sb.toString();
    }

    /**
     * <1B40><1B40><1B40><1D2111><1B6101>喜乐乐餐厅<0D0A><1B6100><1D2100><0D0A>顾客昵称：何先生<0D0A>联系电话：15884975988<0D0A>配送地址：佛山科学技术学院<0D0A>订单详情：<0D0A>辣子鸡丁 X 1	 ￥28.00<0D0A>水煮鱼   X 1	 ￥68.00<0D0A>米饭     X 1	 ￥2.00<0D0A>热干面   X 1	 ￥6.00<0D0A>烧饼     X 1	 ￥5.00<0D0A>可乐     X 1	 ￥5.00<0D0A>水果沙拉 X 1	 ￥22.00<0D0A>小皮蛋   X 1	 ￥16.00<0D0A>总计：￥152.00元<0D0A>备注：不要加辣，多点饭<0D0A><0D0A><1B40><1B6101><1D4800><1D7703><1D68FF><1D6B430C>012345678901<0D0A>0123456789012<0D0A><1B2A>http://fsxixun.taobao.com<1B2A><1B2AD><1B40><1B40><1D2101><1B6101>请各位关注喜乐乐餐厅<0D0A>http://fsxixun.taobao.com<0D0A><1B6100><1D2100><0D0A><0D0A><0D0A><0D0A><0D0A><0D0A><1D5642000A0A><1B2AD>
     */
    private static String buildShopOrderPrintContent(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean havePrice, String url, Boolean full) {

        getChannelValue(shopOrderPrintContent, sb, Boolean.TRUE);
        sb.append("<BR>");
//        sb.append("<C>");
        /*if (null != shopOrderPrintContent.getOrderType()) {
            switch (shopOrderPrintContent.getOrderType()) {
                case "SCAN_CODE":
                    sb.append("扫码点餐");
                    break;
                case "TO_THE_STORE":
                    sb.append("到店消费");
                    break;
                case "PICK_UP":
                    sb.append("外卖自取");
                    break;
                case "DELIVERY_TO_HOME":
                    sb.append("快递配送");
                    break;
            }
        }*/
        /*if (!shopOrderPrintContent.getOrderType().equals(ORDER_TYPE_NET_ORDER)) {
            sb.append("#");
            sb.append(shopOrderPrintContent.getDaySn());
            sb.append("</C>");
        } else {*/
        sb.append("<C>");
        sb.append(shopOrderPrintContent.getShopName());
        sb.append("</C>").append("<BR>");
//        }
        if (full) {
            if (!shopOrderPrintContent.getOrderType().equals("DELIVERY_TO_HOME")) {
                if (!shopOrderPrintContent.getOrderType().equals("SCAN_CODE_PAY_LATER") && !shopOrderPrintContent.getOrderType().equals("SCAN_CODE") && !shopOrderPrintContent.getOrderType().equals("TO_THE_STORE")) {
                    sb.append("--------------------------------");
                    if (shopOrderPrintContent.getOrderType().equals(ORDER_TYPE_NET_ORDER)) {
                        sb.append("<BOLD>期望送达时间：");
                        if (!shopOrderPrintContent.getReceiveDate().equals("尽快送达")) {
                            sb.append("<BR>");
                        }
                        sb.append(shopOrderPrintContent.getReceiveDate() + "</BOLD><BR>");
                    } else {
                        sb.append("<BOLD>预定时间：");
                        sb.append(shopOrderPrintContent.getReceiveDate().equals("尽快送达") ? "尽快备餐<BR>" : shopOrderPrintContent.getReceiveDate() + "</BOLD><BR>");
                    }

                    if (StringUtils.isNotBlank(shopOrderPrintContent.getNotice())) {
                        sb.append("备注：" + shopOrderPrintContent.getNotice() + "<BR>");
                        sb.append("--------------------------------");
                        sb.append("<BR>");
                    } else {
                        sb.append("--------------------------------");
                        sb.append("<BR>");
                    }
                }
            }
        } else {
            if (StringUtils.isNotBlank(shopOrderPrintContent.getNotice())) {
                sb.append("备注：" + shopOrderPrintContent.getNotice() + "<BR>");
                sb.append("--------------------------------");
                sb.append("<BR>");
            }
        }

       /* if (shopOrderPrintContent.getReceiveDate() != null) {
            String prefixName = "送  达：";
            String receiveDate = shopOrderPrintContent.getReceiveDate();
            if (!ORDER_TYPE_NET_ORDER.equalsIgnoreCase(shopOrderPrintContent.getOrderType())) {
                prefixName = "到店用餐：";
                receiveDate = "尽快送达".equals(receiveDate) ? "尽快备餐" : receiveDate;
            }
            sb.append(prefixName).append(receiveDate);
            sb.append("<BR>");
        }*/
        /*if (null != shopOrderPrintContent.getSlogan()) {
            sb.append("--------------------------------").append("<BR>");
            sb.append("<C>");
            sb.append(shopOrderPrintContent.getSlogan());
            sb.append("</C><BR>");
            sb.append("--------------------------------").append("<BR>");
        }*/
        if (shopOrderPrintContent.getOrderType().equals("SCAN_CODE") || shopOrderPrintContent.getOrderType().equals("SCAN_CODE_PAY_LATER")) {
            sb.append("--------------------------------");
            sb.append("<BOLD>");
            sb.append("桌号:" + shopOrderPrintContent.getTableName());

            sb.append("     餐号:" + shopOrderPrintContent.getMealNumber());

            sb.append("    人数:" + shopOrderPrintContent.getPeopleNum());
            sb.append("</BOLD>");
            sb.append("<BR>");
            sb.append("--------------------------------").append("<BR>");
        }
        if (shopOrderPrintContent.getOrderType().equals("TO_THE_STORE")) {
            sb.append("<BOLD>");
            setOrderDish2(shopOrderPrintContent, sb, havePrice);
            sb.append("</BOLD>");
        } else {
            sb.append("<BOLD>");
            setOrderDish(shopOrderPrintContent, sb, havePrice);
            sb.append("</BOLD>");
        }
        if (!full) {
            return sb.toString();
        }
        if (!shopOrderPrintContent.getOrderType().equals("TO_THE_STORE")) {
            sb.append("--------------------------------").append("<BR>");
        }
        if (shopOrderPrintContent.getOrderType().equals("SCAN_CODE") || shopOrderPrintContent.getOrderType().equals("SCAN_CODE_PAY_LATER")) {
            if (shopOrderPrintContent.getTableFee() != null) {
                TableFee tableFee = new Gson().fromJson(shopOrderPrintContent.getTableFee(), new TypeToken<TableFee>() {
                }.getType());
                if (tableFee.getFeeStatus().equals(1) && !(tableFee.getTotalFee().doubleValue() == 0)) {
                    sb.append("桌台费：" + tableFee.getFee().doubleValue() + "/桌");
                    sb.append("            ");
                    sb.append(tableFee.getTotalFee().doubleValue() + "<BR>");
                    sb.append("--------------------------------").append("<BR>");
                }
                if (tableFee.getFeeStatus().equals(2) && !(tableFee.getTotalFee().doubleValue() == 0)) {
                    sb.append("桌台费：" + tableFee.getFee().doubleValue() + "/人");
                    sb.append("              ");
                    sb.append(tableFee.getTotalFee().doubleValue() + "<BR>");
                    sb.append("--------------------------------").append("<BR>");
                }
            }

        }

        if (havePrice) {
            if (shopOrderPrintContent.getPackFee() != null && !shopOrderPrintContent.getPackFee().equals("0.0")) {
                sb.append("餐盒费：");
                sb.append("                   ");
                sb.append(shopOrderPrintContent.getPackFee()).append("<BR>");

            }
            if (shopOrderPrintContent.getShippingFee() != null && !shopOrderPrintContent.getShippingFee().equals("0.0")) {
                sb.append("配送费：");
                sb.append("                   ");
                sb.append(shopOrderPrintContent.getShippingFee()).append("<BR>");
                sb.append("--------------------------------").append("<BR>");
            }
            if (!shopOrderPrintContent.getOrderType().equals("TO_THE_STORE")) {
                Double d = Double.valueOf(shopOrderPrintContent.getActivityTotal() == null ? "0" : shopOrderPrintContent.getActivityTotal()) + Double.valueOf(shopOrderPrintContent.getTotal());
                sb.append("消费合计：");
                sb.append("                 ");
                sb.append(d.toString()).append("<BR>");
                if (shopOrderPrintContent.getActivityTotal() != null && !shopOrderPrintContent.getActivityTotal().equals("0.0")) {
                    sb.append("优  惠：");
                    sb.append("                  ");
                    sb.append("-" + shopOrderPrintContent.getActivityTotal()).append("<BR>");
                }
                sb.append("实际付款：");
                sb.append("                 ");
                sb.append("<BOLD>" + shopOrderPrintContent.getTotal()).append("</BOLD>").append("<BR>");
            }

        }

        if (!shopOrderPrintContent.getOrderType().equals(ORDER_TYPE_NET_ORDER) && shopOrderPrintContent.getNotice() != null && !shopOrderPrintContent.getNotice().trim().isEmpty()) {
            sb.append("--------------------------------");
            sb.append("备注：");
            sb.append(shopOrderPrintContent.getNotice());
            sb.append("<BR>");
        }

        if (ORDER_TYPE_NET_ORDER.equalsIgnoreCase(shopOrderPrintContent.getOrderType()) || "DELIVERY_TO_HOME".equalsIgnoreCase(shopOrderPrintContent.getOrderType())) {
            sb.append("--------------------------------");

            if (ORDER_TYPE_NET_ORDER.equalsIgnoreCase(shopOrderPrintContent.getOrderType())) {
                sb.append("地  址：").append(shopOrderPrintContent.getUserAddress()).append("<BR>");
                sb.append("点餐人：");
            }
            if ("DELIVERY_TO_HOME".equalsIgnoreCase(shopOrderPrintContent.getOrderType())) {
                sb.append("收件地址：").append(shopOrderPrintContent.getUserAddress()).append("<BR>");
                sb.append("收件人：");
            }
            sb.append(shopOrderPrintContent.getUserConsignee() + "  " + shopOrderPrintContent.getUserMobile()).append("<BR>");
        }
        sb.append("--------------------------------");
        sb.append("会员号：").append(shopOrderPrintContent.getConsumerId()).append("<BR>");
        sb.append("结账时间：").append(shopOrderPrintContent.getOrderDate()).append("<BR>");
        sb.append("订单编号：").append(shopOrderPrintContent.getShopOrderSn()).append("<BR>");
        if (StringUtils.isNotBlank(shopOrderPrintContent.getPaymentOrderCode())) {
            sb.append("交易单号：").append(shopOrderPrintContent.getPaymentOrderCode()).append("<BR>");
        }
        String type = null;
        if (shopOrderPrintContent.getPayWay() == null || shopOrderPrintContent.getPayWay().equals(0) || shopOrderPrintContent.getPayWay().equals(2)) {
            type = "微信";
        } else if (shopOrderPrintContent.getPayWay().equals(1)) {
            type = "支付宝";
        } else if (shopOrderPrintContent.getPayWay().equals(3)) {
            type = "银行卡";
        } else if (shopOrderPrintContent.getPayWay().equals(4)) {
            type = "余额";
        } else if (shopOrderPrintContent.getPayWay().equals(5)) {
            type = "免支付";
        } else if (shopOrderPrintContent.getPayWay().equals(6)) {
            type = "储值卡支付";
        } else if (shopOrderPrintContent.getPayWay().equals(10)) {
            type = "聚合支付";
        }
        sb.append("付款方式：").append(type == null ? "线上付款" : type).append("<BR>");
        sb.append("<BR>");

        if (StringUtils.isNotBlank(url)) {
            Result imgUrl = QR2CodeUtil.zxingCodeAnalyze(url);
            if (imgUrl != null) {
                sb.append("<QR>").append(imgUrl.getText()).append("</QR>");
                sb.append("<C>扫码关注公众号</C>");
                sb.append("<C>了解更多门店活动</C><BR>");
            }
        }
        sb.append("<C>成都掌控者网络科技有限公司</C>");
        sb.append("<C>提供技术支持</C>");
        sb.append("<CUT>");
        return sb.toString();
    }

    /**
     * 设置菜品
     *
     * @param shopOrderPrintContent
     * @param havePrice
     * @param sb
     */
    private static void setOrderDish(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean havePrice) {
        sb.append("菜品名");
        sb.append("         单价  ");
        sb.append("数量 ");

        if (havePrice) {
            sb.append("小计");
        }
        sb.append("<BR>");
        sb.append("--------------------------------");
        sb.append("<BR>");
        for (ShopOrderPrintContent.Product item : shopOrderPrintContent.getProductList()) {
            getOrder(item, 14, 6, 3, 6, sb);
        }
    }

    /**
     * 设置菜品
     *
     * @param shopOrderPrintContent
     * @param havePrice
     * @param sb
     */
    private static void setOrderDish2(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean havePrice) {
        /*sb.append("菜品");

        sb.append("           数量         ");

        if (havePrice) {
            sb.append("价格");
        }
        sb.append("<BR>");
        sb.append("--------------------------------");*/
//        sb.append("<BR>");
        Boolean state = Boolean.FALSE;
        sb.append("--------------------------------");
        for (ShopOrderPrintContent.Product item : shopOrderPrintContent.getProductList()) {
            if ("3".equals(item.getType())) {
                sb.append("<B>" + item.getName() + "</B><BR>");
                continue;
            }
            state = formatProduct(item, sb, havePrice, state);
            if ("1".equals(item.getType())) {
                if (shopOrderPrintContent.getOrderType().equals("TO_THE_STORE")) {
                    sb.append("--------------------------------");
                    Double d = Double.valueOf(shopOrderPrintContent.getActivityTotal() == null ? "0" : shopOrderPrintContent.getActivityTotal()) + Double.valueOf(shopOrderPrintContent.getTotal());
                    sb.append("消费合计：");
                    sb.append("                 ");
                    sb.append(d.toString()).append("<BR>");
                    if (shopOrderPrintContent.getActivityTotal() != null && !shopOrderPrintContent.getActivityTotal().equals("0.0")) {
                        sb.append("优  惠：");
                        sb.append("                  ");
                        sb.append("-" + shopOrderPrintContent.getActivityTotal()).append("<BR>");
                    }
                    sb.append("实际付款：");
                    sb.append("                 ");
                    sb.append("<BOLD>" + shopOrderPrintContent.getTotal()).append("</BOLD>").append("<BR>");
                }
            }
        }
       /* shopOrderPrintContent.getProductList().forEach(item -> {
            state = formatProduct(item, sb, havePrice,state);
        });*/

    }

    /**
     * 格式化菜品
     *
     * @param product
     * @return
     */
    private static Boolean formatProduct(ShopOrderPrintContent.Product product, StringBuilder sb, Boolean havePrice, Boolean state) {
        Integer maxLength = 16;
        Integer nonChineseNum = 0;
        String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。, ，、？]";
        String productString = Pattern.compile(regEx).matcher(product.getName()).replaceAll("").trim();
        int countString = product.getName().length() - productString.length();
        Integer nameLength = productString.length() + countString / 2;
        if ("1".equals(product.getType())) {
            state = Boolean.FALSE;
        } else {
            if (!state) {
                sb.append("-----------套餐详情------------");
                sb.append("<BR>");
                sb.append("菜品名");
                sb.append("           单价       ");
                sb.append("数量");
                state = Boolean.TRUE;
            }
        }
        sb.append(product.getName());

        char[] chars = product.getName().toCharArray();

//        判断每个字符
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 48 && chars[i] <= 57) || (chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)) {
                nonChineseNum++;
            }
        }

        if ((nameLength - nonChineseNum + nonChineseNum / 2) > maxLength / 2) {
            sb.append("<BR>");
        } else {
            for (int i = 0; i < maxLength / 2 - (nameLength - nonChineseNum + nonChineseNum / 2); i++) {
                sb.append("  ");
            }
        }
        sb.append("<RIGHT>");
        if (havePrice) {
            sb.append(product.getPrice());
        }
        sb.append("        ");
        sb.append("X");
        sb.append(product.getNum());
        sb.append("</RIGHT>");
        if (state) {
            sb.append("<BR>");
        }
        return state;
    }

    /**
     * 获取渠道信息
     *
     * @param shopOrderPrintContent
     * @param sb
     * @param big
     */
    private static void getChannelValue(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean big) {

        if (null != shopOrderPrintContent.getOrderSource()) {
            String source;
            switch (shopOrderPrintContent.getOrderSource()) {
                case ELEME:
                    source = "饿了么";
                    break;
                case MEITUAN:
                    source = "美团";
                    break;
                case DIDI:
                    source = "滴滴";
                    break;
                case BAIDU:
                    source = "百度";
                    break;
                default:
                    source = shopOrderPrintContent.getShopName();
                    break;
            }
            /*if (shopOrderPrintContent.getOrderType().equals(ORDER_TYPE_NET_ORDER)) {
                source = "外卖";
            }*/
            if (null != shopOrderPrintContent.getOrderType()) {
                switch (shopOrderPrintContent.getOrderType()) {
                    case "NETWORK":
                        source = "外卖";
                        break;
                    case "SCAN_CODE":
                        source = "扫码点餐";
                        break;
                    case "SCAN_CODE_PAY_LATER":
                        source = "扫码点餐";
                        break;
                    case "TO_THE_STORE":
                        source = "到店消费";
                        break;
                    case "PICK_UP":
                        source = "外卖自取";
                        break;
                    case "DELIVERY_TO_HOME":
                        source = "快递配送";
                        break;
                }
            }
            if (big) {
                sb.append("<CB>");
                sb.append(source);
                if (shopOrderPrintContent.getOrderType() != null) {
                    if (shopOrderPrintContent.getDaySn() != null && !shopOrderPrintContent.getDaySn().equals("0")) {
                        sb.append("#");
                        sb.append(shopOrderPrintContent.getDaySn());
                    }
                }
                sb.append("</CB>");
            } else {
                sb.append("<CB>");
                sb.append(source);
                sb.append("#");
                sb.append(shopOrderPrintContent.getDaySn()).append("</CB>");
            }
        } else {
            //shopOrderPrintContent.getOrderSource() 可能是自营渠道
            if (big) {
                sb.append("<CB>");
                sb.append("#");
                sb.append(shopOrderPrintContent.getDaySn());
                sb.append("</CB>");
            } else {
                sb.append("<CB>");
                sb.append("#");
                sb.append(shopOrderPrintContent.getDaySn()).append("</CB>");
            }
        }
    }

    private void PrintUtil() {
    }

    public static void getOrder(ShopOrderPrintContent.Product product, int b1, int b2, int b3, int b4, StringBuilder sb) {
        String title = product.getName();
        String price = product.getPrice();
        String num = product.getNum();
        String total = product.getTotal();
        price = addSpace(price, b2);
        num = addSpace(num, b3);
        total = addSpace(total, b4);
        String otherStr = " " + price + "X" + num + " " + total;

        int tl = 0;
        try {
            tl = title.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int spaceNum = (tl / b1 + 1) * b1 - tl;
        if (tl < b1) {
            for (int k = 0; k < spaceNum; k++) {
                title += " ";
            }
            title += otherStr;
        } else if (tl == b1) {
            title += otherStr;
        } else {
            List<String> list = null;
            if (isEn(title)) {
                list = getStrList(title, b1);
            } else {
                list = getStrList(title, b1 / 2);
            }
            String s0 = titleAddSpace(list.get(0));
            title = s0 + otherStr + "<BR>";// 添加 单价 数量 总额
            String s = "";
            for (int k = 1; k < list.size(); k++) {
                s += list.get(k);
            }
            try {
                s = getStringByEnter(b1, s);
            } catch (Exception e) {
                e.printStackTrace();
            }
            title += s;
        }
        sb.append(title + "<BR>");
    }

    public static String titleAddSpace(String str) {
        int k = 0;
        int b = 14;
        try {
            k = str.getBytes("GBK").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < b - k; i++) {
            str += " ";
        }
        return str;
    }

    public static String getStringByEnter(int length, String string) throws Exception {
        for (int i = 1; i <= string.length(); i++) {
            if (string.substring(0, i).getBytes("GBK").length > length) {
                return string.substring(0, i - 1) + "<BR>" + getStringByEnter(length, string.substring(i - 1));
            }
        }
        return string;
    }

    public static String addSpace(String str, int size) {
        int len = str.length();
        if (len < size) {
            for (int i = 0; i < size - len; i++) {
                str += " ";
            }
        }
        return str;
    }

    public static Boolean isEn(String str) {
        Boolean b = false;
        try {
            b = str.getBytes("GBK").length == str.length();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static List<String> getStrList(String inputString, int length) {
        int size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        return getStrList(inputString, length, size);
    }

    public static List<String> getStrList(String inputString, int length, int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = substring(inputString, index * length, (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

    public static String substring(String str, int f, int t) {
        if (f > str.length())
            return null;
        if (t > str.length()) {
            return str.substring(f, str.length());
        } else {
            return str.substring(f, t);
        }
    }
}
