//package com.hpkj.utils.zookeeper.lock;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Objects;
//
///**
// * @ProjectName: qianxiaohao
// * @ClassName: ZookeeperLockLocalUtil
// * @Author: dary
// * @Description:
// * @Version: 1.0
// */
//
//@Component
//public class ZookeeperLockLocalUtil {
//
//    private final Logger log = LoggerFactory.getLogger(ZookeeperLockLocalUtil.class);
//
//    @Value("${zookeeper.service}")
//    public String url;
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ZookeeperLockLocalUtil that = (ZookeeperLockLocalUtil) o;
//        return Objects.equals(log, that.log) &&
//            Objects.equals(url, that.url);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(log, url);
//    }
//
//    @Override
//    public String toString() {
//        return "ZookeeperLockLocalUtil{" +
//            "url='" + url + '\'' +
//            '}';
//    }
//}
