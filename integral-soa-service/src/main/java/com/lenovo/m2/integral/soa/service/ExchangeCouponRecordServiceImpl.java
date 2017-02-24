package com.lenovo.m2.integral.soa.service;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.api.ExchangeCouponRecordService;
import com.lenovo.m2.integral.soa.domain.ExchangeCouponRecord;
import com.lenovo.m2.integral.soa.manager.ExchangeCouponRecordManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/2/24.
 */
@Service("exchangeCouponRecordService")
public class ExchangeCouponRecordServiceImpl implements ExchangeCouponRecordService {

    @Autowired
    private ExchangeCouponRecordManager exchangeCouponRecordManager;

    /**
     * 详情页立即兑换接口，兑换优惠券
     * @param couponId 优惠券id
     * @param memberId 兑换人id
     * @param lenovoId 经销商id
     * @return
     */
    @Override
    public RemoteResult exchangeCoupon(String couponId, String memberId, String lenovoId) {
        return null;
    }

    /**
     * 根据主键查询兑换记录
     * @param uuid 兑换记录主键
     * @return
     */
    @Override
    public RemoteResult<ExchangeCouponRecord> getExchangeRecord(String uuid) {
        return null;
    }

    /**
     * 分页查询兑换记录
     * @param pageQuery 分页条件对象
     * @param exchangeCouponRecord  查询条件对象
     * @return
     */
    @Override
    public RemoteResult<PageModel2<ExchangeCouponRecord>> getIntegralExchangeByPage(PageQuery pageQuery, ExchangeCouponRecord exchangeCouponRecord) {
        return null;
    }
}
