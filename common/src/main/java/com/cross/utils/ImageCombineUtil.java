package com.cross.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;

/**
 * <类的描述>
 * Created by LY on 2018/6/6.
 */
public class ImageCombineUtil {

    private static final Logger log = LoggerFactory.getLogger(ImageCombineUtil.class);

    private static int BLACK = 0x000000;// 编码的颜色

    private static int WHITE = 0xFFFFFF;// 空白的颜色

    private static InputStream is;

    private static Long startTime = System.currentTimeMillis();

    private static Long tailTime = 0L;

    public static void setFontInputStream(InputStream inputStream){
        is = inputStream;
    }

    private static String getExtName(String url){
        log.info(url);
        String[] strings = url.split("\\.");
        log.info(JsonUtil.objectToJson(strings));
        return null != strings ? strings[strings.length - 1] : "";
    }

    public static byte[] imageCombine(String shareUrl, String content) {
        try {
            // 读取第一张图片
            URL url = new URL(shareUrl);
            BufferedImage imageOne = ImageIO.read(url);
            log.info("read image: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();

            //int width = ImageOne.getWidth();
            // 图片宽度
            int height = imageOne.getHeight();
            // 图片高度
            // 从图片中读取RGB
            /*int[] ImageArrayOne = new int[width * height];
            ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);
            log.info("read one image to chars: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();*/
            // 根据内容生成二维码
            BufferedImage imageTwo = createQrCode(content);
            log.info("generate qr code: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
            int smallWidth = imageTwo.getWidth();
            // 图片宽度
            int smallHeight = imageTwo.getHeight();

            imageTwo.getGraphics().drawImage(imageTwo, 0, 0, smallWidth, smallHeight, null);
            int[] ImageArrayTwo = new int[smallWidth * smallHeight];
            ImageArrayTwo = imageTwo.getRGB(0, 0, smallWidth, smallHeight, ImageArrayTwo, 0, smallWidth);
            log.info("read two image to chars: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();

            // 生成新图片
            //BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);
            // 设置左半部分的RGB
            log.info("read two image to chars: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
            imageOne.setRGB(35, height - smallHeight - 35, smallWidth, smallHeight, ImageArrayTwo, 0, smallWidth);
            // 设置右半部分的RGB

            //获取字体流
            java.awt.Graphics graphics = imageOne.getGraphics();
            Color color = Color.GRAY;
            graphics.setColor(color);
            log.info("get font stream: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
            ByteArrayOutputStream out = getByteArrayOutputStream(imageOne, graphics, is, "长按识别二维码", 35, height - 15);
            log.info("draw font stream to image: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Thumbnails.of(imageOne).scale(1f).outputQuality(0.6f).outputFormat(getExtName(shareUrl)).toOutputStream(outputStream);
            //ImageIO.write(imageOne, getExtName(shareUrl), outputStream);
            log.info("draw font stream to image: {}", System.currentTimeMillis() - startTime);
            startTime = System.currentTimeMillis();
            //out.toByteArray();
            return outputStream.toByteArray();
            // 写图片
        } catch (Exception e) {
            log.error("生成分享页失败：{}", e);
            e.printStackTrace();
        }

        return null;
    }

    public static byte[] imageCombine(String shareUrl, String content, String userImage){
        try {
            // 读取第一张图片
            URL url = new URL(shareUrl);
            BufferedImage ImageOne = ImageIO.read(url);
            int width = ImageOne.getWidth();
            // 图片宽度
            int height = ImageOne.getHeight();
            // 图片高度
            // 从图片中读取RGB
            int[] ImageArrayOne = new int[width * height];
            ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);

            // 根据内容生成二维码
            BufferedImage ImageTwo = createQrCode(content);
            int smallWidth = ImageTwo.getWidth();
            // 图片宽度
            int smallHeight = ImageTwo.getHeight();

            ImageTwo.getGraphics().drawImage(ImageTwo, 0, 0, smallWidth, smallHeight, null);

            int[] ImageArrayTwo = new int[smallWidth * smallHeight];
            ImageArrayTwo = ImageTwo.getRGB(0, 0, smallWidth, smallHeight, ImageArrayTwo, 0, smallWidth);

            URL userUrl = new URL(userImage);
            BufferedImage input = ImageIO.read(userUrl);
            Image scaledImage = input.getScaledInstance(smallWidth, smallHeight,Image.SCALE_DEFAULT);
            BufferedImage imageThree = new BufferedImage(smallWidth, smallHeight,BufferedImage.TYPE_INT_BGR);
            //画图
            imageThree.createGraphics().drawImage(scaledImage, 0, 0, null);

            int[] ImageArrayThree = new int[smallWidth * smallHeight];
            ImageArrayThree = imageThree.getRGB(0, 0, smallWidth, smallHeight, ImageArrayThree, 0, smallWidth);

            // 生成新图片
            BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);
            // 设置左半部分的RGB

            ImageNew.setRGB(35, height - smallHeight - 35, smallWidth, smallHeight, ImageArrayTwo, 0, smallWidth);

            ImageNew.setRGB(38, 35, smallWidth-40, smallHeight-40, ImageArrayThree, 0, smallWidth);

            java.awt.Graphics graphics = ImageNew.getGraphics();
            Color color = Color.GRAY;
            graphics.setColor(color);

            ByteArrayOutputStream out = getByteArrayOutputStream(ImageNew, graphics, is, "长按识别二维码立享优惠", 30, height - 15);
            return out.toByteArray();
            // 写图片
        } catch (Exception e) {
            log.error("生成分享页失败：{}", e);
            e.printStackTrace();
        }

        return null;
    }

    public static byte[] imageCombine(String shareUrl, String content, String userImage, String scanTips) {
        try {
            // 读取第一张图片
            URL url = new URL(shareUrl);
            BufferedImage ImageOne = ImageIO.read(url);
            int width = ImageOne.getWidth();
            // 图片宽度
            int height = ImageOne.getHeight();
            // 图片高度
            // 从图片中读取RGB
            int[] ImageArrayOne = new int[width * height];
            ImageArrayOne = ImageOne.getRGB(0, 0, width, height, ImageArrayOne, 0, width);

            // 根据内容生成二维码
            BufferedImage ImageTwo = createQrCode(content);
            int smallWidth = ImageTwo.getWidth();
            // 图片宽度
            int smallHeight = ImageTwo.getHeight();

            ImageTwo.getGraphics().drawImage(ImageTwo, 0, 0, smallWidth, smallHeight, null);

            int[] ImageArrayTwo = new int[smallWidth * smallHeight];
            ImageArrayTwo = ImageTwo.getRGB(0, 0, smallWidth, smallHeight, ImageArrayTwo, 0, smallWidth);

            URL userUrl = new URL(userImage);
            BufferedImage input = ImageIO.read(userUrl);
            Image scaledImage = input.getScaledInstance(smallWidth, smallHeight,Image.SCALE_DEFAULT);
            BufferedImage imageThree = new BufferedImage(smallWidth, smallHeight,BufferedImage.TYPE_INT_BGR);
            //画图
            imageThree.createGraphics().drawImage(scaledImage, 0, 0, null);

            int[] ImageArrayThree = new int[smallWidth * smallHeight];
            ImageArrayThree = imageThree.getRGB(0, 0, smallWidth, smallHeight, ImageArrayThree, 0, smallWidth);

            // 生成新图片
            BufferedImage ImageNew = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            ImageNew.setRGB(0, 0, width, height, ImageArrayOne, 0, width);
            // 设置左半部分的RGB

            ImageNew.setRGB(35, height - smallHeight - 35, smallWidth, smallHeight, ImageArrayTwo, 0, smallWidth);

            ImageNew.setRGB(38, 35, smallWidth-40, smallHeight-40, ImageArrayThree, 0, smallWidth);

            java.awt.Graphics graphics = ImageNew.getGraphics();
            Color color = Color.GRAY;
            graphics.setColor(color);

            //获取字体流
            //InputStream is = ImageCombineUtil.class.getResourceAsStream("/fonts/MicrosoftYaHei-01.ttf");
            ByteArrayOutputStream out = getByteArrayOutputStream(ImageNew, graphics, is, scanTips, 35, height - 15);
            return out.toByteArray();
            // 写图片
        } catch (Exception e) {
            log.error("生成分享页失败：{}", e);
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 生成包含字符串信息的二维码图片
     *
     * @param content 二维码携带信息
     */
    public static BufferedImage createQrCode(String content) throws Exception {
        int qrCodeSize = 180;
        //设置二维码纠错级别ＭＡＰ
        EnumMap<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);  // 矫错级别
        hintMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hintMap.put(EncodeHintType.MARGIN, 0);

        BitMatrix byteMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);
        /*int[] rec = byteMatrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();

        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (byteMatrix.get(i + rec[0], j + rec[1])) {
                    resMatrix.set(i, j);
                }

            }
        }
*/
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, byteMatrix.get(x, y) == true ?
                    Color.BLACK.getRGB():Color.WHITE.getRGB());
            }
        }

        return image;
    }

    public static BitMatrix encode(String contents, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) throws WriterException {
        if (contents.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (format != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + format);
        } else if (width >= 0 && height >= 0) {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            if (hints != null) {
                if (hints.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(hints.get(EncodeHintType.ERROR_CORRECTION).toString());
                }
            }

            return renderResult(Encoder.encode(contents, errorCorrectionLevel, hints), width, height);
        } else {
            throw new IllegalArgumentException("Requested dimensions are too small: " + width + 'x' + height);
        }
    }

    private static BitMatrix renderResult(QRCode code, int width, int height) {
        ByteMatrix input = code.getMatrix();
        if (input == null) {
            throw new IllegalStateException();
        }
        int inputWidth = input.getWidth();
        int inputHeight = input.getHeight();
        // 依据用户的输入宽高，计算最后的输出宽高
        int outputWidth = Math.max(width, inputWidth);
        int outputHeight = Math.max(height, inputHeight);

        //计算缩放比例
        int multiple = Math.min(outputWidth / inputWidth, outputHeight / inputHeight);

        BitMatrix output = new BitMatrix(outputWidth, outputHeight);
        int inputY = 0;
        // 嵌套循环，将ByteMatrix的内容计算padding后转换成BitMatrix
        for (int outputY = 0; inputY < inputHeight; outputY += multiple) {
            int inputX = 0;
            for (int outputX = 0; inputX < inputWidth; outputX += multiple) {
                if (input.get(inputX, inputY) == 1) {
                    output.setRegion(outputX, outputY, multiple, multiple);
                }
                inputX++;
            }
            inputY++;
        }

        return output;
    }

    private static ByteArrayOutputStream getByteArrayOutputStream(BufferedImage imageNew, Graphics graphics, InputStream is, String 长按识别二维码, int x, int y) throws IOException {
        log.info("font info : {}", is);
        try {
            Font f = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, 18);
            graphics.setFont(f);
            graphics.drawString(长按识别二维码, x, y);
        } catch (Exception e) {
            log.error("draw text fail: ", e);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(imageNew, "png", out);
        return out;
    }

    public static void test() throws Exception {
        //Long startTime = System.currentTimeMillis();
        log.info("start combine image: {}", startTime);
        InputStream is = ImageCombineUtil.class.getResourceAsStream("/fonts/MicrosoftYaHei-01.ttf");
        setFontInputStream(is);
        log.info("loading font: {}", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        // 读取第一张图片
        byte[] imageCombine = imageCombine("http://attach.qianxiaohao.com/data/20180622/2361429177028843295493733691850878942102.jpg", "www.baidu.com");

        FileImageOutputStream outFile = new FileImageOutputStream(new File("C:\\Users\\Administrator\\Desktop\\generatepic.jpg"));
        try {
            outFile.write(imageCombine, 0, imageCombine.length);
        }
        catch (Exception e){
            outFile.close();
        }
        finally {
            outFile.close();
        }
    }
/*
    public static void main(String[] args){
        try{
            test();
        }
        catch (Exception e){
            log.error("", e);
        }
    }*/

    public static byte[] imageCombine(String content){
        try {
            // 根据内容生成二维码
            BufferedImage ImageTwo = createQrCode(content);
            int smallWidth = ImageTwo.getWidth();
            // 图片宽度
            int smallHeight = ImageTwo.getHeight();

            ImageTwo.getGraphics().drawImage(ImageTwo, 0, 0, smallWidth, smallHeight, null);

            java.awt.Graphics graphics = ImageTwo.getGraphics();
            Color color = Color.GRAY;
            graphics.setColor(color);

            ByteArrayOutputStream out = getByteArrayOutputStream(ImageTwo, graphics, is, "长按识别二维码立享优惠", 30, 30);
            return out.toByteArray();
            // 写图片
        } catch (Exception e) {
            log.error("生成顾客核销二维码失败：{}", e);
            e.printStackTrace();
        }
        return null;
    }

    public static void testQr(InputStream is) throws Exception {
        setFontInputStream(is);
        log.info("loading font: {}", System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        // 读取第一张图片
        byte[] imageCombine = shareImageCombine("http://public-attach.canyingdongli.com/data/20190306/WechatIMG464.jpeg","https://clt.canyingdongli.com/595422630",
            922,2080,120,"https://public-attach.canyingdongli.com/data/20181017/3734112511320329645478863448844974291428.jpg",
            null,null,null,null, "夏新颖", 530, 115, 32, null);

        FileImageOutputStream outFile = new FileImageOutputStream(new File("C:\\Users\\Administrator\\Desktop\\share6.jpg"));
        try {
            outFile.write(imageCombine, 0, imageCombine.length);
        }
        catch (Exception e){
            outFile.close();
        }
        finally {
            outFile.close();
        }
    }

    public static byte[] shareImageCombine(String shareUrl, String content,Integer qrCodeXValve,Integer qrCodeYValue, Integer qrCodeSize,String avatar, Integer avatarHeight,Integer avatarWidth,Integer avatarXValue,Integer avatarYValue, String nickName, Integer nickNameXValue, Integer nickNameYValue, Integer nickNameSize, String nickNameColor) {
        Long startOne = System.currentTimeMillis();
        try {
            // 读取第一张图片
            URL url = new URL(shareUrl);
            BufferedImage imageOne = ImageIO.read(url);
            // 图片高度
            int height = imageOne.getHeight();

            if (null == qrCodeSize){
                qrCodeSize = 107;
            }

            // 根据内容生成二维码
            BufferedImage imageTwo = shareCreateQrCode(content, qrCodeSize);
            int smallWidth = imageTwo.getWidth();
            // 图片宽度
            int smallHeight = imageTwo.getHeight();

            imageTwo.getGraphics().drawImage(imageTwo, 0, 0, smallWidth, smallHeight, null);
            int[] imageArrayTwo = new int[smallWidth * smallHeight];
            imageArrayTwo = imageTwo.getRGB(0, 0, smallWidth, smallHeight, imageArrayTwo, 0, smallWidth);

           //二维码（左边）距离y轴的距离
            if (null == qrCodeXValve){
                qrCodeXValve = 35;
            }
            //二维码（下边）距离x轴的距离
            if (null == qrCodeYValue){
                qrCodeYValue = 60;
            }

            // 设置左半部分的RGB
            imageOne.setRGB(qrCodeXValve, height - smallHeight - qrCodeYValue, smallWidth, smallHeight, imageArrayTwo, 0, smallWidth);

            Long startTwo =  System.currentTimeMillis();
            log.info("read picture and generate QR code:{}",startTwo - startOne);
            //设置头像
            if (null != avatar && !avatar.trim().isEmpty()){
                URL avatarUrl = new URL(avatar);
                BufferedImage avatarImage = ImageIO.read(avatarUrl);
                //设置缩放目标图片模板 ：按固定长宽进行缩放,传入的固定高和宽为null，则默认为100
                if (null == avatarHeight){
                    avatarHeight = 100;
                }
                if (null == avatarWidth){
                    avatarWidth = 100;
                }
                //获取缩放比例
                Double wr= avatarWidth *1.0/avatarImage.getWidth();
                Double hr= avatarHeight *1.0 / avatarImage.getHeight();

                AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
                BufferedImage avatarTemp = ato.filter(avatarImage, null);

                int avatarHt = avatarTemp.getHeight();
                int avatarWh = avatarTemp.getWidth();
                avatarImage.getGraphics().drawImage(avatarImage, 0, 0, avatarWh, avatarHt, null);
                int[] avatarImageArray = new int[avatarWh * avatarHt];
                avatarImageArray = avatarImage.getRGB(0, 0, avatarWh, avatarHt, avatarImageArray, 0, avatarWh);
                //头像离Y轴的距离，为null则为默认值
                if (null == avatarXValue){
                    avatarXValue = 30;
                }
                //头像离X轴的距离，为null则为默认值
                if (null == avatarYValue){
                    avatarYValue = 30;
                }
                imageOne.setRGB(avatarXValue, height - avatarHt - avatarYValue, avatarWh, avatarHt, avatarImageArray, 0, avatarWh);
            }
            Long startThree = System.currentTimeMillis();

            log.info("set avatar:{}",startThree - startTwo);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // 设置昵称
            if(null != nickName){
                //获取字体流

                nickNameXValue = nickNameXValue == null ? 30 : nickNameXValue;
                nickNameYValue = nickNameYValue == null ? 30 : nickNameYValue;

                java.awt.Graphics graphics = imageOne.getGraphics();
                Color color = Color.BLACK;
                graphics.setColor(color);
                Font f = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.BOLD, null == nickNameSize ? 20 : nickNameSize);
                graphics.setFont(f);
                graphics.drawString(nickName, nickNameXValue, nickNameYValue);
                ImageIO.write(Thumbnails.of(imageOne).scale(1f).outputQuality(0.6f).asBufferedImage(), getExtName(shareUrl), outputStream);
                Long startFour =  System.currentTimeMillis();
                log.info("set nickName time:{}",startFour - startThree);
            } else{
                Thumbnails.of(imageOne).scale(1f).outputQuality(0.6f).outputFormat(getExtName(shareUrl)).toOutputStream(outputStream);
                Long startFour = System.currentTimeMillis();
                log.info("not set nikeName time:{}",startFour - startThree);
            }
            return outputStream.toByteArray();
        } catch (Exception e) {
            log.error("生成分享页失败：{}", e);
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        log.info("generate QR code all time:{}",startOne - endTime);
        return null;
    }

    /**
     * 生成包含字符串信息的二维码图片
     *
     * @param content 二维码携带信息
     */
    public static BufferedImage shareCreateQrCode(String content,Integer qrCodeSize) throws Exception {
        //设置二维码纠错级别ＭＡＰ
        EnumMap<EncodeHintType, Object> hintMap = new EnumMap<>(EncodeHintType.class);
        // 矫错级别
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hintMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hintMap.put(EncodeHintType.MARGIN, 0);

        BitMatrix byteMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, byteMatrix.get(x, y) == true ?
                    Color.BLACK.getRGB():Color.WHITE.getRGB());
            }
        }

        return image;
    }

 /*  public static void main(String[] args){
        try{
            testQr();
        }
        catch (Exception e){
            log.error("", e);
        }
    }*/

}
