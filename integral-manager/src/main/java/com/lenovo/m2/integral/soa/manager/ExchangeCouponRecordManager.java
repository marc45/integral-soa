package com.lenovo.m2.integral.soa.manager;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;

/**
 * Created by admin on 2017/2/24.
 */
public interface ExchangeCouponRecordManager {

    public int addExchangeRecord(ExchangeCouponRecord exchangeCouponRecord);

    public int deleteExchangeRecord(String uuid);

    public ExchangeCouponRecord getExchangeRecord(String uuid);

    public PageModel2<ExchangeCouponRecord> getExchangeRecordByPage(PageQuery pageQuery,ExchangeCouponRecord exchangeCouponRecord);

}
