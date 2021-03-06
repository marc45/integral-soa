package com.lenovo.m2.integral.soa.domain;

import com.lenovo.m2.arch.framework.domain.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/2/24.
 */
public class ExchangeCouponRecord implements Serializable {

    private String uuid;//uuid生成主键
    private String agentId;//兑换人id
    private Date exchangetime;//兑换时间
    private Integer integralNum;//兑换使用积分
    private String couponId;//优惠券id
    private String couponName;//优惠券名称
    private Money couponMoney;//优惠券金额
    private String currencyCode;//货币编码
    private String agentCode;//兑换人code

    private Date begintime;//分页查询开始时间
    private Date endtime;//分页查询截止时间

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Date getExchangetime() {
        return exchangetime;
    }

    public void setExchangetime(Date exchangetime) {
        this.exchangetime = exchangetime;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Integer integralNum) {
        this.integralNum = integralNum;
    }

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

    public Money getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(Money couponMoney) {
        this.couponMoney = couponMoney;
    }
}
