package com.lenovo.m2.integral.soa.service.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by admin on 2017/8/1.
 * 单元测试基类
 */
//表示整合JUnit4进行测试
@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration(locations = {
        "classpath:spring-config.xml",
        "classpath:applicationContext-propertiesResource.xml",
        "classpath:spring-mybatis.xml",
        "classpath:mybatis-config.xml",
        "classpath:provider.xml"
})
public class BaseServiceTest {

}
