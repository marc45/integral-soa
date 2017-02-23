package com.lenovo.m2.integral.soa.api;

import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.domain.IntegralCoupon;

/**
 * Created by admin on 2017/2/16.
 */
public interface ItemBindingCouponService {

    /**
     * 添加积分商品绑定优惠券信息
     * @param itemId
     * @param couponId
     * @return
     */
    public RemoteResult addItemBindingCoupon(String itemId,String couponId,String memberId);

    /**
     * 根据商品code，获取优惠券信息
     * @param itemId
     * @return
     */
    public RemoteResult<IntegralCoupon> getCouponInfo(String itemId);



}
