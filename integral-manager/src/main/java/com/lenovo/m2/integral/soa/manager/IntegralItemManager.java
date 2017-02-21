package com.lenovo.m2.integral.soa.manager;

import com.lenovo.m2.integral.soa.domain.IntegralItem;

/**
 * Created by admin on 2017/2/20.
 */
public interface IntegralItemManager {

    public int addIntegralItem(IntegralItem integralItem);

    public int updateIntegralItem(IntegralItem integralItem);

    public int deleteIntegralItem(String itemId);

    public IntegralItem getIntegralItem(String itemId);

}
