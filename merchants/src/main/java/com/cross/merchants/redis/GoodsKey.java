package com.cross.merchants.redis;


public class GoodsKey extends BasePrefix{
    private GoodsKey(int expireSeconds,String prefix){
        super(expireSeconds,prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(600,"gl");
    public static GoodsKey getGoodsDetail = new GoodsKey(60,"gd");
    public static GoodsKey getGoodsStock = new GoodsKey(0,"gs");
}
