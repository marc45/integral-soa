package com.lenovo.m2.integral.soa.api;

/**
 * Created by admin on 2017/2/27.
 */
public class IntegralResultCode {

    public static final String SUCCESS = "0000";//兑换成功

    public static final String COUPON_UNUSABLE = "1001";//无法使用该优惠券

    public static final String INTEGRAL_LACK = "1002";//积分不足

    public static final String INTEGRAL_DEC_FAIL = "1003";//积分扣减失败

    public static final String BINDING_FAIL = "1004";//绑券失败

    public static final String GETCOUPONINFO_FAIL = "1005";//获取优惠券信息失败

    public static final String SELECT_FAIL = "1006";//没有查到绑定记录

    public static final String PARAMS_FAIL = "1007";//参数异常

    public static final String isExist = "1008";//已存在该优惠券的绑定记录，不能重复绑定

    public static final String FAIL = "9999";//系统异常


}
