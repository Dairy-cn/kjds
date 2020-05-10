/*
package com.hpkj.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.holderzone.sop.sdk.client.OpenClient;
import com.holderzone.sop.sdk.common.UploadFile;
import com.holderzone.sop.sdk.model.DemoFileUploadModel;
import com.holderzone.sop.sdk.model.GetUserModel;
import com.holderzone.sop.sdk.model.UserInfoModel;
import com.holderzone.sop.sdk.request.CommonRequest;
import com.holderzone.sop.sdk.request.DemoFileUploadRequest;
import com.holderzone.sop.sdk.request.GetUserRequest;
import com.holderzone.sop.sdk.response.CommonResponse;
import com.holderzone.sop.sdk.response.DemoFileUploadResponse;
import com.holderzone.sop.sdk.response.GetStoryResponse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SdkTest {
    String url = "http://192.168.102.97:6010";
    String appId = "20190513577548661718777857";
    */
/** 开发者私钥 *//*

    String privateKeyIsv = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ0aPPcgTZVC14ONBoVpxcsIAip0QghVx/stbt/XjZXnlDTG1yMNM4eMEcTFmwbrj9jlYrPihBVYadfC2uV53xCDRgADu55q3yYTw3MlKb23Ft9T2HBcHvucnFWQXJpIbWnQhkWs1ClttTFNf3vnl14/sN1xIXXjwsuvT3VX75LdAgMBAAECgYB68z/nQDa3q/oykDocS21qujfHtfi/wTKjVylAsdezC+wnab6RRhGf8XUuhGARiGWpn8whcBNjCTC8lVju4vQ5IIx4Hb74vwDDMtNXeqwkLmARLYu2ELibauezSeqom8/J8cR3ho7Hr4VHPTiC8qvePRmu8AvXVQz2T7SOhEjDGQJBAOm8XOivr+atiknLbQhmo508ON3sjoN9VMwK9cmnup+ZPCsurJTHRja0MJQNdOXObUVJ6wJhs1PHWT+vITfXGJ8CQQCsESzxOYTkZaqBUFjbWVf1rSwjOOsylweTuq44YIJkHhwMjHf3kN/UTXbxsBPUGeT7/+2K5UwQ9snUPr0yTBcDAkA0FMezBWqxgNu+g7iA1bYBVCjrskkzHVsmuA56Z4hbBZ71lEnaQOjxSYdFhhYVGsEYXlciSbjWoyXM3e4N7jzLAkB0ejv+H33CTsAZQZalBdnxSQTz4vf0CyDp9BkzuMELnQZHyF79i2i5gqbd/N+vWMgVfq4CtC3F3gnKT54rii6ZAkAMBIvHriT5Zbs1fW+oxBP1rHqdsRvqs1zEyIadvJgKAFwFEisryfdw2mWm3vxQQ22RlOquBiZEDIlyM0z2m9PJ";
    */
/** 开放平台提供的公钥
     * 前往SOP-ADMIN，ISV管理--秘钥管理，生成平台提供的公私钥，然后把【平台公钥】放到这里 *//*

    String publicKeyPlatform = "";

    // 声明一个就行
    OpenClient client = new OpenClient(url, appId, privateKeyIsv, publicKeyPlatform);

    // 标准用法
    public void testGet() {
        // 创建请求对象
        GetUserRequest request = new GetUserRequest();
        // 请求参数
        GetUserModel model = new GetUserModel();
        model.setName("白雪公主");
        request.setBizModel(model);

        // 发送请求
        GetStoryResponse response = client.execute(request);

        if (response.isSuccess()) {
            // 返回结果
            System.out.println(String.format("成功！response:%s\n响应原始内容:%s",
                    JSON.toJSONString(response), response.getBody()));
        } else {
            System.out.println("错误，subCode:" + response.getSubCode() + ", subMsg:" + response.getSubMsg());
        }
    }

    public static void main(String[] args) {
        new SdkTest().testLazy();
    }

    // 懒人版，如果不想添加Request,Response,Model。可以用这种方式，返回全部是String，后续自己处理json
    public void testLazy() {
        // 创建请求对象
        CommonRequest request = new CommonRequest("member.card.getNotOpenList");
        // 请求参数
        Map<String, Object> bizModel = new HashMap<>();
        bizModel.put("storeGuid", "6552084589194510337");
        bizModel.put("enterpriseGuid", "6610100577214922753");
        bizModel.put("brandGuid", "33");
        bizModel.put("terminalType", 10);
        request.setBizModel(bizModel);

        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setAllianceId("aaaa");
        userInfoModel.setEnterpriseGuid("6506431195651982337");
        userInfoModel.setStoreGuid("6506453252643487745");
        userInfoModel.setBrandGuid("6608640567255498752");
        userInfoModel.setSource(100);

        Map<String, String> header = new HashMap<>();
        header.put("userInfo", JSON.toJSONString(userInfoModel));
        // 发送请求
        CommonResponse response = client.execute(request, header);

        if (response.isSuccess()) {
            // 返回结果
            String body = response.getBody();
            System.out.println("kk:"+body);
        } else {
            System.out.println("错误，subCode:" + response.getSubCode() + ", subMsg:" + response.getSubMsg());
        }
    }






    // 文件上传
    public void testUpload() throws IOException {
        DemoFileUploadRequest request = new DemoFileUploadRequest();

        DemoFileUploadModel model = new DemoFileUploadModel();
        model.setRemark("上传文件参数");
        request.setBizModel(model);

        String root = System.getProperty("user.dir");
        System.out.println(root);
        // 这里演示将resources下的两个文件上传到服务器
        request.addFile(new UploadFile("file1", new File(root + "/src/main/resources/file1.txt")));
        request.addFile(new UploadFile("file2", new File(root + "/src/main/resources/file2.txt")));

        DemoFileUploadResponse response = client.execute(request);

        System.out.println("--------------------");
        if (response.isSuccess()) {
            List<DemoFileUploadResponse.FileMeta> responseFiles = response.getFiles();
            System.out.println("您上传的文件信息：");
            responseFiles.forEach(System.out::println);
        } else {
            System.out.println(JSON.toJSONString(response));
        }
        System.out.println("--------------------");
    }

}
*/
