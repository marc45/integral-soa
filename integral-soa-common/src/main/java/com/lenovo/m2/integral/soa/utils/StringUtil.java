package com.lenovo.m2.integral.soa.utils;

import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
	
	private static final Logger LOG = Logger.getLogger(StringUtil.class);

	public static boolean isNotNull(Object obj){
		return obj!=null;
	}

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

	public static boolean isNull(Object obj){
		return obj==null;
	}

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

	public static boolean isNotEmpty(String key){
		if(key!=null && !"".equals(key.trim())){
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String...keys){
		if (keys!=null){
			for (String key :keys) {
				if (StringUtil.isEmpty(key)) {
					return false;
				}
			}
		}else {
			return false;
		}
		return true;
	}
	
	public static boolean isEmpty(String key){
		if(key!=null && !"".equals(key.trim())){
			return false;
		}
		return true;
	}
	
	public static boolean isEmpty(String...keys){
		if (keys!=null){
			for (String key :keys) {
				if (StringUtil.isEmpty(key)) {
					return true;
				}
			}
		}else {
			return true;
		}
		return false;
	}
	
	public static String decimalFormatPrice(String param){
		if(param==null||"".equals(param)){
			param = "0.00";
		}
        double tmp = Double.parseDouble(param);
        DecimalFormat df=new DecimalFormat("0.00");
        return df.format(tmp);
	}
	
	public static String cleanXss(String str){
		if (str == null || "".equals(str.trim())) {
			return "";
		}
		str = str.replaceAll(" ","");
		return str;
	}
	
	/**
	 * @description 以*(分号)分隔的字符串，去除首尾的*(分号)。
	 * @author qinhc
	 * @createTime 2015上午11:05:00
	 * @param str
	 * @param trim
	 * @return
	 */
	public static String StrRemoveTrim(String str,String trim){
		// str=;2;; 
		String resultStr="";
		String[] strList=str.split(trim);
		for(String s:strList){
			if(!"".equals(s)&&null!=s){
				resultStr=resultStr+s+trim;
			}
		}
		if(resultStr.length()>0){
			resultStr=resultStr.substring(0,resultStr.length()-1);
		}
		return resultStr;
	}

//	public static Pair<Boolean, Double> isDecimalNumeric(String content){
//		Pair<Boolean, Double> result = new Pair<>(false, null);
//		if(StringUtils.isNotBlank(content)){
//			try {
//				double value = Double.parseDouble(content);
//				result.setKey(true);
//				result.setValue(value);
//			} catch (Exception e) {
//				LOG.error("occur error:", e);
//			}
//		}
//		return result;
//	}
	
	/**
	 * 是否手机号 简单校验11位数字
	 * @param str
	 * @return
	 * @author wangrq1
	 */
	public static boolean isPhone(String str){
		Matcher m =  NUM_11.matcher(str);
		return m.matches();
	}
	
	static Pattern NUM_11 = Pattern.compile("\\d{11}");



	/**
	  * 判断是否为整数
	  * @param str 传入的字符串
	  * @return 是整数返回true,否则返回false
	*/
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/** 
	* @Title: 空字符串转0 
	* @Description: null或空字符串转0 
	* @author 2015年9月15日 下午3:36:26 BY zhanghs
	* @param temp
	* @return String
	* @throws
	 */
	public static String conVertNull2Zero(String temp) {
		if (null == temp || StringUtil.isEmpty(temp.trim())) {
			return "0";
		}
		return temp;
	}
}
