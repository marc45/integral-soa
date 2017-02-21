package com.lenovo.m2.integral.soa.dao;

import com.lenovo.m2.integral.soa.domain.IntegralItem;

/**
 * Created by admin on 2017/2/16.
 */
public interface IntegralItemBindingDao {

    /**
     * 添加积分商品信息
     * @param integralItem
     */
    public int addIntegralItem(IntegralItem integralItem);

    /**
     * 根据商品code查询积分商品信息
     * @param itemId
     * @return
     */
    public IntegralItem getIntegralItem(String itemId);

    /**
     * 根据商品code修改商品绑定信息
     * @param integralItem
     * @return
     */
    public int updateIntegralItem(IntegralItem integralItem);

    /**
     * 根据商品code删除商品绑定信息
     * @param itemId
     * @return
     */
    public int deleteIntegtalItem(String itemId);

}
