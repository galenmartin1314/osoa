package com.gm.osoa.common;

public class Constant {
	public static final String[] SYSTP={"HOME","NATION","CARDS","STUDENTS","BOOKS","STAR","MONEY","ZHENGZHI"};
	public static final String[] SYSTP_CN={"籍贯","民族","证件","学历","专业","职称","职务","政治面貌"};
	
	/**
	 * 获取系统设置类别
	 * @param index
	 * @return
	 */
	public static String getSysTp(int index){
		return SYSTP[index];
	}
	
	/**
	 * 获取系统设置类别中文描述
	 * @param index
	 * @return
	 */
	public static String getSysTpCn(int index){
		return SYSTP_CN[index];
	}
}
