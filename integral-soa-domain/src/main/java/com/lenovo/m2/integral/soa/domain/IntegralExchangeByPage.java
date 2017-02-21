package com.lenovo.m2.integral.soa.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2017/2/20.
 */
public class IntegralExchangeByPage implements Serializable {

    private String memberId;

    private Date begintime;

    private Date endtime;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}
