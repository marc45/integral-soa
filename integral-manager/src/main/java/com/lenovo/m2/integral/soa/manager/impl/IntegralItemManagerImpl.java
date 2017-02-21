package com.lenovo.m2.integral.soa.manager.impl;

import com.lenovo.m2.integral.soa.dao.IntegralItemBindingDao;
import com.lenovo.m2.integral.soa.domain.IntegralItem;
import com.lenovo.m2.integral.soa.manager.IntegralItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/2/20.
 */
@Component("integralItemManager")
@Transactional
public class IntegralItemManagerImpl implements IntegralItemManager {

    @Autowired
    private IntegralItemBindingDao integralItemBindingDao;

    @Override
    public int addIntegralItem(IntegralItem integralItem) {
        return integralItemBindingDao.addIntegralItem(integralItem);
    }

    @Override
    public int updateIntegralItem(IntegralItem integralItem) {
        return integralItemBindingDao.updateIntegralItem(integralItem);
    }

    @Override
    public int deleteIntegralItem(String itemId) {
        return integralItemBindingDao.deleteIntegtalItem(itemId);
    }

    @Override
    public IntegralItem getIntegralItem(String itemId) {
        return integralItemBindingDao.getIntegralItem(itemId);
    }
}
