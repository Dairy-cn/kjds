//package com.hpkj.utils;
//
//import com.hpkj.enumtype.PrintTypeNums;
//import com.hpkj.model.MerchantPrinterModel;
//import com.hpkj.model.ShopOrderPrintContent;
//import com.hpkj.model.enumeration.OrderType;
//
///**
// * @Author DuYuLiang on 2017/11/10.
// */
//public class PrintUtil {
//
//    private static String ORDER_TYPE_NET_ORDER = "NETWORK";
//
//    public static String buildContent(ShopOrderPrintContent shopOrderPrintContent, MerchantPrinterModel merchantPrinterModel) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("<1B40><1B40><1B40>");
//        //1 后厨 2 前台
//        if(PrintTypeNums.FRONTDESK.getMsg().equals(merchantPrinterModel.getType())){
//            buildShopOrderPrintContent(shopOrderPrintContent, sb, merchantPrinterModel.isPrintPrice());
//        }else if(PrintTypeNums.FRONTDESK.getMsg().equals(merchantPrinterModel.getType())){
//                    sb.append("<1B6100><1D2100>");
//                    setOrderDish(shopOrderPrintContent, sb, merchantPrinterModel.isPrintPrice());
//        }
//
//        sb.append("<0D0A><0D0A><0D0A><0D0A><0D0A><0D0A>");
//        sb.append("<1B2A><1B2A><1B2A><1B2AD><1B40><1B40><1D2101><1B6101><0D0A><0D0A><1D5642000A0A><1B2AD>");
//        return sb.toString();
//    }
//
//    /**
//     * <1B40><1B40><1B40><1D2111><1B6101>喜乐乐餐厅<0D0A><1B6100><1D2100><0D0A>顾客昵称：何先生<0D0A>联系电话：15884975988<0D0A>配送地址：佛山科学技术学院<0D0A>订单详情：<0D0A>辣子鸡丁 X 1	 ￥28.00<0D0A>水煮鱼   X 1	 ￥68.00<0D0A>米饭     X 1	 ￥2.00<0D0A>热干面   X 1	 ￥6.00<0D0A>烧饼     X 1	 ￥5.00<0D0A>可乐     X 1	 ￥5.00<0D0A>水果沙拉 X 1	 ￥22.00<0D0A>小皮蛋   X 1	 ￥16.00<0D0A>总计：￥152.00元<0D0A>备注：不要加辣，多点饭<0D0A><0D0A><1B40><1B6101><1D4800><1D7703><1D68FF><1D6B430C>012345678901<0D0A>0123456789012<0D0A><1B2A>http://fsxixun.taobao.com<1B2A><1B2AD><1B40><1B40><1D2101><1B6101>请各位关注喜乐乐餐厅<0D0A>http://fsxixun.taobao.com<0D0A><1B6100><1D2100><0D0A><0D0A><0D0A><0D0A><0D0A><0D0A><1D5642000A0A><1B2AD>
//     */
//    private static String buildShopOrderPrintContent(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean havePrice) {
//
//        getChannelValue(shopOrderPrintContent, sb, Boolean.TRUE);
//        sb.append("<1D2100><1B6101>");
//
//        if (null != shopOrderPrintContent.getOrderType() ){
//            switch (shopOrderPrintContent.getOrderType()){
//                case "NETWORK":
//                    sb.append("外卖配送").append("<0D0A>");
//                    break;
//
//                case "EATNOW":
//                    sb.append("预约堂食").append("<0D0A>");
//                    break;
//
//                case "PICK_UP":
//                    sb.append("外卖自取").append("<0D0A>");
//                    break;
//            }
//        }
//
//        sb.append(shopOrderPrintContent.getShopName());
//
//        if (null != shopOrderPrintContent.getSlogan()) {
//            sb.append("<0D0A>").append("--------------------------------").append("<0D0A>");
//            sb.append("<1D2101><1B6101>");
//            sb.append(shopOrderPrintContent.getSlogan());
//            sb.append("<1D2100><0D0A><1B6100>");
//            sb.append("--------------------------------").append("<0D0A>");
//        }
//
//        if (shopOrderPrintContent.getReceiveDate() != null) {
//            String prefixName = "送  达：" ;
//            String receiveDate = shopOrderPrintContent.getReceiveDate();
//            if(!shopOrderPrintContent.getOrderType().equalsIgnoreCase(ORDER_TYPE_NET_ORDER)){
//                prefixName = "到店用餐：";
//                receiveDate = "尽快送达".equals(receiveDate) ? "尽快备餐" : receiveDate;
//            }
//            sb.append(prefixName).append(receiveDate);
//            sb.append("<0D0A>");
//        }
//
//        if (shopOrderPrintContent.getOrderType().equalsIgnoreCase(ORDER_TYPE_NET_ORDER)) {
//            sb.append("订餐人：").append(shopOrderPrintContent.getUserConsignee()).append("<0D0A>");
//            sb.append("电  话：").append(shopOrderPrintContent.getUserMobile()).append("<0D0A>");
//        } else {
//            sb.append("电  话：").append(shopOrderPrintContent.getUserMobile()).append("<0D0A>");
//        }
//
//        sb.append("单  号：").append(shopOrderPrintContent.getShopOrderSn()).append("<0D0A>");
//        sb.append("时  间：").append(shopOrderPrintContent.getOrderDate()).append("<0D0A>");
//
//        if (shopOrderPrintContent.getOrderType().equalsIgnoreCase(ORDER_TYPE_NET_ORDER)) {
//            sb.append("地  址：").append(shopOrderPrintContent.getUserAddress()).append("<0D0A>");
//        }
//
//        sb.append("--------------------------------");
//
//        sb.append("<1B6100><1D2100>");
//
//        setOrderDish(shopOrderPrintContent, sb, havePrice);
//
//        sb.append("<0D0A>");
//        sb.append("--------------------------------").append("<0D0A><1B6100><1D2100>");
//
//        if (havePrice) {
//            if (shopOrderPrintContent.getShippingFee() != null && !shopOrderPrintContent.getShippingFee().equals("0.0")) {
//                sb.append("配送费：+").append(shopOrderPrintContent.getShippingFee()).append("<0D0A>");
//            }
//            if (shopOrderPrintContent.getPackFee() != null && !shopOrderPrintContent.getPackFee().equals("0.0")) {
//                sb.append("打包费：+").append(shopOrderPrintContent.getPackFee()).append("<0D0A>");
//            }
//            if (shopOrderPrintContent.getActivityTotal() != null && !shopOrderPrintContent.getActivityTotal().equals("0.0")) {
//                sb.append("优  惠：-").append(shopOrderPrintContent.getActivityTotal()).append("<0D0A>");
//            }
//
//            sb.append("<1D2101><1B6102>");
//            sb.append("总计：").append(shopOrderPrintContent.getTotal()).append("<0D0A>");
//        }
//
//        if (shopOrderPrintContent.getNotice() != null && !shopOrderPrintContent.getNotice().trim().isEmpty()) {
//            sb.append("--------------------------------");
//            sb.append("<1D2101><1B6101>");
//            sb.append("备注：").append(shopOrderPrintContent.getNotice());
//            sb.append("<0D0A>");
//        }
//        return sb.toString();
//    }
//
//    /**
//     * 设置菜品
//     * @param shopOrderPrintContent
//     * @param havePrice
//     * @param sb
//     */
//    private static void setOrderDish(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean havePrice){
//        sb.append("<0D0A>菜品");
//        for(int i = 0; i < 13; i++){
//            sb.append(" ");
//        }
//        sb.append("数量");
//
//        if(havePrice){
//            sb.append("  价格");
//        }
//        sb.append("<0D0A>");
//        sb.append("--------------------------------");
//        Boolean state = Boolean.FALSE;
//        for (ShopOrderPrintContent.Product item:shopOrderPrintContent.getProductList()){
//            state = formatProduct(item, sb, havePrice,state);
//        }
//       /* shopOrderPrintContent.getProductList().forEach(item -> {
//            state = formatProduct(item, sb, havePrice,state);
//        });*/
//    }
//
//    /**
//     * 格式化菜品
//     *
//     * @param product
//     * @return
//     */
//    private static Boolean formatProduct(ShopOrderPrintContent.Product product, StringBuilder sb, Boolean havePrice,Boolean state) {
//        Integer maxLength = 10;
//        Integer nonChineseNum = 0;
//        Integer nameLength = product.getName().length();
//
//        sb.append("<0D0A>");
//        //
//        if ("1".equals(product.getType())){
//          sb.append("<1D2101>");
//          state = Boolean.FALSE;
//        }else {
//            sb.append("<1D2100>");
//            if (!state){
//                sb.append("----------套餐详情---------");
//                sb.append("<0D0A>");
//                state = Boolean.TRUE;
//            }
//        }
//        sb.append(product.getName());
//
//        char[] chars = product.getName().toCharArray();
//        //判断每个字符
//        for (int i = 0; i < chars.length; i++) {
//            if ((chars[i] >= 48 && chars[i] <= 57) || (chars[i] >= 65 && chars[i] <= 90) || (chars[i] >= 97 && chars[i] <= 122)) {
//                nonChineseNum++;
//            }
//        }
//
//        if (nameLength > maxLength) {
//            sb.append("<0D0A>");
//            for (int i = 0; i < maxLength * 2 - 3; i++) {
//                sb.append(" ");
//            }
//        } else {
//            for (int i = 0; i < (maxLength - nameLength) * 2 - 3 + nonChineseNum; i++) {
//                sb.append(" ");
//            }
//        }
//
//        sb.append(" X");
//        sb.append(product.getNum());
//
//        if (havePrice && "1".equals(product.getType())) {
//            sb.append("  ");
//            sb.append(product.getTotal());
//        }
//        return state;
//    }
//
//    /**
//     * 获取渠道信息
//     *
//     * @param shopOrderPrintContent
//     * @param sb
//     * @param big
//     */
//    private static void getChannelValue(ShopOrderPrintContent shopOrderPrintContent, StringBuilder sb, Boolean big) {
//        if (null != shopOrderPrintContent.getOrderSource()) {
//            String source;
//            switch (shopOrderPrintContent.getOrderSource()) {
//                case ELEME:
//                    source = "饿了么";
//                    break;
//                case MEITUAN:
//                    source = "美团";
//                    break;
//                case DIDI:
//                    source = "滴滴";
//                    break;
//                case BAIDU:
//                    source = "百度";
//                    break;
//                default:
//                    source = "赚餐";
//                    break;
//            }
//            if (big) {
//                sb.append("<1D2101><1B6101>");
//                sb.append(source);
//                sb.append("#");
//                sb.append(shopOrderPrintContent.getDaySn());
//                sb.append("<1D2100><0D0A><1B6100>");
//            } else {
//                sb.append("<1D2100>");
//                sb.append(source);
//                sb.append("<1B6101>#");
//                sb.append(shopOrderPrintContent.getDaySn()).append("<0D0A><1D2100><1B6100>");
//            }
//        } else {
//            //shopOrderPrintContent.getOrderSource() 可能是自营渠道
//            if (big) {
//                sb.append("#");
//                sb.append(shopOrderPrintContent.getDaySn());
//                sb.append("<1D2100><0D0A><1B6100>");
//            } else {
//                sb.append("<1B6101>#");
//                sb.append(shopOrderPrintContent.getDaySn()).append("<0D0A><1D2100><1B6100>");
//            }
//        }
//    }
//
//    private void PrintUtil() {
//    }
//}
