package com.cross.utils;


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*************************************************************
 * Description:  二维码生成和解析工具类
 * Author: Dairy
 * CreateTime: 2019/6/14
 ************************************************************/
public class QR2CodeUtil {


    // 二维码颜色
    private static final int BLACK = 0xFF000000;
    // 二维码颜色
    private static final int WHITE = 0xFFFFFFFF;
    // 二维码图片格式
    private static final List<String> IMAGE_TYPE = new ArrayList<String>();

    static {
        IMAGE_TYPE.add("jpg");
        IMAGE_TYPE.add("png");
    }

    /**
     * zxing方式生成二维码
     * 注意：
     * 1,文本生成二维码的方法独立出来,返回image流的形式,可以输出到页面
     * 2,设置容错率为最高,一般容错率越高,图片越不清晰,但是只有设置高一点才能兼容logo图片
     * 3,logo图片默认占二维码图片的20%,设置太大会导致无法解析
     * @param content 二维码包含的内容，文本或网址"Hello World"
     * @param size 二维码图片尺寸 null or your size
     * @param logoPath 插入图片目录
     */
    public static boolean zxingCodeCreate(String content, String imageType,OutputStream outputStream, Integer size,String logoPath) {

        try {
            if (!IMAGE_TYPE.contains(imageType)) {
                return false;
            }

            //获取二维码流的形式，写入到目录文件中
            BufferedImage image = getBufferedImage(content,size,logoPath,ErrorCorrectionLevel.L);

//            File file = new File(path);
//            if (!file.exists()) {
//                try {
//                    file.mkdirs();
//                }catch (Exception e){
//
//                }
//            }
            ImageIO.write(image, imageType, outputStream);

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 二维码流的形式，包含文本内容
     * @param content 二维码文本内容
     * @param size 二维码尺寸
     * @return
     */
    public static BufferedImage getBufferedImage (String content, Integer size, String logoPath, ErrorCorrectionLevel errorCorrectionLevel) {

        if (size == null || size <= 0) {
            size = 250;
        }

        BufferedImage image = null;
		/* L(1),
           M(0),
           Q(3),
           H(2);*/
        try {
            // 设置编码字符集
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            //设置编码
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION,errorCorrectionLevel);
            hints.put(EncodeHintType.MARGIN, 1);
            // 1、生成二维码
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, size, size, hints);

            // 2、获取二维码宽高
            int codeWidth = bitMatrix.getWidth();
            int codeHeight = bitMatrix.getHeight();

            // 3、将二维码放入缓冲流
            image = new BufferedImage(codeWidth, codeHeight, BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < codeWidth; i++) {
                for (int j = 0; j < codeHeight; j++) {
                    // 4、循环将二维码内容定入图片
                    image.setRGB(i, j, bitMatrix.get(i, j) ?  BLACK : WHITE);
                }
            }

            //判断是否写入logo图片
            if (logoPath != null && !"".equals(logoPath)) {
                File logoPic = new File(logoPath);
                if (logoPic.exists()) {
                    Graphics2D g = image.createGraphics();
                    BufferedImage logo = ImageIO.read(logoPic);
                    int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ?
                        (image.getWidth() * 2 / 10) : logo.getWidth(null);
                    int heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ?
                        (image.getHeight() * 2 / 10) : logo.getHeight(null);
                    int x = (image.getWidth() - widthLogo) / 2;
                    int y = (image.getHeight() - heightLogo) / 2;

                    // 开始绘制图片
                    g.drawImage(logo, x, y, widthLogo, heightLogo, null);
                    g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
                    //边框宽度
                    g.setStroke(new BasicStroke(3));
                    //边框颜色
                    g.setColor(Color.WHITE);
                    g.drawRect(x, y, widthLogo, heightLogo);
                    g.dispose();
                    logo.flush();
                    image.flush();
                }
            }

        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }


    /**
     * 给二维码图片添加Logo
     *
     * @param qrPic 二维码图片
     * @param logoPic logo图片
     * @param path 合成后的图片存储目录
     */
    public static boolean zxingCodeCreate(File qrPic, File logoPic,String path) {
        try {
            String imageType = path.substring(path.lastIndexOf(".") + 1).toLowerCase();
            if (!IMAGE_TYPE.contains(imageType)) {
                return false;
            }
            if (!qrPic.isFile() && !logoPic.isFile()) {
                return false;
            }
            /**
             * 读取二维码图片，并构建绘图对象
             */
            BufferedImage image = ImageIO.read(qrPic);
            Graphics2D g = image.createGraphics();

            /**
             * 读取Logo图片
             */
            BufferedImage logo = ImageIO.read(logoPic);
            /**
             * 设置logo的大小,最多20%0
             */
            int widthLogo = logo.getWidth(null) > image.getWidth() * 2 / 10 ?
                (image.getWidth() * 2 / 10) : logo.getWidth(null);
            int heightLogo = logo.getHeight(null) > image.getHeight() * 2 / 10 ?
                (image.getHeight() * 2 / 10) : logo.getHeight(null);

            // 计算图片放置位置，默认在中间
            int x = (image.getWidth() - widthLogo) / 2;
            int y = (image.getHeight() - heightLogo) / 2;

            // 开始绘制图片
            g.drawImage(logo, x, y, widthLogo, heightLogo, null);
            g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
            //边框宽度
            g.setStroke(new BasicStroke(2));
            //边框颜色
            g.setColor(Color.WHITE);
            g.drawRect(x, y, widthLogo, heightLogo);

            g.dispose();
            logo.flush();
            image.flush();

            File newFile = new File(path);
            if (!newFile.exists()) {
                try {
                    newFile.mkdirs();
                }catch (Exception e){

                }
            }
            ImageIO.write(image, imageType,newFile);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * zxing方式生成二维码的解析方法
     * @param path 二维码图片目录
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static Result zxingCodeAnalyze(String path) {
        try {
            URL url = new URL(path);
            MultiFormatReader formatReader = new MultiFormatReader();
                BufferedImage image = ImageIO.read(url);
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                Binarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
                Map hints = new HashMap();
                hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                //带有图片的二维码解析需要开启复杂模式
                hints.put(DecodeHintType.PURE_BARCODE, Boolean.TRUE);
                Result result = formatReader.decode(binaryBitmap, hints);
                return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void responseQrcode(String content, String logopath,int size, ErrorCorrectionLevel errorCorrectionLevel,HttpServletResponse resp) throws IOException {
        resp.setContentType("image/png");
        ServletOutputStream stream = null;

        try {
            stream = resp.getOutputStream();
            BufferedImage bufferedImage = QR2CodeUtil.getBufferedImage(content, size, logopath,errorCorrectionLevel);
            ImageIO.write(bufferedImage,"png",stream);
        }catch (Exception e){
            System.out.println();
        }finally {
            if(stream != null){
                stream.flush();
            }
            if(stream != null) {
                stream.close();
            }


        }


        //扫描该二维码，并跳转到该url地址
        //BufferedImage bufferedImage = QRCodeUtil.getBufferedImage("http://www.shixianweilai.cn", 200, "F://123.jpg");


    }

    public static void main(String[] args) {
        System.out.println(zxingCodeAnalyze("https://open.weixin.qq.com/qr/code?username=gh_daddeb01fbf3").getText());
    }
}
