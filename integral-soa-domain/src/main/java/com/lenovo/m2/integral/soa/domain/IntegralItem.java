package com.lenovo.m2.integral.soa.domain;

import java.io.Serializable;

/**
 * Created by admin on 2017/2/16.
 */
public class IntegralItem implements Serializable{

    /**积分商品id*/
    private String itemId;

    /**积分商品的名称*/
    private String itemName;
    /**优惠券id*/
    private String couponId;
    /**绑定的类型*/
    private Integer bindingType;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Integer getBindingType() {
        return bindingType;
    }

    public void setBindingType(Integer bindingType) {
        this.bindingType = bindingType;
    }

}
