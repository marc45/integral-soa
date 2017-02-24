package com.lenovo.m2.integral.soa.manager.impl;

import com.lenovo.m2.arch.framework.domain.PageModel;
import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.integral.soa.dao.CouponAndIntegralInfoDao;
import com.lenovo.m2.integral.soa.domain.CouponAndIntegralInfo;
import com.lenovo.m2.integral.soa.manager.CouponAndIntegralInfoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by admin on 2017/2/24.
 */
@Component("couponAndIntegralInfoManager")
@Transactional
public class CouponAndIntegralInfoManagerImpl implements CouponAndIntegralInfoManager {

    @Autowired
    private CouponAndIntegralInfoDao couponAndIntegralInfoDao;

    @Override
    public int addCouponInfo(CouponAndIntegralInfo couponAndIntegralInfo) {
        return couponAndIntegralInfoDao.addCouponInfo(couponAndIntegralInfo);
    }

    @Override
    public int updateCouponInfo(CouponAndIntegralInfo couponAndIntegralInfo) {
        return couponAndIntegralInfoDao.updateCouponInfo(couponAndIntegralInfo);
    }

    @Override
    public CouponAndIntegralInfo getCouponInfo(String couponId) {
        return couponAndIntegralInfoDao.getCouponInfo(couponId);
    }

    @Override
    public PageModel2<CouponAndIntegralInfo> getCouponInfoByPage(PageQuery pageQuery, CouponAndIntegralInfo couponAndIntegralInfo) {
        PageModel<CouponAndIntegralInfo> pageModel = couponAndIntegralInfoDao.getCouponInfoByPage(pageQuery, couponAndIntegralInfo);
        PageModel2<CouponAndIntegralInfo> pageModel2 = new PageModel2<CouponAndIntegralInfo>(pageModel);
        return pageModel2;
    }

    @Override
    public List<CouponAndIntegralInfo> getAllCouponInfo(CouponAndIntegralInfo couponAndIntegralInfo) {
        return couponAndIntegralInfoDao.getAllCouponInfo(couponAndIntegralInfo);
    }
}
