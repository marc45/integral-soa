package com.lenovo.m2.integral.soa.manager.impl;

import com.lenovo.m2.integral.soa.dao.CouponInfoDao;
import com.lenovo.m2.integral.soa.domain.IntegralCoupon;
import com.lenovo.m2.integral.soa.manager.IntegralCouponManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/2/20.
 */
@Component("integralCouponManager")
@Transactional
public class IntegralCouponManagerImpl implements IntegralCouponManager {

    @Autowired
    private CouponInfoDao couponInfoDao;

    @Override
    public int addIntegralCoupon(IntegralCoupon integralCoupon) {
        return couponInfoDao.addCoupon(integralCoupon);
    }

    @Override
    public int deleteIntegralCoupon(String couponId) {
        return couponInfoDao.deleteCoupon(couponId);
    }

    @Override
    public int updateIntegralCoupon(IntegralCoupon integralCoupon) {
        return couponInfoDao.updateCoupon(integralCoupon);
    }

    @Override
    public IntegralCoupon getIntegralCoupon(String couponId) {
        return couponInfoDao.getCoupon(couponId);
    }
}
