//package com.hpkj.utils.zookeeper.lock;
//
//import com.hpkj.utils.zookeeper.service.ZookeeperAbstractLock;
//import org.I0Itec.zkclient.IZkDataListener;
//import org.I0Itec.zkclient.ZkClient;
//
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @ProjectName: qianxiaohao
// * @ClassName: ZookeeperDistrbuteLock
// * @Author: dary
// * @Description:
// * @Version: 1.0
// */
//
//public class ZookeeperDistributeLock extends ZookeeperAbstractLock {
//
//
//    @Override
//    public boolean tryLock(String lockPath, ZkClient zkClient) {
//        try {
//            zkClient.createEphemeral(lockPath);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @Override
//    public void waitLock(String lockPath, ZkClient zkClient) {
//        //使用zookeeper临时事件监听
//        IZkDataListener iZkDataListener = new IZkDataListener() {
//            @Override
//            public void handleDataChange(String s, Object o) throws Exception {
//
//            }
//
//            @Override
//            public void handleDataDeleted(String s) throws Exception {
//                if (countDownLatch != null) {
//                    countDownLatch.countDown();
//                }
//            }
//
//        };
//        //注册时间通知
//        zkClient.subscribeDataChanges(lockPath, iZkDataListener);
//        if (zkClient.exists(lockPath)) {
//            countDownLatch = new CountDownLatch(1);
//            try {
//                countDownLatch.await();
//            } catch (Exception e) {
//
//            }
//        }
//        //监听完毕后，删除时间通知
//        zkClient.unsubscribeDataChanges(lockPath, iZkDataListener);
//    }
//
//}
