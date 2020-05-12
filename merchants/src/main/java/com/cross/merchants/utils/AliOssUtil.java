package com.cross.merchants.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.cross.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author  DuYuLiang on 2017/6/6.
 */
@Component
public class AliOssUtil {
    private final Logger log = LoggerFactory.getLogger(AliOssUtil.class);

    private OSSClient ossClient;

    @Value("${aliyun.oss.folderName}")
    private String folderName;

    public AliOssUtil getInstance(String endpoint, String accessKeyId, String accessKeySecret){
        this.ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        return this;
    }

    public Boolean uploadOssByBytes(String bucketName, String ossName, byte[] bytes){
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, ossName, new ByteArrayInputStream(bytes));
        log.debug("upload oss results:" + putObjectResult);
        return putObjectResult.getETag()!=null;
    }

    public Boolean uploadOssByInputStream(String bucketName, String ossName, InputStream inputStream){
                PutObjectResult putObjectResult = ossClient.putObject(bucketName, ossName, inputStream);
        log.debug("upload oss results:" + putObjectResult);
        return putObjectResult.getETag()!=null;
    }

    public String getOssPath(String ossName){
        return String.format("%s/%s/%s", folderName, CommonUtil.getCurrentDate().replace("-", ""), ossName);
    }

    public void closeClient(){
        ossClient.shutdown();
    }
}
