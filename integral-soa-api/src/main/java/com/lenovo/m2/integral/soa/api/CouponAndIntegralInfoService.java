package com.lenovo.m2.integral.soa.api;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.domain.CouponAndIntegralInfo;

import java.util.List;

/**
 * Created by admin on 2017/2/24.
 * 积分绑定优惠券服务
 */
public interface CouponAndIntegralInfoService {

    public RemoteResult<CouponAndIntegralInfo> getCouponInfo(String couponId);

    public RemoteResult addCouponInfo(String couponId,String itcode,Integer integralNum,Integer state);

    public RemoteResult<PageModel2<CouponAndIntegralInfo>> getCouponInfoByPage(PageQuery pageQuery,CouponAndIntegralInfo couponAndIntegralInfo);

    public RemoteResult updateCouponInfo(String couponId,String itcode,Integer integralNum,Integer state);

    public RemoteResult<List<CouponAndIntegralInfo>> getAllCouponInfo();

}
