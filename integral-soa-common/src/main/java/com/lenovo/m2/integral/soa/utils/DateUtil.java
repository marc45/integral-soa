package com.lenovo.m2.integral.soa.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2017/10/17.
 * 日期工具类
 */
public class DateUtil {

    /**
     * 根据日期获取其属于哪个季度
     * 季度规则：1、2、3为第一季度，以此类推。
     * @param date
     * @return
     */
    public static int getQuarter(Date date) {
        int quarter = 0;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch(month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                quarter = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                quarter = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                quarter = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                quarter = 4;
                break;
            default:
                break;
        }
        return quarter;
    }

}
