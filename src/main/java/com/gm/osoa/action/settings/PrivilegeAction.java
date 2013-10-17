package com.gm.osoa.action.settings;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.osoa.action.base.settings.PrivilegeEntity;
import com.gm.osoa.common.Py;
import com.gm.osoa.orm.mybatis.model.Privilege;
import com.gm.osoa.orm.mybatis.model.PrivilegeExample;
@Controller
@Scope("session")
@RequestMapping(value = "/settings/privi")
public class PrivilegeAction extends PrivilegeEntity {
	/**
	 * 生成系统菜单
	 * @return
	 */
	@RequestMapping(value = "/menu", method = { RequestMethod.GET }, produces = "plain/text; charset=UTF-8")
	@ResponseBody
	private String menu() throws Exception{
		StringBuffer sm = new StringBuffer();
		sm.append("var sysMenu = {")
		  .append("createMenu:function(){")
		  .append("var win_height=$(window).height();")
		  .append("$('#startmenu').css('height',win_height+'px');")
		  .append("var menuC = $('#navigator');")
		  .append("menuC.css('height',win_height+'px');")
		  .append("menuC.css('width',$('#startmenu').width()+'px');")
		  .append("menuC.accordion({fit:true});")
		  .append("var ul = null;")
		  .append("var li = null;")
		  .append("var href = null;");
		//生成主菜单
		PrivilegeExample example = new PrivilegeExample();
		example.createCriteria().andMorfEqualTo(0);
		example.setOrderByClause("sortno");
		rows = privilegeService.selectByExample(example);
		Privilege tmp = null;
		boolean first = false;
		for(Privilege record:rows){
			if(record.getPid()==null){
				//主菜单
				if(tmp!=null)mm(tmp, sm);
				tmp = record;
				first = true;
			}else{
				if(first)sm.append("ul = $('<ul></ul>');");
				//子菜单
				sm.append("li = $(\"<li onclick=\\\"myDesk.createApp({id:'")
				  .append(Py.getPinYin(record.getPriName().trim()))
				  .append("',frameurl:'")
				  .append(record.getPriUrl())
				  .append("',title:'")
				  .append(record.getPriName())
				  .append("',barIcon:'")
				  .append(record.getBarIcon())
				  .append("',iconCls:'")
				  .append(record.getIconCls())
				  .append("'");
				if(record.getWw()>0){
					sm.append(",width:")
					  .append(record.getWw())
					  .append(",height:")
					  .append(record.getWh())
					  .append(",maximizable:false,minimizable:false");
				}
				sm.append("});\\\"></li>\");")
				  .append("href = $(\"<img src=\\\"")
				  .append(record.getMicon())
				  .append("\\\"/><span>　")
				  .append(record.getPriName())
				  .append("</span>\");")
				  .append("li.append(href);")
				  .append("ul.append(li);");
				first = false;
			}
		}
		//创建最后一个主菜单
		if(rows!=null && rows.size()>0)mm(tmp, sm);
		sm.append("menuC.children().find('li').bind('click',function(){myDesk.menuShowOrHide(true);});")
		  .append("myDesk.menuShowOrHide(true);}}");
//		return  new String(sm.toString().getBytes(), "ISO-8859-1");
		return sm.toString();
	}
	
	/**
	 * 生成主菜单代码
	 * @param record
	 * @param sm
	 */
	private void mm(Privilege record, StringBuffer sm){
		sm.append("menuC.accordion('add',{")
		  .append("title:'")
		  .append(record.getPriName())
		  .append("',")
		  .append("iconCls: '")
		  .append(record.getIconCls())
		  .append("',")
		  .append("content: ul,");
		if(record.getPriName().trim().equals("个人信息")){
			sm.append("selected: true");
		}else{
			sm.append("selected: false");
		}
		sm.append("});");
	}
}
