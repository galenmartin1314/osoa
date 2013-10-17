package com.gm.osoa.action.basic;

import java.util.ArrayList;
import java.util.List;
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

import com.gm.osoa.action.base.basic.DeptEntity;
import com.gm.osoa.common.StringHelper;
import com.gm.osoa.orm.mybatis.model.Dept;
import com.gm.osoa.orm.mybatis.model.DeptExample;

@Controller
@Scope("session")
@RequestMapping(value = "/basic/dept")
public class DeptAction extends DeptEntity {
	/**
	 * 进入list页面
	 * 
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("basic/dept/index");
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
		DeptExample example = new DeptExample();
		return deptService.pageByExample(example, "dept_no desc", page,
				pageSize);
	}
	
	/**
	 * 初始化上级列表
	 * @return
	 */
	@RequestMapping(value = "/initParent", method = { RequestMethod.GET })
	@ResponseBody
	public Object initParent() throws Exception{
		sign = false;
		StringBuffer parent = new StringBuffer();
		//选择顶级
		DeptExample example = new DeptExample();
		example.createCriteria().andSupIdIsNull();
		example.setOrderByClause("dept_no");
		List<Dept> lp = deptService.selectByExample(example);
		parent.append("[{\"id\":\"0\",\"text\":\"部门列表\",\"children\":[");
		boolean first = true;
		for(Dept dp:lp){
			//选择子级
			example = new DeptExample();
			example.createCriteria().andSupIdEqualTo(dp.getDeptId());
			example.setOrderByClause("dept_no");
			List<Dept> sub = deptService.selectByExample(example);
			if(first){
				parent.append("{\"id\":\"")
					.append(dp.getDeptId())
					.append("\",\"text\":\"")
					.append(dp.getDeptName())
					.append("\"");
				if(sub!=null && sub.size()>0)parent.append(",\"state\":\"closed\"");
			}else{
				parent.append(",{\"id\":\"")
				.append(dp.getDeptId())
				.append("\",\"text\":\"")
				.append(dp.getDeptName())
				.append("\"");
				if(sub!=null && sub.size()>0)parent.append(",\"state\":\"closed\"");
			}
			if(sub!=null && sub.size()>0)initSub(parent,dp.getDeptId(),sub);
			parent.append("}");
			first = false;
		}
		parent.append("]}]");
		sign = true;
		return parent.toString();
	}
	
	private StringBuffer initSub(StringBuffer parent,String pid,List<Dept> ls){
		if(ls!=null && ls.size()>0){
			parent.append(",\"children\":[");
			boolean first = true;
			for(Dept dp:ls){
				DeptExample example = new DeptExample();
				example.createCriteria().andSupIdEqualTo(pid);
				example.setOrderByClause("dept_no");
				List<Dept> sub = deptService.selectByExample(example);
				if(first){
					parent.append("{\"id\":\"")
						.append(dp.getDeptId())
						.append("\",\"text\":\"")
						.append(dp.getDeptName())
						.append("\"");
					if(sub!=null && sub.size()>0)parent.append(",\"state\":\"closed\"");
				}else{
					parent.append(",{\"id\":\"")
					.append(dp.getDeptId())
					.append("\",\"text\":\"")
					.append(dp.getDeptName())
					.append("\"");
					if(sub!=null && sub.size()>0)parent.append(",\"state\":\"closed\"");
				}
				if(sub!=null && sub.size()>0)initSub(parent,dp.getDeptId(),sub);
				parent.append("}");
				first = false;
			}
			parent.append("]");
		}
		return parent;
	}
	
	/**
	 * 进入new页面
	 * 
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET })
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("basic/dept/add");
		return modelAndView;
	}
	
	/**
	 * 保存数据
	 * @return
	 */
	@RequestMapping(value = "/save", method = { RequestMethod.POST })
	@ResponseBody
	public String save(@ModelAttribute Dept record){
		String flag = "failure";
		record.setDeptId(StringHelper.uuid());
		if(record.getSupId().equals("") || record.getSupId().equals("0"))record.setSupId(null);
		if(deptService.insert(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 进入编辑页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/edit", method = { RequestMethod.GET })
	public ModelAndView edit(@RequestParam("deptId") String deptId){
		ModelAndView modelAndView = new ModelAndView("basic/dept/edit");
		modelAndView.addObject("deptId", deptId);
		return modelAndView;
	}
	
	/**
	 * 初始化页面数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/init", method = { RequestMethod.GET })
	@ResponseBody
	public Dept init(@RequestParam("deptId") String deptId) throws Exception{
		while(!sign){
			Thread.sleep(10);
		}
		Dept tmp= deptService.selectByPrimaryKey(deptId);
		StringHelper.nullToEmpty(tmp);
		return tmp;
	}
	
	/**
	 * 修改数据
	 * @return
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public String update(@ModelAttribute Dept record){
		String flag = "failure";
		if(record.getSupId().equals("") || record.getSupId().equals("0"))record.setSupId(null);
		if(deptService.updateByPrimaryKey(record)>0)
			flag = "success";
		return flag;
	}
	
	/**
	 * 进入详细信息页面
	 * @param np
	 * @return
	 */
	@RequestMapping(value = "/view", method = { RequestMethod.GET })
	public ModelAndView view(@RequestParam("deptId") String deptId){
		return edit(deptId);
	}
	
	/**
	 * 删除数据
	 * @param tpId
	 * @return
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET })
	@ResponseBody
	public String delete(@RequestParam(value="deptId",required=false) String deptId){
		String flag = "failure";
		if(deptService.deleteByPrimaryKey(deptId)>0)
			flag = "success";
		return flag;
	}
}
