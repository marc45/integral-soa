package com.lenovo.m2.integral.soa.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

public class JacksonUtil {
	
	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
	
	public static final ObjectMapper mapper = new ObjectMapper();

	static {
		/**
		 * 设置将时间转换成指定的格式
		 */
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		/**
		 * 该特性决定了当遇到未知属性（没有映射到属性，没有任何setter或者任何可以处理它的handler），是否应该抛出一个JsonMappingException异常。
		 * 这个特性一般式所有其他处理方法对未知属性处理都无效后才被尝试，属性保留未处理状态。
		 * 默认情况下，该设置是被打开的。
		 */
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//OM.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		/**
		 * 是否允许一个类型没有注解表明打算被序列化。默认true，抛出一个异常；否则序列化一个空对象，比如没有任何属性
		 */
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
	}

	public static String toJson(Object obj) {
		StringWriter writer = new StringWriter();
		JsonGenerator gen;
		try {
			gen = new JsonFactory().createJsonGenerator(writer);
			mapper.writeValue(gen, obj);
			gen.close();
			String json = writer.toString();
			writer.close();
			return json;
		} catch (IOException e) {
			logger.warn(e.getMessage(),e);
		}
		
		return null;
	}
	
	public static <T> T fromJson(String json, Class<T> classOfT) {
		Object object;
		try {
			object = mapper.readValue(json, classOfT);
			return (T) object;
        } catch (JsonParseException e) {
            logger.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            logger.error(e.getMessage(), e);
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
		return null;
	}
}

