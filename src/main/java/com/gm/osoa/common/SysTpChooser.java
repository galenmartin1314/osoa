package com.gm.osoa.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gm.osoa.orm.mybatis.model.SysTp;
import com.gm.osoa.orm.mybatis.model.SysTpExample;
import com.gm.osoa.orm.mybatis.service.impl.SysTpServiceImpl;

public class SysTpChooser {
	private static final Map<String,Object> CHOOOER = new HashMap<String,Object>();
	/**
	 * 将系统类型初始化到内存
	 */
	public static void init(){
		SysTpServiceImpl service = (SysTpServiceImpl)SpringTools.getBean(SysTpServiceImpl.class);
		for(String st : Constant.SYSTP){
			SysTpExample example = new SysTpExample();
			example.createCriteria().andTpTypeEqualTo(st);
			List<SysTp> lt = service.selectByExample(example);
			CHOOOER.put(st, lt);
		}
	}
	
	/**
	 * 返回json数据
	 * @param key
	 * @return
	 */
	public static String parseToJson(int keyId){
		StringBuffer json = new StringBuffer();
		json.append("[");
		json.append("{\"value\":\"\",\"text\":\"---请选择---\",\"selected\":true}");
		List<SysTp> lt = (List<SysTp>)CHOOOER.get(Constant.getSysTp(keyId));
		if(lt!=null && lt.size()>0){
			for(int index=0;index<lt.size();index++){
				SysTp record = (SysTp)lt.get(index);
				json.append(",{\"value\":\"")
//					.append(index+1)
					.append(record.getTpId())
					.append("\",\"text\":\"")
					.append(record.getTpName())
					.append("\"}");
			}
		}
		json.append("]");
		return json.toString();
	}
	
//	/**
//	 * ;返回指定类型的指定ID值
//	 * @param key
//	 * @param index
//	 * @return
//	 */
//	public static String getId(int keyId,int index){
//		if(index<0)return null;
//		String id = null;
//		List<SysTp> lt = (List<SysTp>)CHOOOER.get(Constant.getSysTp(keyId));
//		if(lt!=null && lt.size()>0){
//			SysTp record = (SysTp)lt.get(index);
//			id = record.getTpId();
//		}
//		return id;
//	}
//	
	/**
	 * 返回指定id的Index 
	 * @param keyId
	 * @param id
	 * @return
	 */
	public static String getText(int keyId,String id){
		String text = "";
		if(id==null)return text;
		List<SysTp> lt = (List<SysTp>)CHOOOER.get(Constant.getSysTp(keyId));
		for(int index=0;index<lt.size();index++){
			SysTp tp = lt.get(index);
			if(tp.getTpId().equals(id)){
				text = tp.getTpName();
				break;
			}
		}
		return text;
	}
}