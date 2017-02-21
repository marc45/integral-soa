package com.lenovo.m2.integral.soa.manager.impl;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.dao.IntegralExchangeDao;
import com.lenovo.m2.integral.soa.domain.IntegralExchange;
import com.lenovo.m2.integral.soa.domain.IntegralExchangeByPage;
import com.lenovo.m2.integral.soa.manager.IntegralExchangeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/2/20.
 */
@Component("integralExchangeManager")
@Transactional
public class IntegralExchangeManagerImpl implements IntegralExchangeManager {

    @Autowired
    private IntegralExchangeDao integralExchangeDao;

    @Override
    public int addIntegralExchange(IntegralExchange integralExchange) {
        return integralExchangeDao.addIntegralExchange(integralExchange);
    }

    @Override
    public int deleteIntegralExchange(IntegralExchange integralExchange) {
        return integralExchangeDao.deleteIntegralExchange(integralExchange);
    }

    @Override
    public PageModel2<IntegralExchange> getIntegralExchangeByPage(PageQuery pageQuery, IntegralExchangeByPage integralExchangeByPage) {
        PageModel<IntegralExchange> pageModel = integralExchangeDao.getIntegralExchangeByPage(pageQuery, integralExchangeByPage);
        PageModel2<IntegralExchange> page = new PageModel2<IntegralExchange>(pageModel);
        return page;
    }

}
