package com.cross.utils;

import com.google.gson.Gson;
import com.cross.model.LoginUserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by DuYuLiang on 2017/6/6.
 */
public class CommonUtil {
    private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);
    private static final  double EARTH_RADIUS = 6378137;//赤道半径(单位m)

    private CommonUtil(){}

    public static Integer getCurrentUnixstamp(){
        return (int) (System.currentTimeMillis()/1000);
    }

    public static Long getCurrentTimeMills(){
        return System.currentTimeMillis();
    }

    public static String getRealIp(HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ip;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                if(forwarded != null){
                    forwarded = forwarded.split(",")[0];
                }
                ip = realIp + "/" + forwarded;
            }
        }
        return ip;
    }

    public static String baseDomain(HttpServletRequest request){
        StringBuilder url = new StringBuilder(request.getRequestURL());
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();
    }

    public static String getReturnMessage(String code, String message){
        return String.format("{code:\"%s\", message:\"%s\"}", code, message);
    }

    public static String getCurrentDate(){
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }

    public static void direct(String url, HttpServletResponse response){
        try {
            response.sendRedirect(url);
        }
        catch (Exception e){
            log.error("make response direct fail:", e);
        }
    }

    /**
     * 获取微服务接口URL
     *
     * @param api
     * @param request
     * @return
     */
    public static String getMicroServiceApiUrl(String api, HttpServletRequest request){
        return String.format("%s%s", CommonUtil.baseDomain(request), api);
    }

    /**
     * 生成签名摘要
     *
     * @param map
     * @param key
     * @return
     */
    public static String makeSign(SortedMap<String, String> map, String key) {
        Map<String, String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() + 1) * 10);
        SignUtils.buildPayParams(buf, params, false);
        String preStr = buf.toString();
        String sign = MD5.sign(preStr, "&key=" + key, "utf-8");
        return sign;
    }

    /**
     * 制作参数
     *
     * @author
     * @param payParams
     * @return
     */
    public static void buildParams(StringBuilder sb, Map<String, String> payParams, boolean encoding){
        List<String> keys = new ArrayList<String>(payParams.keySet());
        Collections.sort(keys);
        for(String key : keys){
            sb.append(key).append("=");
            if(encoding){
                sb.append(urlEncode(payParams.get(key)));
            }else{
                sb.append(payParams.get(key));
            }
            sb.append("&");
        }
        sb.setLength(sb.length() - 1);
    }

    /**
     * 编码URL
     *
     * @param str
     * @return
     */
    public static String urlEncode(String str){
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            log.error("url encode exception", e);
            return str;
        }
    }

    /**
     * 复制父对象到子对象
     *
     * @param parent
     * @param child
     * @return
     */
    public static Object copyParentToChild(Object parent, Object child){
        Class<?> merchantClass = parent.getClass();
        Object childVM = new Object();
        try{
            childVM = child.getClass().getConstructor(new Class[] {})
                .newInstance(new Object[] {});
        }
        catch (Exception e){
            log.error("copy parent object to child object exception", e);
        }

        Field[] fields = merchantClass.getDeclaredFields();
        for(Field field : fields){
            String name = field.getName();
            String firstLetter = name.substring(0, 1).toUpperCase();
            String getMethodName = "get" + firstLetter + name.substring(1);
            String setMethodName = "set" + firstLetter + name.substring(1);
            if(getMethodName.equalsIgnoreCase("getSerialVersionUID")){
                continue;
            }
            try{
                Method getMethod = merchantClass.getMethod(getMethodName,new Class[] {});
                Method setMethod = merchantClass.getMethod(setMethodName,new Class[] {
                    field.getType() });
                Object value = getMethod.invoke(parent, new Object[] {});

                setMethod.invoke(childVM, new Object[] { value });
            }
            catch (Exception e){
                log.error("copy attr exception", e);
            }
        }
        return childVM;
    }

    public static LoginUserModel getCurrentLoginUser(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        LoginUserModel loginUserModel = new LoginUserModel();
        loginUserModel.setId(-1L);
        try{
            OAuth2AuthenticationDetails authenticationDetails =
                (OAuth2AuthenticationDetails) authentication.getDetails();
            String[] hashToken = authenticationDetails.getTokenValue().split("\\.");
            String hashStr = hashToken[1];
            String jsonStr = new String(Base64.getDecoder().decode(hashStr.getBytes
                ("UTF-8")), "UTF-8");
            loginUserModel = (LoginUserModel) JsonUtil.jsonToBean(jsonStr, LoginUserModel.class);
        }
        catch (Exception e){
            log.error("get login Id fail:", e);
        }
        return loginUserModel;
    }

    /**
     *
     * <p>
     *
     * @description 转换javabean ,将class2中的属性值赋值给class1，如果class1属性有值，则不覆盖
     *              ，前提条件是有相同的属性名
     *              </p>
     * @param class1
     *            基准类,被赋值对象
     * @param class2
     *            提供数据的对象
     * @throws Exception
     * @author ex_dingyongbiao
     * @see
     */
    public static void converJavaBean(Object class1, Object class2) {
        try {
            Class<?> clazz1 = class1.getClass();
            Class<?> clazz2 = class2.getClass();
            // 得到method方法
            Method[] method1 = clazz1.getMethods();
            Method[] method2 = clazz2.getMethods();

            int length1 = method1.length;
            int length2 = method2.length;
            if (length1 != 0 && length2 != 0) {
                // 创建一个get方法数组，专门存放class2的get方法。
                Method[] get = new Method[length2];
                for (int i = 0, j = 0; i < length2; i++) {
                    if (method2[i].getName().indexOf("get") == 0) {
                        get[j] = method2[i];
                        ++j;
                    }
                }

                for (int i = 0; i < get.length; i++) {
                    if (get[i] == null)// 数组初始化的长度多于get方法，所以数组后面的部分是null
                        continue;
                    // 得到get方法的值，判断时候为null，如果为null则进行下一个循环
                    Object value = get[i].invoke(class2, new Object[] {});
                    if (null == value)
                        continue;
                    // 得到get方法的名称 例如：getXxxx
                    String getName = get[i].getName();
                    // 得到set方法的时候传入的参数类型，就是get方法的返回类型
                    Class<?> paramType = get[i].getReturnType();
                    Method getMethod = null;
                    try {
                        // 判断在class1中时候有class2中的get方法，如果没有则抛异常继续循环
                        getMethod = clazz1.getMethod(getName, new Class[] {});
                    } catch (NoSuchMethodException e) {
                        continue;
                    }
                    // 通过getName 例如getXxxx 截取后得到Xxxx，然后在前面加上set，就组装成set的方法名
                    String setName = "set" + getName.substring(3);
                    // 得到class1的set方法，并调用
                    try{
                        Method setMethod = clazz1.getMethod(setName, paramType);
                        setMethod.invoke(class1, value);
                    }
                    catch (Exception e){
                        continue;
                    }
                }
            }
        } catch(Exception e) {
            log.error(" convert bean error: ", e);
        }
    }

    public static byte[] getNetFileStream(String urls) throws Exception{
        //new一个URL对象
        URL url = new URL(urls);
        //打开链接
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置请求方式为"GET"
        conn.setRequestMethod("GET");
        //超时响应时间为5秒
        conn.setConnectTimeout(10 * 1000);
        //通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
        return readInputStream(inStream);
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

    /**
     * 把一个json的字符串转换成为一个包含POJO对象的List
     *
     * @param string
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonStringConvertToList(String string, Class<T[]> cls) {
        Gson gson = new Gson();
        T[] array = gson.fromJson(string, cls);
        return Arrays.asList(array);
    }
    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param formatStr
     * @return
     */
    public static String timeStamp2Date(Integer seconds,String formatStr) {
        if(ObjectUtils.isEmpty(seconds)){
            return "";
        }
        if(ObjectUtils.isEmpty(formatStr)){
            formatStr = "yyyy-MM-dd HH:mm";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }

    /**
     * 获取重定向地址
     * @param path
     * @return
     * @throws Exception
     */
    public static String sendPost(String path){
        HttpURLConnection conn = null;
        String realUrl = "";
        try {
            conn =  (HttpURLConnection) new URL(path).openConnection();
            conn.setInstanceFollowRedirects(false);
            conn.setConnectTimeout(5000);
            realUrl = conn.getHeaderField("Location");
        }catch (IOException e) {
            realUrl = path;
            e.printStackTrace();
        }finally {
            if (null != conn){
                conn.disconnect();
            }
            if (ObjectUtils.isEmpty(realUrl)){
                realUrl = path;
            }
        }
        return realUrl;
    }
    /**
     * 将String类型的经纬度转换成double型
     * @param position  第一个是经度  第二个是纬度
     * @return
     */
    public static List<Double> getDouble(String position){

        List<Double> doubles = new ArrayList<>();
        String[] positionArr = position.split(",");

        for (String positionStr : positionArr){
            doubles.add(Double.valueOf(positionStr));
        }
        return doubles;
    }

    /**
     * 基于googleMap中的算法得到两经纬度之间的距离,计算精度与谷歌地图的距离精度差不多，相差范围在0.2米以下
     * @param lon1 第一点的经度
     * @param lat1 第一点的纬度
     * @param lon2 第二点的经度
     * @param lat2 第二点的纬度
     * @return 返回的距离，单位km
     * */
    public static double getDistance(Double lon1,Double lat1,Double lon2, Double lat2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2)+Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        BigDecimal bigDecimal = BigDecimal.ZERO;
        bigDecimal =  new BigDecimal(s).divide(new BigDecimal(1000));
        DecimalFormat df1 = new DecimalFormat("0.00");
        String str = df1.format(bigDecimal);
        bigDecimal = new BigDecimal(str);
        return bigDecimal.doubleValue();
    }
    /**
     * 转化为弧度(rad)
     * */
    private static double rad(double d){
        return d * Math.PI / 180.0;
    }
}
