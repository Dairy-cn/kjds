package com.cross.merchants.redis;


public class CartPrefix extends BasePrefix{

    public CartPrefix(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    /**
     * 设置购物车缓存
     */
    public static CartPrefix getCartList= new CartPrefix(0,"cart");



    /**
     * 设置收藏緩存
     */
    public static CartPrefix getCollectList= new CartPrefix(0,"collect:goods");

    /**
     * 设置关注緩存
     */
    public static CartPrefix getFollowList= new CartPrefix(0,"follow:store");


    /**
     * 设置弹窗广告
     */
    public static CartPrefix getPopAdList= new CartPrefix(86400,"adPop");
}
