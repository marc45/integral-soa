package com.lenovo.m2.integral.soa.domain;

import com.lenovo.m2.arch.framework.domain.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/2/16.
 */
public class IntegralCoupon implements Serializable {

    /**优惠券id*/
    private String couponId;
    /**优惠券名称*/
    private String couponName;
    /**优惠券金额*/
    private Money money;
    /**优惠券开始时间*/
    private Date begintime;
    /**优惠券结束时间*/
    private Date endtime;
    /**优惠券适用范围*/
    private String useScope;
    /**优惠券适用平台*/
    private String platform;

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getUseScope() {
        return useScope;
    }

    public void setUseScope(String useScope) {
        this.useScope = useScope;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
