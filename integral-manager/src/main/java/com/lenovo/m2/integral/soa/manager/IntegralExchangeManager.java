package com.lenovo.m2.integral.soa.manager;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.domain.IntegralExchange;
import com.lenovo.m2.integral.soa.domain.IntegralExchangeByPage;

/**
 * Created by admin on 2017/2/20.
 */
public interface IntegralExchangeManager {

    public int addIntegralExchange(IntegralExchange integralExchange);

    public int deleteIntegralExchange(IntegralExchange integralExchange);

    public PageModel2<IntegralExchange> getIntegralExchangeByPage(PageQuery pageQuery,IntegralExchangeByPage integralExchangeByPage);

}
