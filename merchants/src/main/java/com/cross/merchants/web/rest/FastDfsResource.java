package com.cross.merchants.web.rest;

import com.cross.merchants.utils.AliOssUtil;
import com.cross.merchants.utils.FastDFSClient;
import com.cross.model.LoginUserModel;
import com.cross.utils.CommonUtil;
import com.cross.utils.QR2CodeUtil;
import com.cross.utils.R;
import com.cross.utils.RandomUtil;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

/*************************************************************
 * Description:
 * Author: Dair
 * CreateTime: 2020/5/12
 * Copyright © 成都通吃岛信息技术有限公司 All right reserved
 ************************************************************/
@RestController
@RequestMapping("/api")
@Api(tags = "文件、图片相关")
public class FastDfsResource {

    private final Logger log = LoggerFactory.getLogger(FastDfsResource.class);


    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Autowired
    private FastDFSClient fastDFSClient;


    /**
     * 阿里oss集
     */
    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    public R Upload(@RequestPart("file") MultipartFile file,
                    HttpServletRequest request) {
        String str = FastDFSClient.uploadFile(file);
        String accessUrl = FastDFSClient.getResAccessUrl(str);
        return R.ok(accessUrl);
    }


    @PostMapping("/delete")
    public R get(@RequestPart("fileName") String fileName) {
        boolean flag = FastDFSClient.deleteFile(fileName);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    /**
     * 常用附件上传入口
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/osses/upload", method = RequestMethod.POST)
    @Timed
    @ApiOperation("常用附件上传入口")
    public R uploadOss(
        @RequestPart("file") MultipartFile file,
        HttpServletRequest request) {
        log.debug("REST request to save Oss : {}", file);
        LoginUserModel currentLoginUser = CommonUtil.getCurrentLoginUser();
        if (!file.isEmpty()) {
            try {
                InputStream inputStream = file.getInputStream();
                String remoteFileName = file.getOriginalFilename();
                String[] items = remoteFileName.split("\\.");
                String extName = items[items.length - 1];

                String newOssName = aliOssUtil.getOssPath(String.format("%s.%s", RandomUtil.generateFoldName(), extName));
                Boolean result = aliOssUtil.getInstance(endpoint, accessKeyId, accessKeySecret).uploadOssByInputStream(bucketName, newOssName, inputStream);
                if(result){
                    return R.ok(newOssName);
                }else {
                    return R.error();
                }
            } catch (Exception e) {
                log.trace("upload oss fail:", e);
            }
        } else {
            log.debug("upload oss fail: upload file is empty!");
            return R.error("文件不能为空");
        }
        return R.error();
    }

    /**
     * 富文本编辑器上传附件专用
     *
     * @param file
     * @param appId
     * @param request
     * @return
     */
    @RequestMapping(value = "/osses/editor-upload/{appId}", method = RequestMethod.POST)
    @Timed
    @ApiOperation("富文本编辑器上传附件专用")
    public R editorUploadOss(
        @RequestPart("upload") MultipartFile file,
        @PathVariable("appId") Integer appId,
        HttpServletRequest request) {

        String result = "{" +
            "\"uploaded\": 1," +
            "\"fileName\": \"" + file.getOriginalFilename() + "\"," +
            "\"url\": \"//attach.qianxiaohao.com/" + this.uploadOss(file, request).getData() + "\"}";
        return R.ok(result); //this.uploadOss(file, appId, 0L, request).getBody().getUrl();
    }

    /**
     * 字节数组格式附件上传
     *
     * @param bytes
     * @param remoteFileName
     * @return
     */
    @RequestMapping(value = "/osses/upload-bytes/{appId}/{userId}", method = RequestMethod.POST)
    @Timed
    @ApiOperation("字节数组格式附件上传")
    public R uploadOssByBytes(
        @RequestParam("bytes") byte[] bytes,
        @RequestParam("remoteFileName") String remoteFileName) {
        log.debug("REST request to save Oss : {}", bytes);
        try {
            String[] items = remoteFileName.split("\\.");
            String extName = items[items.length - 1];

            String newOssName = aliOssUtil.getOssPath(String.format("%s.%s", RandomUtil.generateFoldName(), extName));
            Boolean result = aliOssUtil.getInstance(endpoint, accessKeyId, accessKeySecret).uploadOssByBytes(bucketName, newOssName, bytes);
            if(result){
                return R.ok(newOssName);
            }else {
                return R.error();
            }
        } catch (Exception e) {
            log.trace("upload oss fail:", e);
        }
        return R.error();

    }

    /**
     * 生成二维码并上传
     *
     * @param appId
     * @param qrContent
     * @param request
     * @return
     */
    @ApiIgnore
    @GetMapping("/osses/generateQrCode/{appId}/{userId}")
    @Timed
    public R generateQrCode(
        @PathVariable("appId") Integer appId,
        @RequestParam("qrContent") String qrContent,
        HttpServletRequest request) {
        log.debug("REST request to generate qrCode Oss : {}", qrContent);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            String extName = "png";
            //该工具类短的地址可以生成,但是长的地址无法生成
            //  QrCodeUtil.createQrCode(outputStream, qrContent, 900, extName);
            QR2CodeUtil.zxingCodeCreate(qrContent, extName, outputStream, 900, null);
            String newOssName = aliOssUtil.getOssPath(String.format("%s.%s", RandomUtil.generateFoldName(), extName));
            InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            Boolean result = aliOssUtil.getInstance(endpoint, accessKeyId, accessKeySecret).uploadOssByInputStream(bucketName, newOssName, inputStream);
            if(result){
                return R.ok(newOssName);
            }else {
                return R.error();
            }
        } catch (Exception e) {
            log.debug("upload qr code fail：", e);
        }
        return R.error();
    }


}
