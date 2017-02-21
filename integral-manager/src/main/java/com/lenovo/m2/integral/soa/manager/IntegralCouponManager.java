package com.lenovo.m2.integral.soa.manager;

import com.lenovo.m2.integral.soa.domain.IntegralCoupon;

/**
 * Created by admin on 2017/2/20.
 */
public interface IntegralCouponManager {

    public int addIntegralCoupon(IntegralCoupon integralCoupon);

    public int deleteIntegralCoupon(String couponId);

    public int updateIntegralCoupon(IntegralCoupon integralCoupon);

    public IntegralCoupon getIntegralCoupon(String couponId);

}
