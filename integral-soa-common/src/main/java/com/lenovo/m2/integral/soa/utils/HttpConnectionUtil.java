package com.lenovo.m2.integral.soa.utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnectionUtil {
	public static String VB_ERROR = "{\"rc\":1,\"msg\":\"VB请求异常\"}";
	public static String ERROR = "{\"ret\":1,\"msg\":\"请求错误\"}";
	
	private static Logger log= Logger.getLogger(HttpConnectionUtil.class);

	/**
	 * 请求参数类型为普通
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String getHttpContent(String url, String params) {
		HttpURLConnection connection = null;
		String content = "";
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.setDoOutput(true);
			connection.getOutputStream().write(params.getBytes());
			// 得到访问页面的返回值
			int response_code = connection.getResponseCode();
			if (response_code == HttpURLConnection.HTTP_OK) {
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in, "UTF-8"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					content += line;
				}
				return content;
			}
		} catch (MalformedURLException e) {
			log.error("MalformedURL", e);
		} catch (IOException e) {
			log.error("IO exception", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return VB_ERROR;
	}

	/**
	 * 请求参数类型为普通
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String getHttpPostContent(String url, String params) {
		HttpURLConnection connection = null;
		String content = "";
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.setDoOutput(true);
			connection.getOutputStream().write(params.getBytes());
			// 得到访问页面的返回值
			int response_code = connection.getResponseCode();
			if (response_code == HttpURLConnection.HTTP_OK) {
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in, "UTF-8"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					content += line;
				}
				return content;
			}
		} catch (MalformedURLException e) {
			log.error("MalformedURL", e);
		} catch (IOException e) {
			log.error("IO exception", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return ERROR;
	}

	/**
	 * 请求参数类型为json
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String getHttpContentJSON(String url, String params) {
		HttpURLConnection connection = null;
		String content = "";
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type",
					"application/json;charset=utf-8");
			connection.setConnectTimeout(20000);
			connection.setReadTimeout(10000);
			connection.setDoOutput(true);
			connection.getOutputStream().write(params.getBytes());
			// 得到访问页面的返回值
			int response_code = connection.getResponseCode();
			if (response_code == HttpURLConnection.HTTP_OK) {
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in, "UTF-8"));
				String line = null;
				while ((line = reader.readLine()) != null) {
					content += line;
				}
				return content;
			}
		} catch (MalformedURLException e) {
			log.error("MalformedURL", e);
		} catch (IOException e) {
			log.error("IO exception", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return VB_ERROR;
	}


	public static String getHttpContentGet(String url) {
		HttpURLConnection connection = null;
		String content = "";
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(10000);
			connection.setReadTimeout(10000);
			connection.setDoOutput(true);
			// 得到访问页面的返回值
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in, "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				content += line;
			}
			return content;
		} catch (MalformedURLException e) {
			log.error("MalformedURL", e);
		} catch (IOException e) {
			log.error("IO exception", e);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return content;
	}
	
    public static void main(String[] args){
//        String url ="http://10.99.121.57:8080/group/getGroups?ticket=5e9b6d3d-4500-47fc-b32b-f2b4a1230fd3";
//        String responseBody = HttpConnectionUtil.sendGETByHttpClient(url);
//        System.out.println("responseBody="+responseBody);
//        JSONObject jsonObject = JSONObject.fromObject(responseBody);
//        System.out.println("jsonObject="+jsonObject);
//        System.out.println(jsonObject.getString("ret"));
//        JSONArray jsonArray = jsonObject.getJSONArray("groups");
//        System.out.println("jsonArray="+jsonArray);
//        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
//        System.out.println("code="+jsonObject1.optLong("code"));
//        String str = "90 黄金会员,15 黄金会员,89 Test组,88 测试组1,59 校园代理组,58 小新特供组";
//        String[] arg = str.split(",");
//        for(String s : arg){
//            System.out.println("s="+s);
//            String[] codearag = s.split(" ");
//            System.out.println("code========="+s.split(" ")[0]);
//
//        }
//        try {
//            String createtime ="2015-09-09 10:10:10";
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date data1 = formatter.parse(createtime);
//            Date date2 = new Date();
//
//            System.out.println("data1="+data1);
//            System.out.println("date2="+date2);
//
//
//
//            System.out.println("data1="+data1.getTime());
//            System.out.println("date2="+date2.getTime());
//            if(data1.getTime() > date2.getTime()){
//                System.out.println("注册时间大于发券时间");
//            }else {
//                System.out.println("注册时间小于发券时间");
//            }
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//
//        for(int i=1;i<100;i++){
//            String url ="http://10.96.12.15/user/getcreatetime?ticket=e1176c13-1f8a-480f-a751-3f874df82249&lenovoid=10058084659";
//        String responseBody = HttpConnectionUtil.sendGETByHttpClient(url);
//            System.out.println("responseBody="+responseBody);
//        }

    }
}
