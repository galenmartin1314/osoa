package com.gm.osoa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.osoa.action.base.UserLoginEntity;
import com.gm.osoa.common.StringHelper;
import com.gm.osoa.orm.mybatis.model.EmpExample;

@Controller
public class UserLogin extends UserLoginEntity {
//	private void http(){request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();}
	
	
	@RequestMapping(value="/app",method={RequestMethod.POST})
	public String login(HttpServletRequest request,HttpServletResponse response,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("vcode") String vcode) throws Exception{
		boolean flag = false;
		//获取session验证码
		String vc = request.getSession().getAttribute("vc").toString();
		//通过用户名查询
		EmpExample example = new EmpExample();
		example.createCriteria().andEmpCodeEqualTo(username);
		emp = empService.selectOneByExample(example);
		if(emp==null){
			request.setAttribute("message", "该用户不存在!");
		}else if(!emp.getEmpPwd().equals(StringHelper.md5String(password))){
			request.setAttribute("message", "密码输入错误!");
		}else if(!vcode.equalsIgnoreCase(vc)){
			request.setAttribute("message", "验证码输入错误!");
		}else{
			flag = true;
		}
		if(flag){
			//setting session
			request.getSession().setAttribute("emp", emp);
			//record log
			return "app";
		}else{
			return "index";
		}
	}
	
	@RequestMapping(value="/logout",method={RequestMethod.GET})
	public String logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//释放session
		System.out.println("User Logout");
		request.getSession().invalidate();
		return null;
	}
	
	@RequestMapping(value="/getvc",method={RequestMethod.GET})
	@ResponseBody
	public String getvc(HttpServletRequest request,HttpServletResponse response) throws Exception{
		return request.getSession().getAttribute("vc").toString();
	}
}

