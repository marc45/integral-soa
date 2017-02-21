package com.lenovo.m2.integral.soa.service;

import com.lenovo.b2c.goods.api.NewGoodsService;
import com.lenovo.common.base.PageMap;
import com.lenovo.fis.client.ServicesClient;
import com.lenovo.fis.model.DProductsManage;
import com.lenovo.m2.arch.framework.domain.RemoteResult;
import com.lenovo.m2.integral.soa.api.ItemBindingCouponService;
import com.lenovo.m2.integral.soa.domain.IntegralCoupon;
import com.lenovo.m2.integral.soa.domain.IntegralItem;
import com.lenovo.m2.integral.soa.manager.IntegralCouponManager;
import com.lenovo.m2.integral.soa.manager.IntegralItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/2/16.
 */
@Service("itemBindingCouponService")
public class ItemBindingCouponServiceImpl implements ItemBindingCouponService{

    @Autowired
    private IntegralItemManager integralItemManager;

    @Autowired
    private IntegralCouponManager integralCouponManager;

    //商品服务
    private NewGoodsService proService = ServicesClient.getInstance().getService(NewGoodsService.class);

    /**
     * 添加积分商品和优惠券的绑定信息
     * @param itemId
     * @param couponId
     * @return
     */
    @Override
    public RemoteResult addItemBindingCoupon(String itemId, String couponId) {

        RemoteResult remoteResult = new RemoteResult();

        try {
            //调用商品接口，获取信息，存储到对应的数据表中

            PageMap pageMap = new PageMap();
            pageMap.putSelectParams("code",itemId);

            PageMap pageMap1 = proService.pageQuery(pageMap);
            List<DProductsManage> pageList = (List<DProductsManage>) pageMap1.getPageList();

            DProductsManage dProductsManage = pageList.get(0);
            String name = dProductsManage.getName();
            Integer isPhysical = dProductsManage.getIsPhysical();

            IntegralItem integralItem = new IntegralItem();
            integralItem.setItemId(itemId);
            integralItem.setCouponId(couponId);
            integralItem.setItemName(name);
            integralItem.setBindingType(isPhysical);

            integralItemManager.addIntegralItem(integralItem);

            //TODO
            //根据优惠券id获取优惠券信息

            IntegralCoupon integralCoupon = new IntegralCoupon();
            integralCoupon.setCouponId(couponId);
            //TODO


            remoteResult.setSuccess(true);
            remoteResult.setResultMsg("绑定成功");
        }catch (Exception e){
            remoteResult.setResultMsg("绑定失败");
            e.printStackTrace();
        }

        return remoteResult;
    }

    /**
     * 根据商品code查询绑定的优惠券信息
     * @param itemId
     * @return
     */
    @Override
    public RemoteResult<IntegralCoupon> getCouponInfo(String itemId) {

        RemoteResult<IntegralCoupon> remoteResult = new RemoteResult<IntegralCoupon>();

        try {

            //先根据商品code，查询到绑定的优惠券的id
            IntegralItem integralItem = integralItemManager.getIntegralItem(itemId);
            String couponId = integralItem.getCouponId();

            //TODO
            //调用优惠券接口，根据id获取优惠券信息，返回


            remoteResult.setSuccess(true);
            remoteResult.setResultMsg("成功");
        }catch (Exception e){
            remoteResult.setResultMsg("系统异常");
            e.printStackTrace();
        }
        return remoteResult;
    }
}
