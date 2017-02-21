package com.lenovo.m2.integral.soa.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/2/16.
 */
public class IntegralExchange implements Serializable {

    /**订单号*/
    private String orderId;
    /**商品名称*/
    private String itemName;
    /**兑换积分*/
    private int integralNum;
    /**兑换时间*/
    private Date exchangeTime;
    /**经销商编码*/
    private String lenovoId;
    /**兑换人id*/
    private String memberId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(int integralNum) {
        this.integralNum = integralNum;
    }

    public Date getExchangeTime() {
        return exchangeTime;
    }

    public void setExchangeTime(Date exchangeTime) {
        this.exchangeTime = exchangeTime;
    }

    public String getLenovoId() {
        return lenovoId;
    }

    public void setLenovoId(String lenovoId) {
        this.lenovoId = lenovoId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
