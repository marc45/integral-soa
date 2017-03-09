package com.lenovo.m2.integral.soa.manager.impl;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.dao.ExchangeCouponRecordDao;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;
import com.lenovo.m2.integral.soa.manager.ExchangeCouponRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/2/24.
 */
@Component("exchangeCouponRecordManager")
@Transactional
public class ExchangeCouponRecordManagerImpl implements ExchangeCouponRecordManager {

    @Autowired
    private ExchangeCouponRecordDao exchangeCouponRecordDao;

    @Override
    public int addExchangeRecord(ExchangeCouponRecord exchangeCouponRecord) {
        return exchangeCouponRecordDao.addExchangeRecord(exchangeCouponRecord);
    }

    @Override
    public int deleteExchangeRecord(String uuid) {
        return exchangeCouponRecordDao.deleteExchangeRecord(uuid);
    }

    @Override
    public ExchangeCouponRecord getExchangeRecord(String uuid) {
        return exchangeCouponRecordDao.getExchangeRecord(uuid);
    }

    @Override
    public PageModel2<ExchangeCouponRecord> getExchangeRecordByPage(PageQuery pageQuery, ExchangeCouponRecord exchangeCouponRecord) {
        PageModel<ExchangeCouponRecord> pageModel = exchangeCouponRecordDao.getExchangeRecordByPage(pageQuery, exchangeCouponRecord);
        PageModel2<ExchangeCouponRecord> pageModel2 = new PageModel2<ExchangeCouponRecord>(pageModel);
        return pageModel2;
    }
}
