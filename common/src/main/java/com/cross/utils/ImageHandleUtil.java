package com.cross.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author 马晓林
 * @since 2019/10/11 18:23
 */
public class ImageHandleUtil {
    public static void main(String[] args) {
        String brand = "何师烧烤";
        String table = "A1";
        try {
            InputStream headImg = new FileInputStream(new File("C:\\Users\\island\\Desktop\\head.jpg"));
            InputStream baseImg = new FileInputStream(new File("C:\\Users\\island\\Desktop\\base.png"));
            InputStream qrImg = new FileInputStream(new File("C:\\Users\\island\\Desktop\\a.jpg"));

            InputStream is = new FileInputStream(new File("E:\\project\\zptx\\merchant\\src\\main\\resources\\fonts\\MicrosoftYaHei-01.ttf"));
            InputStream iss = new FileInputStream(new File("E:\\project\\zptx\\merchant\\src\\main\\resources\\fonts\\MicrosoftYaHei-01.ttf"));
            ByteArrayOutputStream fileOutputStream = createQrImg(brand, table, headImg, "http://resource.canyingdongli.com/only_merchant/qr_order_base.png", qrImg,is,iss);
            File file = new File("C:\\Users\\island\\Desktop\\new.jpg");
            InputStream inputStream = new ByteArrayInputStream(fileOutputStream.toByteArray());
            byte[] b = new byte[300 * 1024];
            inputStream.read(b);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            bufferedOutputStream.write(b);
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ByteArrayOutputStream createQrImg(String brand, String table, InputStream headImg, String base, InputStream qrImg,InputStream is,InputStream iss) {
        ByteArrayOutputStream firstStream = new ByteArrayOutputStream();
        ByteArrayOutputStream lastStream = new ByteArrayOutputStream();
        ByteArrayOutputStream brandStream = new ByteArrayOutputStream();
        ByteArrayOutputStream tableStream = new ByteArrayOutputStream();
        ByteArrayOutputStream headOut = new ByteArrayOutputStream();
        InputStream baseImg = null;
        ByteArrayOutputStream brandOut = null;
        ByteArrayOutputStream headOutStream = null;
        try {
            baseImg = getImageStream(base);

            //创建品牌名称图片
            Font f = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.BOLD, 70);
            int w = createBrand(brand, f, brandStream, 1080, 175);
            //创建桌号名称图片
            Font f2 = Font.createFont(Font.TRUETYPE_FONT, iss).deriveFont(Font.PLAIN, 50);

            createTable("桌号：" + table, f2, tableStream, 785, 120);

            Thumbnails.of(baseImg).watermark(Positions.BOTTOM_CENTER, ImageIO.read(new ByteArrayInputStream(brandStream.toByteArray())), 1f)
                .size(1080, 1459)
                .outputQuality(1f).toOutputStream(firstStream);
            brandOut = new ByteArrayOutputStream();
            //将二维码水印到底图上
            Thumbnails.of(new ByteArrayInputStream(firstStream.toByteArray())).watermark(Positions.CENTER, ImageIO.read(qrImg), 1f)
                .size(1080, 1459)
                .outputQuality(1f).toOutputStream(brandOut);
            //将头像变圆
            yuan(headImg, headOut);
            headOutStream = new ByteArrayOutputStream();
            //把头像水印到底图上
            Thumbnails.of(new ByteArrayInputStream(brandOut.toByteArray())).watermark(new Position() {
                @Override
                public Point calculate(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                    return new Point(w - 125, 1315);
                }
            }, ImageIO.read(new ByteArrayInputStream(headOut.toByteArray())), 1f)
                .size(1080, 1459)
                .outputQuality(1f)
                .toOutputStream(headOutStream);
            //把桌号名称水印到底图上
            Thumbnails.of(new ByteArrayInputStream(headOutStream.toByteArray())).watermark(new Position() {
                @Override
                public Point calculate(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
                    return new Point(147, 1038);
                }
            }, ImageIO.read(new ByteArrayInputStream(tableStream.toByteArray())), 1f)
                .size(1080, 1459)
                .outputQuality(1f)
                .toOutputStream(lastStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                firstStream.flush();
                firstStream.close();
                brandStream.flush();
                brandStream.close();
                tableStream.flush();
                tableStream.close();
                headOut.flush();
                headOut.close();
                if (baseImg != null) {
                    baseImg.close();
                }
                brandOut.flush();
                brandOut.close();
                headOutStream.flush();
                headOutStream.close();
                lastStream.flush();
                lastStream.close();
                headImg.close();
                qrImg.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return lastStream;
    }
    /**
     * 获取网络图片流
     *
     * @param url
     * @return
     */
    public static InputStream getImageStream(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                return inputStream;
            }
        } catch (IOException e) {
            System.out.println("获取网络图片出现异常，图片路径为：" + url);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 创建品牌名称
     *
     * @param brand
     * @param font
     * @param out
     * @param width
     * @param height
     * @return 返回品牌字体宽度
     * @throws Exception
     */
    public static int createBrand(String brand, Font font, OutputStream out,
                                  Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_BGR);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        // 先用黑色填充整张图片,也就是背景
        g.fillRect(0, 0, width, height);
        // 在换成红色
        g.setColor(Color.black);
        // 设置画笔字体
        g.setFont(font);
        /** 用于获得垂直居中y */
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(brand, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        g.drawString(brand, (int) x + 125 / 2, (int) baseY);
        g.dispose();
        // 输出png图片
        ImageIO.write(image, "jpg", out);
        return (int) x + 125 / 2;
    }

    /**
     * 创建桌号名称
     *
     * @param table
     * @param font
     * @param out
     * @param width
     * @param height
     * @throws Exception
     */
    public static void createTable(String table, Font font, OutputStream out,
                                   Integer width, Integer height) throws Exception {
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_BGR);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setClip(0, 0, width, height);
        g.setColor(Color.white);
        // 先用黑色填充整张图片,也就是背景
        g.fillRect(0, 0, width, height);
        // 在换成红色
        g.setColor(Color.black);
        // 设置画笔字体
        g.setFont(font);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(table, context);
        /** 用于获得垂直居中y */
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();
        double baseY = y + ascent;
        g.drawString(table, (int) x, (int) baseY);
        g.dispose();
        // 输出png图片
        ImageIO.write(image, "jpg", out);
    }

    /**
     * 将120*120的头像裁圆
     *
     * @param in
     * @param out
     * @throws IOException
     */
    public static void yuan(InputStream in, OutputStream out) throws IOException {
        BufferedImage bi1 = ImageIO.read(in);
        // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
        BufferedImage bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
            BufferedImage.TYPE_INT_RGB);
        Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
            .getHeight());
        Graphics2D g2 = bi2.createGraphics();
        g2.setBackground(Color.WHITE);
        g2.fill(new Rectangle(bi2.getWidth(), bi2.getHeight()));
        g2.setClip(shape);
        // 使用 setRenderingHint 设置抗锯齿
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawImage(bi1, 0, 0, null);
        g2.dispose();
        try {
            ImageIO.write(bi2, "jpg", out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ByteArrayOutputStream parse(InputStream in) throws Exception {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream;
    }
}
