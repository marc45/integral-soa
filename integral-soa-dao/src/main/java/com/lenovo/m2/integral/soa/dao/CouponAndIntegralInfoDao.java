package com.lenovo.m2.integral.soa.dao;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.domain.CouponAndIntegralInfo;

import java.util.List;

/**
 * Created by admin on 2017/2/24.
 */
public interface CouponAndIntegralInfoDao {

    public int addCouponInfo(CouponAndIntegralInfo couponAndIntegralInfo);

    public int updateCouponInfo(CouponAndIntegralInfo couponAndIntegralInfo);

    public CouponAndIntegralInfo getCouponInfo(String couponId);

    public PageModel<CouponAndIntegralInfo> getCouponInfoByPage(PageQuery pageQuery,CouponAndIntegralInfo couponAndIntegralInfo);

    public List<CouponAndIntegralInfo> getAllCouponInfo(CouponAndIntegralInfo couponAndIntegralInfo);

}
