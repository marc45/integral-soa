package com.lenovo.m2.integral.soa.api;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;

/**
 * Created by admin on 2017/2/24.
 * 积分兑换优惠券服务
 */
public interface ExchangeCouponRecordService {

    public RemoteResult exchangeCoupon(String shopId,String couponId,String agentId,String agentCode,String buyerId);

    public RemoteResult<ExchangeCouponRecord> getExchangeRecord(String uuid);

    public RemoteResult<PageModel2<ExchangeCouponRecord>> getIntegralExchangeByPage(PageQuery pageQuery,ExchangeCouponRecord exchangeCouponRecord);


}
