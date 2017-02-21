package com.lenovo.m2.integral.soa.dao;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.domain.IntegralExchange;
import com.lenovo.m2.integral.soa.domain.IntegralExchangeByPage;

/**
 * Created by admin on 2017/2/16.
 */
public interface IntegralExchangeDao {

    /**
     * 添加积分兑换记录
     * @param integralExchange
     */
    public int addIntegralExchange(IntegralExchange integralExchange);

    /**
     * 分页查询兑换记录
     * @param pageQuery
     * @param integralExchangeByPage
     * @return
     */
    public PageModel<IntegralExchange> getIntegralExchangeByPage(PageQuery pageQuery,IntegralExchangeByPage integralExchangeByPage);

    /**
     * 根据用户id和订单id删除兑换记录，如果orderId为null，删除所有记录
     * @param integralExchange
     * @return
     */
    public int deleteIntegralExchange(IntegralExchange integralExchange);






}
