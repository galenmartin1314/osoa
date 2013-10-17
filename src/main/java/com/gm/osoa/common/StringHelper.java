package com.gm.osoa.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {
	public static SimpleDateFormat DATETIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat DATETIMEWITHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat DATE_FORMAT1 = new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat DATETIME_FORMAT1 = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@SuppressWarnings("finally")
	public static Date StringToDateTime(String source){
		Date rev = null;
		try {
			rev = DATETIME_FORMAT.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static String DateTimeToString(Date source){
		String rev = "";
		try {
			rev = DATETIME_FORMAT.format(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static Date StringToDateTimeWithOut_(String source){
		Date rev = null;
		try {
			rev = DATETIME_FORMAT1.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static String DateTimeToStringWithOut_(Date source){
		String rev = "";
		try {
			rev = DATETIME_FORMAT1.format(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static String DateTimeToStringWithMS(Date source){
		String rev = "";
		try {
			rev = DATETIMEWITHMS_FORMAT.format(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static Date StringWithWSToDatime(String source){
		Date rev = null;
		try {
			rev = DATETIMEWITHMS_FORMAT.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	public static Date dateAddition(Date date,int addition){
		long time = date.getTime();
		time = time + (addition * 24 * 60 * 60 * 1000);
		date.setTime(time);
		return date;
	}
	
	public static Date dateSubtraction(Date date,int addition){
		long time = date.getTime();
		time = time + (addition * 24 * 60 * 60 * 1000);
		date.setTime(time);
		return date;
	}

	@SuppressWarnings("finally")
	public static Date StringToDate(String source){
		Date rev = null;
		try {
			rev = DATE_FORMAT.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static String DateToString(Date source){
		String rev = "";
		try {
			rev = DATE_FORMAT.format(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static String DateToStringWithOut_(Date source){
		String rev = "";
		try {
			rev = DATE_FORMAT1.format(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	@SuppressWarnings("finally")
	public static Date StringToDateWithOut_(String source){
		Date rev = null;
		try {
			rev = DATE_FORMAT1.parse(source);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			return rev;
		}
	}
	
	public static String replaceBlank(String before){
		String after = "";
		Pattern p = Pattern.compile("\t|\r|\n");
		Matcher m = p.matcher(before);
		after = m.replaceAll("");
		return after;
	}
	
	public static String uuid(){
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
	
	@SuppressWarnings("finally")
	public static String md5String(String source){
		String md5 = null;
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'}; 
		try {
			//返回实现指定摘要算法的 MessageDigest 对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			//使用utf-8编码将originstr字符串编码并保存到source字节数组
			byte[] bt = source.getBytes("utf-8");
			//使用指定的 byte 数组更新摘要
			md.update(bt);
			//通过执行诸如填充之类的最终操作完成哈希计算，结果是一个128位的长整数
			byte[] tmp = md.digest();
			//用16进制数表示需要32位
			char[] str = new char[32];
			for(int i=0,j=0; i < 16; i++){

                //j表示转换结果中对应的字符位置

                //从第一个字节开始，对 MD5 的每一个字节

                //转换成 16 进制字符

                byte b = tmp[i];

                //取字节中高 4 位的数字转换

                //无符号右移运算符>>> ，它总是在左边补0

                //0x代表它后面的是十六进制的数字. f转换成十进制就是15

                str[j++] = hexDigits[b>>>4 & 0xf];

                // 取字节中低 4 位的数字转换

                str[j++] = hexDigits[b&0xf];

            }
			md5 = new String(str);//结果转换成字符串用于返回
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return md5;
		}
		
	}

	public static void emptyToNull(Object entity){
		Class<? extends Object> clazz = entity.getClass();
		Field[] fs = clazz.getDeclaredFields();
		for(Field f:fs){
			if(f.getType().equals(String.class) ){
				try {
					f.setAccessible(true);
					if(f.get(entity).toString().trim().equals("")){
						f.set(entity, null);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static void nullToEmpty(Object entity){
		Class<? extends Object> clazz = entity.getClass();
		Field[] fs = clazz.getDeclaredFields();
		for(Field f:fs){
			if(f.getType().equals(String.class) ){
				try {
					f.setAccessible(true);
					if(f.get(entity)==null)f.set(entity, "");
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(uuid());
	}

}
