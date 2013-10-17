package com.gm.osoa.action.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
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

import com.gm.osoa.action.base.basic.EmpEntity;
import com.gm.osoa.common.StringHelper;
import com.gm.osoa.common.SysTpChooser;
import com.gm.osoa.orm.mybatis.model.Dept;
import com.gm.osoa.orm.mybatis.model.DeptExample;
import com.gm.osoa.orm.mybatis.model.Emp;
import com.gm.osoa.orm.mybatis.model.EmpExample;

@Controller
@Scope("session")
@RequestMapping(value = "/basic/emp")
public class EmpAction extends EmpEntity {
	/**
	 * 进入list页面
	 * 
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("basic/emp/index");
		return modelAndView;
	}

	/**
	 * 分页列表
	 * 
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
			HttpServletResponse response, @RequestParam("page") int page,
			@RequestParam("rows") int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		EmpExample example = new EmpExample();
		map = empService.pageByExample(example, "intotime desc", page,
				pageSize);
		rows = (List<Emp>)map.get("rows");
		for(Emp emp:rows){
			dept = deptService.selectByPrimaryKey(emp.getDeptId());
			emp.setDeptId(dept.getDeptName());
			emp.setPosts(SysTpChooser.getText(6, emp.getPosts()));
		}
		return map;
	}
	
	/**
	 * 进入new页面
	 * 
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("basic/emp/add");
		return modelAndView;
	}
	
	@RequestMapping(value = "/initTp", method = { RequestMethod.POST })
	@ResponseBody
	public String initTp(@RequestParam("tp") int tp){
		if(tp==7)sign = true;
		return SysTpChooser.parseToJson(tp);
	}
	
	/**
	 * 保存数据
	 * @return
	 */
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	@ResponseBody
	public String save(@ModelAttribute Emp record){
		String flag = "failure";
		record.setEmpId(StringHelper.uuid());
		record.setEmpPwd(StringHelper.md5String("123456"));
		StringHelper.emptyToNull(record);
		if(empService.insert(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 进入编辑页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public ModelAndView edit(@RequestParam("empId") String empId){
		ModelAndView modelAndView = new ModelAndView("basic/emp/edit");
		modelAndView.addObject("empId", empId);
		return modelAndView;
	}
	
	/**
	 * 初始化页面数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET })
	@ResponseBody
	public Emp init(@RequestParam("empId") String empId) throws Exception{
		while(!sign){
			Thread.sleep(10);
		}
		record= empService.selectByPrimaryKey(empId);
		StringHelper.nullToEmpty(record);
		empPwd = record.getEmpPwd();
		return record;
	}
	
	/**
	 * 修改数据
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public String update(@ModelAttribute Emp record){
		String flag = "failure";
		record.setEmpPwd(empPwd);
		StringHelper.emptyToNull(record);
		if(empService.updateByPrimaryKey(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 进入详细信息页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	public ModelAndView view(@RequestParam("empId") String empId){
		return edit(empId);
	}
	
	/**
	 * 删除数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET })
	@ResponseBody
	public String delete(@RequestParam(value="empId",required=false) String empId){
		String flag = "failure";
		if(empService.deleteByPrimaryKey(empId)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 重置密码
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/resetPass", method = { RequestMethod.POST })
	@ResponseBody
	public String resetPass(@RequestParam(value="empId",required=false) String empId,
			@RequestParam(value="opwd",required=false) String opwd,
			@RequestParam(value="npwd",required=false) String npwd){
		String flag = "failure";
		Emp record= empService.selectByPrimaryKey(empId);
		if(!record.getEmpPwd().equals(StringHelper.md5String(opwd))){
			flag = "oldfail";
		}else{
			record.setEmpPwd(StringHelper.md5String(npwd));
			if(empService.updateByPrimaryKey(record)>0)
				flag = "success";
		}
		return flag;
	}
	
	/**
	 * 进入个人信息修改
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/info", method = { RequestMethod.GET })
	public ModelAndView info(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("basic/emp/info");
		modelAndView.addObject("empId", ((Emp)request.getSession().getAttribute("emp")).getEmpId());
		return modelAndView;
	}
	
	/**
	 * 进入密码信息修改
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/pwd", method = { RequestMethod.GET })
	public ModelAndView pwd(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("basic/emp/pwd");
		modelAndView.addObject("empId", ((Emp)request.getSession().getAttribute("emp")).getEmpId());
		return modelAndView;
	}
}
