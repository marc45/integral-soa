package com.lenovo.m2.integral.soa.service;

/**
 * Created by admin on 2017/9/28.
 * service基类，添加参数非空校验方法
 */
public class BaseService {

    //校验单个对象是否为不为空
    public static boolean isNotNull(Object obj){
        return obj!=null;
    }

    //校验多个对象是否都不为空
    public static boolean isNotNull(Object...objs){
        if (objs!=null){
            for (Object obj : objs) {
                if (obj==null){
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    //校验单个对象是否为空
    public static boolean isNull(Object obj){
        return obj==null;
    }

    //检验多个对象中，是否有为空的
    public static boolean isNull(Object...objs){
        if (objs!=null){
            for (Object obj : objs) {
                if (obj==null){
                    return true;
                }
            }
        }else {
            return true;
        }
        return false;
    }

    //校验单个字符串是否不为空
    public static boolean isNotEmpty(String key){
        if(key!=null && !"".equals(key.trim())){
            return true;
        }
        return false;
    }

    //校验多个字符串是否都不为空
    public static boolean isNotEmpty(String...keys){
        if (keys!=null){
            for (String key :keys) {
                if (isEmpty(key)) {
                    return false;
                }
            }
        }else {
            return false;
        }
        return true;
    }

    //校验单个字符串是否为空
    public static boolean isEmpty(String key){
        if(key!=null && !"".equals(key.trim())){
            return false;
        }
        return true;
    }

    //检验多个字符串中，是否有为空的
    public static boolean isEmpty(String...keys){
        if (keys!=null){
            for (String key :keys) {
                if (isEmpty(key)) {
                    return true;
                }
            }
        }else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
