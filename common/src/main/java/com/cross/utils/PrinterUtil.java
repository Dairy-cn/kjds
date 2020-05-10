package com.cross.utils;


import com.alibaba.fastjson.JSONObject;
import com.cross.result.PrinterResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*************************************************************
 * Description: 飞鹅自动打印机方法调用工具类
 * Author: Dairy
 * CreateTime: 2019/6/17
 * Copyright © 成都通吃岛科技有限公司 All right reserved
 ************************************************************/

@Slf4j
public class PrinterUtil {
    
    /**
     * 打印
     *
     * @param url
     * @param user
     * @param printNum
     * @param ukey
     * @param sn
     * @param content
     * @return
     */
    public static boolean print(String url, String user, String printNum, String ukey, String sn, String content) {
        //标签说明：
        //单标签:
        //"<BR>"为换行,"<CUT>"为切刀指令(主动切纸,仅限切刀打印机使用才有效果)
        //"<LOGO>"为打印LOGO指令(前提是预先在机器内置LOGO图片),"<PLUGIN>"为钱箱或者外置音响指令
        //成对标签：
        //"<CB></CB>"为居中放大一倍,"<B></B>"为放大一倍,"<C></C>"为居中,<L></L>字体变高一倍
        //<W></W>字体变宽一倍,"<QR></QR>"为二维码,"<BOLD></BOLD>"为字体加粗,"<RIGHT></RIGHT>"为右对齐
        //拼凑订单内容时可参考如下格式
        //根据打印纸张的宽度，自行调整内容的格式，可参考下面的样例格式
        
        //通过POST请求，发送打印信息到服务器
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(30000)//读取超时
            .setConnectTimeout(30000)//连接超时
            .build();
        
        CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();
        
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("user", user));
        String STIME = String.valueOf(System.currentTimeMillis() / 1000);
        nvps.add(new BasicNameValuePair("stime", STIME));
        nvps.add(new BasicNameValuePair("sig", signature(user, ukey, STIME)));
        nvps.add(new BasicNameValuePair("apiname", "Open_printMsg"));//固定值,不需要修改
        nvps.add(new BasicNameValuePair("sn", sn));
        nvps.add(new BasicNameValuePair("content", content));
        nvps.add(new BasicNameValuePair("times", printNum));//打印联数
        
        CloseableHttpResponse response = null;
        String result = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            response = httpClient.execute(post);
            int statecode = response.getStatusLine().getStatusCode();
            if (statecode == 200) {
                HttpEntity httpentity = response.getEntity();
                if (httpentity != null) {
                    //服务器返回的JSON字符串，建议要当做日志记录起来
                    result = EntityUtils.toString(httpentity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                post.abort();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrinterResult printerPrintOrGetStatusResult = JSONObject.parseObject(result, PrinterResult.class);
        log.info("打印结果：" + printerPrintOrGetStatusResult.toString());
        return printerPrintOrGetStatusResult.getRet().equals(0);
        
    }
    
    /**
     * 添加打印机到服务商
     *
     * @param url
     * @param user
     * @param uKey
     * @param snlist
     * @return
     */
    public static boolean addPrinter(String url, String user, String uKey, String snlist, String key, String tag) {
        
        //通过POST请求，发送打印信息到服务器
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(30000)//读取超时
            .setConnectTimeout(30000)//连接超时
            .build();
        
        CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();
        
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("user", user));
        String STIME = String.valueOf(System.currentTimeMillis() / 1000);
        nvps.add(new BasicNameValuePair("stime", STIME));
        nvps.add(new BasicNameValuePair("sig", signature(user, uKey, STIME)));
        nvps.add(new BasicNameValuePair("apiname", "Open_printerAddlist"));//固定值,不需要修改
        nvps.add(new BasicNameValuePair("printerContent", snlist + "#" + key + "#" + tag));
        
        CloseableHttpResponse response = null;
        String result = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            response = httpClient.execute(post);
            int statecode = response.getStatusLine().getStatusCode();
            if (statecode == 200) {
                HttpEntity httpentity = response.getEntity();
                if (httpentity != null) {
                    result = EntityUtils.toString(httpentity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                post.abort();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrinterResult printerAddOrDeleteResult = JSONObject.parseObject(result, PrinterResult.class);
        log.info("添加打印结果：" + printerAddOrDeleteResult.toString());
        
        return printerAddOrDeleteResult.getRet() == 0;
    }
    
    
    /**
     * 查询打印机状态
     *
     * @param url
     * @param user
     * @param uKey
     * @param sn
     * @return
     */
    public static boolean queryPrinterStatus(String url, String user, String uKey, String sn) {
        
        //通过POST请求，发送打印信息到服务器
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(30000)//读取超时
            .setConnectTimeout(30000)//连接超时
            .build();
        
        CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();
        
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("user", user));
        String STIME = String.valueOf(System.currentTimeMillis() / 1000);
        nvps.add(new BasicNameValuePair("stime", STIME));
        nvps.add(new BasicNameValuePair("sig", signature(user, uKey, STIME)));
        nvps.add(new BasicNameValuePair("apiname", "Open_queryPrinterStatus"));//固定值,不需要修改
        nvps.add(new BasicNameValuePair("sn", sn));
        
        CloseableHttpResponse response = null;
        String result = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            response = httpClient.execute(post);
            int statecode = response.getStatusLine().getStatusCode();
            if (statecode == 200) {
                HttpEntity httpentity = response.getEntity();
                if (httpentity != null) {
                    //服务器返回
                    result = EntityUtils.toString(httpentity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                post.abort();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PrinterResult printerPrintOrGetStatusResult = JSONObject.parseObject(result, PrinterResult.class);
        log.info("获取打印机结果：" + printerPrintOrGetStatusResult.toString());
        return printerPrintOrGetStatusResult.getRet() == 0;
        
    }
    
    
    /**
     * 删除打印机
     *
     * @param url
     * @param user
     * @param uKey
     * @param sn
     * @return
     */
    public static boolean deletePrinter(String url, String user, String uKey, String sn) {
        
        //通过POST请求，发送打印信息到服务器
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(30000)//读取超时
            .setConnectTimeout(30000)//连接超时
            .build();
        
        CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();
        
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("user", user));
        String STIME = String.valueOf(System.currentTimeMillis() / 1000);
        nvps.add(new BasicNameValuePair("stime", STIME));
        nvps.add(new BasicNameValuePair("sig", signature(user, uKey, STIME)));
        nvps.add(new BasicNameValuePair("apiname", "Open_printerDelList"));//固定值,不需要修改
        nvps.add(new BasicNameValuePair("snlist", sn));
        
        CloseableHttpResponse response = null;
        String result = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            response = httpClient.execute(post);
            int statecode = response.getStatusLine().getStatusCode();
            if (statecode == 200) {
                HttpEntity httpentity = response.getEntity();
                if (httpentity != null) {
                    //服务器返回
                    result = EntityUtils.toString(httpentity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                post.abort();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        PrinterResult printerAddOrDeleteResult = JSONObject.parseObject(result, PrinterResult.class);
        log.info("删除打印机结果：" + printerAddOrDeleteResult.toString());
        return printerAddOrDeleteResult.getRet() == 0;
        
    }
    
    
    /**
     * 修改打印机信息
     *
     * @param url
     * @param user
     * @param uKey
     * @param sn
     * @return
     */
    
    
    public static Map<String, Object> updatePrinter(String url, String user, String uKey, String sn, String tag) {
        
        //通过POST请求，发送打印信息到服务器
        RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(30000)//读取超时
            .setConnectTimeout(30000)//连接超时
            .build();
        
        CloseableHttpClient httpClient = HttpClients.custom()
            .setDefaultRequestConfig(requestConfig)
            .build();
        
        HttpPost post = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("user", user));
        String STIME = String.valueOf(System.currentTimeMillis() / 1000);
        nvps.add(new BasicNameValuePair("stime", STIME));
        nvps.add(new BasicNameValuePair("sig", signature(user, uKey, STIME)));
        nvps.add(new BasicNameValuePair("apiname", "Open_printerEdit"));//固定值,不需要修改
        nvps.add(new BasicNameValuePair("sn", sn));
        nvps.add(new BasicNameValuePair("name", tag));
        
        CloseableHttpResponse response = null;
        String result = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            response = httpClient.execute(post);
            int statecode = response.getStatusLine().getStatusCode();
            if (statecode == 200) {
                HttpEntity httpentity = response.getEntity();
                if (httpentity != null) {
                    //服务器返回
                    result = EntityUtils.toString(httpentity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                post.abort();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        PrinterResult printerAddOrDeleteResult = JSONObject.parseObject(result, PrinterResult.class);
        log.info("更新打印机结果：" + printerAddOrDeleteResult.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("status", printerAddOrDeleteResult.getRet() == 0);
        map.put("msg", printerAddOrDeleteResult);
    
        return map;
        
    }
    
    /**
     * 生成签名字符串
     *
     * @param user
     * @param uKey
     * @param STIME
     * @return
     */
    private static String signature(String user, String uKey, String STIME) {
        String s = DigestUtils.sha1Hex(user + uKey + STIME);
        return s;
    }
    
    
    public static void main(String[] args) {
        String content;
        content = "<CB>测试打印</CB><BR>";
        content += "名称　　　　　 单价  数量 金额<BR>";
        content += "--------------------------------<BR>";
        content += "饭　　　　　　 1.0    1   1.0<BR>";
        content += "炒饭　　　　　 10.0   10  10.0<BR>";
        content += "蛋炒饭　　　　 10.0   10  100.0<BR>";
        content += "鸡蛋炒饭　　　 100.0  1   100.0<BR>";
        content += "番茄蛋炒饭　　 1000.0 1   100.0<BR>";
        content += "西红柿蛋炒饭　 1000.0 1   100.0<BR>";
        content += "西红柿鸡蛋炒饭 100.0  10  100.0<BR>";
        content += "备注：加辣<BR>";
        content += "--------------------------------<BR>";
        content += "合计：xx.0元<BR>";
        content += "送货地点：广州市南沙区xx路xx号<BR>";
        content += "联系电话：13888888888888<BR>";
        content += "订餐时间：2016-08-08 08:08:08<BR>";
        content += "<QR>http://www.dzist.com</QR>";
//        USER: 2038453022@qq.com
//        UKEY: 2rauugswq99yPFcc
        boolean flag = PrinterUtil.addPrinter("http://api.feieyun.cn/Api/Open/", "2038453022@qq.com", "2rauugswq99yPFcc", "920509973", "zen3y4vy", "测试打印机");
//        boolean flag =   PrinterUtil.print("http://api.feieyun.cn/Api/Open/", "2038453022@qq.com", "1", "2rauugswq99yPFcc", "920509973", content);
//        boolean flag=PrintUtil.deletePrinter("http://api.feieyun.cn/Api/Open/", "2997266712@qq.com", "S3ZUDNYEk6gEfKVY", "920509973");
//        boolean flag = PrintUtil.updatePrinter("http://api.feieyun.cn/Api/Open/", "2997266712@qq.com", "S3ZUDNYEk6gEfKVY", "920509973", "测试打印机222222222222222222222222222");
        
        System.out.println(flag);
    }
    
    
}
