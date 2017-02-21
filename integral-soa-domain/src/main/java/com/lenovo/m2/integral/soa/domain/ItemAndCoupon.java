package com.lenovo.m2.integral.soa.domain;

import java.io.Serializable;

/**
 * Created by admin on 2017/2/16.
 */
public class ItemAndCoupon implements Serializable {

    /**
     * 积分商品信息
     */
    private IntegralItem integralItem;

    /**
     * 积分商品绑定的优惠券信息
     */
    private IntegralCoupon integralCoupon;

    public IntegralItem getIntegralItem() {
        return integralItem;
    }

    public void setIntegralItem(IntegralItem integralItem) {
        this.integralItem = integralItem;
    }

    public IntegralCoupon getIntegralCoupon() {
        return integralCoupon;
    }

    public void setIntegralCoupon(IntegralCoupon integralCoupon) {
        this.integralCoupon = integralCoupon;
    }
}
