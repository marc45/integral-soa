package com.lenovo.m2.integral.soa.api;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.domain.IntegralExchange;
import com.lenovo.m2.integral.soa.domain.IntegralExchangeByPage;

/**
 * Created by admin on 2017/2/16.
 */
public interface IntegralExchangeService {

    public RemoteResult addIntegralExchange(IntegralExchange integralExchange);

    public RemoteResult<PageModel2<IntegralExchange>> getIntegralExchangeByPage(PageQuery pageQuery,IntegralExchangeByPage integralExchangeByPage);

    public RemoteResult deleteIntegralExchange(IntegralExchange integralExchange);

}
