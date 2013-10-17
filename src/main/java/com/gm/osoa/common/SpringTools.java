package com.gm.osoa.common;

import org.springframework.web.context.WebApplicationContext;

/**
 * @author: Galen
 * @date: 2012-9-13
 * @time: 上午11:34:50
 */
public class SpringTools {
	private static WebApplicationContext ctxx = null;
	
	public static void setCtx(WebApplicationContext ctx){
		ctxx = ctx;
	}
	//ID获取
	public static Object getBean(String id){
		return ctxx.getBean(id);
	}
	//类型获取
	public static Object getBean(Class clazz){
		return ctxx.getBean(clazz);
	}
}
