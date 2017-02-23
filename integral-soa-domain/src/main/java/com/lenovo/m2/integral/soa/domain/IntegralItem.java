package com.lenovo.m2.integral.soa.domain;

import java.io.Serializable;
import java.util.Date;

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
    /**创建人id*/
    private String createId;
    /**创建时间*/
    private Date createTime;
    /**最后修改人id*/
    private String updateId;
    /**最后修改时间*/
    private Date updateTime;

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

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
