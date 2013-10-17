package com.gm.osoa.action.settings;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gm.osoa.action.base.settings.SysTpEntity;
import com.gm.osoa.common.Constant;
import com.gm.osoa.common.StringHelper;
import com.gm.osoa.orm.mybatis.model.SysTp;
import com.gm.osoa.orm.mybatis.model.SysTpExample;

@Controller
@Scope("session")
@RequestMapping(value = "/settings/systp")
public class SysTpAction extends SysTpEntity {
	/**
	 * 进入list页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView index(@RequestParam("np") int np){
		ModelAndView modelAndView = new ModelAndView("settings/systp/index");
		modelAndView.addObject("np", Constant.getSysTp(np));
		modelAndView.addObject("zh_cn", Constant.getSysTpCn(np));
		return modelAndView;
	}
	
	/**
	 * 分页列表
	 * @param request
	 * @param response
	 * @param tp
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.POST })
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("tp") String tp,
			@RequestParam("page") int page, @RequestParam("rows") int pageSize) {
		SysTpExample example = new SysTpExample();
		example.createCriteria().andTpTypeEqualTo(tp);
		return sysTpService.pageByExample(example, "tp_code desc", page, pageSize);
	}
	
	/**
	 * 进入新增页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public ModelAndView add(@RequestParam("np") String np){
		ModelAndView modelAndView = new ModelAndView("settings/systp/add");
		modelAndView.addObject("np", np);
		return modelAndView;
	}
	
	/**
	 * 保存数据
	 * @return
	 */
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	@ResponseBody
	public String save(@ModelAttribute SysTp record){
		String flag = "failure";
		record.setTpId(StringHelper.uuid());
		if(sysTpService.insert(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 进入编辑页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public ModelAndView edit(@RequestParam("np") String np,@RequestParam("tpId") String tpId){
		ModelAndView modelAndView = new ModelAndView("settings/systp/edit");
		modelAndView.addObject("tpId", tpId);
		return modelAndView;
	}
	
	/**
	 * 初始化页面数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET })
	@ResponseBody
	public SysTp init(@RequestParam("tpId") String tpId){
		return sysTpService.selectByPrimaryKey(tpId);
	}
	
	/**
	 * 修改数据
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public String update(@ModelAttribute SysTp record){
		String flag = "failure";
		if(sysTpService.updateByPrimaryKey(record)>0)
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
	public String delete(@RequestParam(value="tpId",required=false) String tpId){
		String flag = "failure";
		if(sysTpService.deleteByPrimaryKey(tpId)>0)
			flag = "success";
		return flag;
	}
}
