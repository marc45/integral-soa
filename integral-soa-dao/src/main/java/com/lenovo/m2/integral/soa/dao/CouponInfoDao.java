package com.lenovo.m2.integral.soa.dao;

import com.lenovo.m2.integral.soa.domain.IntegralCoupon;

/**
 * Created by admin on 2017/2/16.
 */
public interface CouponInfoDao {

    /**
     * 添加积分商品绑定的优惠券的信息
     * @param integralCoupon
     */
    public int addCoupon(IntegralCoupon integralCoupon);

    /**
     * 根据优惠券id修改优惠券信息
     * @param integralCoupon
     * @return
     */
    public int updateCoupon(IntegralCoupon integralCoupon);

    /**
     * 根据优惠券id删除优惠券信息
     * @param couponId
     * @return
     */
    public int deleteCoupon(String couponId);

    /**
     * 根据优惠券id查询优惠券信息
     * @param couponId
     * @return
     */
    public IntegralCoupon getCoupon(String couponId);

}
