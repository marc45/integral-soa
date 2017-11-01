package com.lenovo.m2.integral.soa.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 惠商积分奖励pojo
 */
public class IntegralReward implements Serializable{
    //主键id，自增
    private Long id;
    //用户id
    private String lenovoId;
    //订单号
    private Long orderCode;
    //商城id
    private Integer shopId;
    //唯一标识，1抛单成功推送，商品为49、68、95产品组的  0支付成功推送，商品为999产品组的
    private Integer payOrThrow;
    //订单资金流，0线上、1货到付款、2线下
    private Integer payMode;
    //抛单或者支付成功时间
    private Date payOrThrowTime;
    //商品code
    private String itemCode;
    //商品名称
    private String itemName;
    //商品实际支付金额，单位：分
    private Long itemPrice;
    //商品所属产品组
    private Integer itemGroupId;
    //商品物流、1是sec物流、2是其他
    private Integer itemLogistics;
    //商品行项目标识
    private Integer itemFlag;
    //发放积分数量
    private Integer integralNum;
    //积分发放状态，0未发放、1已发放
    private Integer status;

    private Date createTime;
    private String createBy;
    private Date updateTime;
    private String updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLenovoId() {
        return lenovoId;
    }

    public void setLenovoId(String lenovoId) {
        this.lenovoId = lenovoId == null ? null : lenovoId.trim();
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getPayOrThrow() {
        return payOrThrow;
    }

    public void setPayOrThrow(Integer payOrThrow) {
        this.payOrThrow = payOrThrow;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public Date getPayOrThrowTime() {
        return payOrThrowTime;
    }

    public void setPayOrThrowTime(Date payOrThrowTime) {
        this.payOrThrowTime = payOrThrowTime;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemGroupId() {
        return itemGroupId;
    }

    public void setItemGroupId(Integer itemGroupId) {
        this.itemGroupId = itemGroupId;
    }

    public Integer getItemLogistics() {
        return itemLogistics;
    }

    public void setItemLogistics(Integer itemLogistics) {
        this.itemLogistics = itemLogistics;
    }

    public Integer getItemFlag() {
        return itemFlag;
    }

    public void setItemFlag(Integer itemFlag) {
        this.itemFlag = itemFlag;
    }

    public Integer getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(Integer integralNum) {
        this.integralNum = integralNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}