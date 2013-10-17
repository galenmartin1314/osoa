package com.gm.osoa.action.settings;

import java.util.Date;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.osoa.action.base.settings.RolesEntity;
import com.gm.osoa.common.StringHelper;
import com.gm.osoa.orm.mybatis.model.Roles;
import com.gm.osoa.orm.mybatis.model.RolesExample;
@Controller
@Scope("session")
@RequestMapping(value = "/settings/roles")
public class RolesAction extends RolesEntity {
	/**
	 * 进入list页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("settings/roles/index");
		return modelAndView;
	}
	
	/**
	 * 分页列表
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> list(@RequestParam("page") int page, @RequestParam("rows") int pageSize) {
		RolesExample example = new RolesExample();
		return rolesService.pageByExample(example, "udate desc", page, pageSize);
	}
	
	/**
	 * 进入new页面
	 * 
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("settings/roles/add");
		return modelAndView;
	}
	
	/**
	 * 保存数据
	 * @return
	 */
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	@ResponseBody
	public String save(@ModelAttribute Roles record){
		String flag = "failure";
		record.setRoleid(StringHelper.uuid());
		record.setCdate(new Date());
		record.setUdate(record.getCdate());
		if(rolesService.insert(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 进入编辑页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public ModelAndView edit(@RequestParam("roleid") String roleid){
		ModelAndView modelAndView = new ModelAndView("settings/roles/edit");
		modelAndView.addObject("roleid", roleid);
		return modelAndView;
	}
	
	/**
	 * 初始化页面数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET })
	@ResponseBody
	public Roles init(@RequestParam("roleid") String roleid) throws Exception{
		Roles tmp= rolesService.selectByPrimaryKey(roleid);
		StringHelper.nullToEmpty(tmp);
		return tmp;
	}
	
	/**
	 * 修改数据
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public String update(@ModelAttribute Roles record){
		String flag = "failure";
		record.setUdate(new Date());
		if(rolesService.updateByPrimaryKey(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 删除数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET })
	@ResponseBody
	public String delete(@RequestParam(value="roleid",required=false) String roleid){
		String flag = "failure";
		if(rolesService.deleteByPrimaryKey(roleid)>0)
			flag = "success";
		return flag;
	}
}
