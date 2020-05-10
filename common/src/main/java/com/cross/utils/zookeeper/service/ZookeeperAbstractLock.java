//package com.hpkj.utils.zookeeper.service;
//
//
//import org.I0Itec.zkclient.ZkClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @ProjectName: qianxiaohao
// * @ClassName: ZookeeperAbstractLock
// * @Author: dary
// * @Description:
// * @Version: 1.0
// */
//
//public abstract class ZookeeperAbstractLock implements ExtLock {
//
//
//    private static final Logger log = LoggerFactory.getLogger(ZookeeperAbstractLock.class);
//
//
//    /**
//     * 集群地址
//     */
////    protected String CONNECTION="127.0.0.1:2181";
//
////
////    protected ZookeeperLockLocalUtil zookeeperLockLocalUtil=new ZookeeperLockLocalUtil();
////
////    protected ZkClient zkClient=new ZkClient(zookeeperLockLocalUtil.url);
//
//
//    protected CountDownLatch countDownLatch = new CountDownLatch(1);
//
//    public void getLock(String lockPath, ZkClient zkClient) {
//        if (tryLock(lockPath, zkClient)) {
//            log.info("#####获取锁成功######");
//        } else {
//            waitLock(lockPath, zkClient);
//            getLock(lockPath, zkClient);
//        }
//    }
//
//    /**
//     * 获取锁
//     *
//     * @param lockPath
//     * @return
//     */
//    public abstract boolean tryLock(String lockPath, ZkClient zkClient);
//
//
//    /**
//     * 等待锁
//     *
//     * @return
//     */
//    public abstract void waitLock(String lockPath, ZkClient zkClient);
//
//    /**
//     * 释放锁
//     */
//    @Override
//    public void unLock(ZkClient zkClient) {
//        if (zkClient != null) {
//            log.info("######释放锁######");
//            zkClient.close();
//
//        }
//
//
//    }
//
//
//}
