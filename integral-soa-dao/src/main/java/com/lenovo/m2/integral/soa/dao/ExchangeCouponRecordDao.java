package com.lenovo.m2.integral.soa.dao;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;

/**
 * Created by admin on 2017/2/24.
 */
public interface ExchangeCouponRecordDao {

    public int addExchangeRecord(ExchangeCouponRecord exchangeCouponRecord);

    public ExchangeCouponRecord getExchangeRecord(String uuid);

    public PageModel<ExchangeCouponRecord> getExchangeRecordByPage(PageQuery pageQuery,ExchangeCouponRecord exchangeCouponRecord);

}
