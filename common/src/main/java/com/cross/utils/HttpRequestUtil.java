package com.cross.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.DefaultHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shaded.org.apache.http.annotation.NotThreadSafe;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.apache.http.impl.client.HttpClients.createDefault;

/**
 * Created by DuYuLiang on 2017/6/10.
 */
public class HttpRequestUtil {

    private static final int TIME_OUT_NUM = 5000;

    private final static Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url     发送请求的URL
     * @param map     请求Map参数，请求参数应该是 {"name1":"value1","name2":"value2"}的形式。
     * @param charset 发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, Map<String, Object> map, String charset) {
        StringBuffer sb = new StringBuffer();
        //构建请求参数
        if (map != null && map.size() > 0) {
            Iterator it = map.entrySet().iterator(); //定义迭代器
            while (it.hasNext()) {
                Map.Entry er = (Map.Entry) it.next();
                sb.append(er.getKey());
                sb.append("=");
                if (er.getValue() instanceof String) {
                    try {
                        sb.append(URLEncoder.encode((String) er.getValue(), charset));
                    } catch (Exception ex) {
                        log.error("url encode error: ", ex);
                    }
                } else {
                    sb.append(er.getValue());
                }
                sb.append("&");
            }
        }
        return sendGet(url, sb.toString(), charset);
    }


    /**
     * 向指定URL发送POST方法的请求
     *
     * @param url     发送请求的URL
     * @param map     请求Map参数，请求参数应该是 {"name1":"value1","name2":"value2"}的形式。
     * @param charset 发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, Object> map, String charset) {
        StringBuffer sb = new StringBuffer();
        //构建请求参数
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> e : map.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                if (e.getValue() instanceof String) {
                    try {
                        sb.append(URLEncoder.encode((String) e.getValue(), charset));
                    } catch (Exception ex) {
                        log.error("url encode error: ", ex);
                    }
                } else {
                    sb.append(e.getValue());
                }
                sb.append("&");
            }
        }
        String sendData = sb.toString();
        log.info("send data string: {}", sendData);
        return sendPost(url, sendData, charset);
    }


    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url     发送请求的URL
     * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param charset 发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param, String charset) {
        String result = "";
        String line;
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = param != null && !param.isEmpty() ? url + "?" + param : url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setReadTimeout(TIME_OUT_NUM);
            conn.setConnectTimeout(TIME_OUT_NUM);
            InputStream inputStream = conn.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream, charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            log.debug(e.getMessage());
            log.error("发送get请求出现异常", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("close inputStream", e2);
            }
        }
        return result;
    }

    /**
     * get请求带cookie
     *
     * @param url
     * @param param
     * @param charset
     * @param cookie
     * @return
     */
    public static String sendGet(String url, String param, String charset, String cookie) {
        String result = "";
        String line;
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = param != null && !param.isEmpty() ? url + "?" + param : url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("Cookie", cookie);
            conn.setReadTimeout(TIME_OUT_NUM);
            conn.setConnectTimeout(TIME_OUT_NUM);
            //InputStream inputStream = conn.getInputStream();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            log.debug(e.getMessage());
            log.error("发送get请求出现异常", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("close inputStream");
            }
        }
        return result;
    }

    /**
     * get请求 可自定义referer
     *
     * @param url
     * @param param
     * @param charset
     * @param headers
     * @return
     */
    public static String sendGet(String url, String param, String charset, Map<String, String> headers) {
        String result = "";
        String line;
        StringBuffer sb = new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = param != null && !param.isEmpty() ? url + "?" + param : url;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            headers.forEach((key, value) -> {
                conn.setRequestProperty(key, value);
            });
            conn.setReadTimeout(TIME_OUT_NUM);
            conn.setConnectTimeout(TIME_OUT_NUM);
            //InputStream inputStream = conn.getInputStream();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            log.debug(e.getMessage());
            log.error("发送get请求出现异常", e);
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                log.error("close inputStream");
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url     发送请求的 URL
     * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param charset 发送和接收的格式
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, String charset) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String line;
        StringBuffer sb = new StringBuffer();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("content-type", charset);
            /*conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", "Basic d2ViX2FwcDo=");*/

            //设置超时时间
            conn.setConnectTimeout(TIME_OUT_NUM);
            conn.setReadTimeout(TIME_OUT_NUM);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应    设置接收格式
            in = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (Exception e) {
            log.error("发送 POST请求出现异常!", e);
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                log.error("发送 POST请求出现异常!", ex);
            }
        }
        return result;
    }

    /**
     * post 方法
     *
     * @param url
     * @param params
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, Object> params) {
        if (StringUtils.isEmpty(url) || params == null || params.isEmpty()) {
            return "";
        }

        CloseableHttpClient httpClient = createDefault();
        CloseableHttpResponse response = null;
        String result = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig
                .custom()
                .setSocketTimeout(TIME_OUT_NUM)
                .setConnectTimeout(TIME_OUT_NUM)
                .build();//设置请求和传输超时时间

            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            List<BasicNameValuePair> basicNameValuePairs = new ArrayList<>();
            for (Map.Entry<String, Object> entity : params.entrySet()) {
                basicNameValuePairs.add(new BasicNameValuePair(entity.getKey(), entity.getValue().toString()));
            }

            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(basicNameValuePairs, Consts.UTF_8);
            httpPost.setEntity(urlEncodedFormEntity);

            response = httpClient.execute(httpPost);
            StatusLine statusLine = response.getStatusLine();
            log.info(String.format("request url: %s, params: %s, response status: %s",
                url, JSON.toJSONString(params), statusLine.getStatusCode()));

            /**添加日志打印 added by wy at 20190727 start */
            if (statusLine.getStatusCode() == 404) {
                log.info("访问对端服务失败,请确认url是否正确");
            }
            /**添加日志打印 added by wy at 20190727 end */
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, Consts.UTF_8);
            log.info(String.format("response data: %s", result));

        } catch (IOException e) {
            log.error("send post request exception:{}", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("close http client failed", e);
            }
        }
        return result == null ? "" : result.trim();
    }

    public static String doPostByJson(String url, JSONObject json, String enterpriseGuid) {

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.addHeader("enterpriseGuid", enterpriseGuid);
        String response = null;
        try {
            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());
                response = result;
            }
        } catch (Exception e) {
            log.error("json请求发送失败", e);
        }
        return response;
    }

    public static String doPostByJsonNo(String url, String json,String guid) {

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        post.addHeader("enterpriseGuid", guid);
        String response = null;
        try {
            StringEntity s = new StringEntity(json, "utf-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());
                response = result;
            }
        } catch (Exception e) {
            log.error("json请求发送失败", e);
        }
        return response;
    }

    public static String doPutByJson(String url, JSONObject json, String enterpriseGuid) {

        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        HttpPut post = new HttpPut(url);
        post.addHeader("enterpriseGuid", enterpriseGuid);
        String response = null;
        try {
            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = httpclient.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());
                response = result;
            }
        } catch (Exception e) {
            log.error("json请求发送失败", e);
        }
        return response;
    }

    public static String doDeleteByJson(String url, JSONObject json, String enterpriseGuid) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(url);
        httpDelete.addHeader("enterpriseGuid", enterpriseGuid);
        String response = null;
        try {
            StringEntity s = new StringEntity(json.toString(), "utf-8");
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            httpDelete.setEntity(s);
            HttpResponse res = httpclient.execute(httpDelete);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(res.getEntity());
                response = result;
            }
        } catch (Exception e) {
            log.error("json请求发送失败", e);
        }
        return response;
    }

    @NotThreadSafe
    public static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "DELETE";

        @Override
        public String getMethod() {
            return METHOD_NAME;
        }

        public HttpDeleteWithBody(final String uri) {
            super();
            setURI(URI.create(uri));
        }

        public HttpDeleteWithBody(final URI uri) {
            super();
            setURI(uri);
        }

        public HttpDeleteWithBody() {
            super();
        }
    }

    /**
     * 带证书httpPost请求
     * @param url   接口地址
     * @param param 参数
     * @param pkSecret PKCS12的密码
     * @param fileRoute 证书地址
     * @return
     * @throws Exception
     */
    public static String sendRedEnvelope(String url, String param,String pkSecret,String fileRoute) throws Exception {
        //指定读取证书格式为PKCS12
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        //读取本机存放的PKCS12证书文件
//        FileInputStream instream = new FileInputStream(new File(fileRoute));
        //通过请求获取证书流
        URL certUrl = new URL(fileRoute);
        InputStream instream = certUrl.openStream();
        try {
            //指定PKCS12的密码
            keyStore.load(instream, pkSecret.toCharArray());
        } finally {
            instream.close();
        }
        //指定TLS版本
        SSLContext sslcontext = SSLContexts.custom()
            .loadKeyMaterial(keyStore, pkSecret.toCharArray())
            .build();
        //设置httpclient的SSLSocketFactory
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
            sslcontext,
            new String[] { "TLSv1" },
            null,
            new DefaultHostnameVerifier());
        CloseableHttpClient httpclient = HttpClients.custom()
            .setSSLSocketFactory(sslsf)
            .build();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            HttpPost httpPost = new HttpPost(url);
            InputStream is = new ByteArrayInputStream(param.getBytes("UTF-8"));
            //InputStreamEntity严格对内容和长度相匹配。用法和BasicHttpEntity类似
            InputStreamEntity inputStreamEntity = new InputStreamEntity(is, is.available());
            httpPost.setEntity(inputStreamEntity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                    entity.getContent(), "UTF-8"));
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    stringBuffer.append(inputLine);
                }
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return stringBuffer.toString();
    }


}
