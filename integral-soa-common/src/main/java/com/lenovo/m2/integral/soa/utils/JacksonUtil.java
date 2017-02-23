package com.lenovo.m2.integral.soa.utils;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;

public class JacksonUtil {
	
	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
	
	public static final ObjectMapper mapper = new ObjectMapper();

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

