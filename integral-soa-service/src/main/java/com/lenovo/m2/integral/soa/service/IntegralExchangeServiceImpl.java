package com.lenovo.m2.integral.soa.service;

import com.lenovo.m2.arch.framework.domain.PageModel2;
import com.lenovo.m2.arch.framework.domain.PageQuery;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.api.IntegralExchangeService;
import com.lenovo.m2.integral.soa.domain.IntegralExchange;
import com.lenovo.m2.integral.soa.domain.IntegralExchangeByPage;
import com.lenovo.m2.integral.soa.manager.IntegralExchangeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/2/16.
 */
@Service("integralExchangeService")
public class IntegralExchangeServiceImpl implements IntegralExchangeService {

    @Autowired
    private IntegralExchangeManager integralExchangeManager;


    @Override
    public RemoteResult addIntegralExchange(IntegralExchange integralExchange) {

        RemoteResult remoteResult = new RemoteResult();

        try {

            int i = integralExchangeManager.addIntegralExchange(integralExchange);

            if (i==0){
                remoteResult.setResultMsg("添加失败");
            }else {
                remoteResult.setSuccess(true);
            }

        }catch (Exception e){
            remoteResult.setResultMsg("添加失败");
            e.printStackTrace();
        }

        return remoteResult;
    }

    @Override
    public RemoteResult<PageModel2<IntegralExchange>> getIntegralExchangeByPage(PageQuery pageQuery, IntegralExchangeByPage integralExchangeByPage) {

        RemoteResult<PageModel2<IntegralExchange>> remoteResult = new RemoteResult<PageModel2<IntegralExchange>>();

        try {

            PageModel2<IntegralExchange> page = integralExchangeManager.getIntegralExchangeByPage(pageQuery, integralExchangeByPage);
            if (page!=null){
                remoteResult.setSuccess(true);
                remoteResult.setT(page);
            }
        }catch (Exception e){
            remoteResult.setResultMsg("系统异常");
            e.printStackTrace();
        }

        return remoteResult;
    }

    @Override
    public RemoteResult deleteIntegralExchange(IntegralExchange integralExchange) {

        RemoteResult remoteResult = new RemoteResult();

        try {

            int i = integralExchangeManager.deleteIntegralExchange(integralExchange);
            remoteResult.setSuccess(true);

        }catch (Exception e){
            remoteResult.setResultMsg("删除失败");
            e.printStackTrace();
        }


        return remoteResult;
    }
}
