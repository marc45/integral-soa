package com.lenovo.m2.integral.soa.launcher;

import com.lenovo.m2.integral.soa.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Provider {

    private static final Logger LOGGER = LoggerFactory.getLogger(Provider.class);

    private static volatile boolean running = true;

    private static ApplicationContext ctx;


    public static void main(String[] args) {
        try {
            ctx = new ClassPathXmlApplicationContext(
                    new String[]{
                            "classpath:spring-config.xml",
                            "classpath:applicationContext-propertiesResource.xml",
                            "classpath:spring-mybatis.xml",
                            "classpath:mybatis-config.xml",
                            "provider.xml"
                    }
            );

            App app = (App) ctx.getBean("app");
            app.test();


            LOGGER.info("SOA服务启动 over！一切正常！Dubbo service server started!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            running = false;
            LOGGER.error("SOA服务启动 over！失败！异常信息=[" + e.getMessage() + "]", e);
            System.exit(1);
        }
        synchronized (Provider.class) {
            while (running) {
                try {
                    Provider.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }

}
