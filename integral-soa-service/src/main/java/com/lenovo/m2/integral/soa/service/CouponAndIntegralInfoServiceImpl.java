package com.lenovo.m2.integral.soa.service;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.api.CouponAndIntegralInfoService;
import com.lenovo.m2.integral.soa.domain.CouponAndIntegralInfo;
import com.lenovo.m2.integral.soa.manager.CouponAndIntegralInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/2/24.
 */
@Service("couponAndIntegralInfoService")
public class CouponAndIntegralInfoServiceImpl implements CouponAndIntegralInfoService {

    @Autowired
    private CouponAndIntegralInfoManager couponAndIntegralInfoManager;

    /**
     * 根据优惠券id查询优惠券和积分信息
     * @param couponId 优惠券id
     * @return
     */
    @Override
    public RemoteResult<CouponAndIntegralInfo> getCouponInfo(String couponId) {
        return null;
    }

    /**
     * 添加优惠券和积分的绑定信息
     * @param couponId 优惠券id
     * @param memberId 绑定人id
     * @param integralNum 积分数量
     * @param state 是否显示，0不显示，1显示
     * @return
     */
    @Override
    public RemoteResult addCouponInfo(String couponId, String memberId, int integralNum, int state) {
        return null;
    }

    /**
     * 分页查询优惠券绑定积分的记录
     * @param pageQuery 分页条件对象
     * @param couponAndIntegralInfo 查询条件对象
     * @return
     */
    @Override
    public RemoteResult<PageModel2<CouponAndIntegralInfo>> getCouponInfoByPage(PageQuery pageQuery, CouponAndIntegralInfo couponAndIntegralInfo) {
        return null;
    }

    /**
     * 修改绑定记录，只能修改积分数量或者是否显示
     * @param memberId 修改人id
     * @param integralNum 积分数量
     * @param state 是否显示，0不显示，1显示
     * @return
     */
    @Override
    public RemoteResult updateCouponInfo(String memberId, int integralNum, int state) {
        return null;
    }

    /**
     * 前端页面获取所有可以兑换的优惠券信息
     * @return
     */
    @Override
    public RemoteResult<List<CouponAndIntegralInfo>> getAllCouponInfo() {
        return null;
    }
}
