package com.lenovo.m2.integral.soa.domain;

import com.lenovo.m2.arch.framework.domain.Money;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/2/24.
 */
public class CouponAndIntegralInfo implements Serializable {

    private String couponId;//优惠券id
    private String couponName;//优惠券名称
    private Money couponMoney;//优惠券金额
    private String useScope;//优惠券适用范围
    private String platform;//可以使用的平台
    private Date fromtime;//有效期开始时间
    private Date totime;//有效期结束时间
    private Date getstarttime;//领取开始时间
    private Date getendtime;//领取结束时间
    private Integer integralNum;//兑换所需积分
    private Integer maxNum;//最大发放张数
    private String createId;//创建人id
    private Date createtime;//创建时间
    private String updateId;//修改人id
    private Date updatetime;//修改时间
    private Integer state;//是否启用，0停用，1启用

    private Date date;//当前时间
    private Integer sellout;

    public Integer getSellout() {
        return sellout;
    }

    public void setSellout(Integer sellout) {
        this.sellout = sellout;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Date getFromtime() {
        return fromtime;
    }

    public void setFromtime(Date fromtime) {
        this.fromtime = fromtime;
    }

    public Date getTotime() {
        return totime;
    }

    public void setTotime(Date totime) {
        this.totime = totime;
    }

    public Date getGetstarttime() {
        return getstarttime;
    }

    public void setGetstarttime(Date getstarttime) {
        this.getstarttime = getstarttime;
    }

    public Date getGetendtime() {
        return getendtime;
    }

    public void setGetendtime(Date getendtime) {
        this.getendtime = getendtime;
    }

    public Integer getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Integer integralNum) {
        this.integralNum = integralNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
