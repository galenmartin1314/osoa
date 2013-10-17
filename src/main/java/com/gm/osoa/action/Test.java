package com.gm.osoa.action;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gm.osoa.common.StringHelper;
import com.gm.osoa.orm.mybatis.model.SysTp;
import com.gm.osoa.orm.mybatis.service.impl.SysTpServiceImpl;
@Controller
public class Test {
	@Inject
	private SysTpServiceImpl sysTpService; 
	
	@RequestMapping(value="/ih",method={RequestMethod.GET})
	public void ih(HttpServletRequest request,HttpServletResponse response){
		//String home = "北京、上海、天津、重庆、辽宁、吉林、黑龙江、河北、山西、陕西、甘肃、青海、山东、安徽、江苏、浙江、河南、湖北、湖南、江西、台湾、福建、云南、海南、四川、贵州、广东、内蒙古、新疆、广西、西藏、宁夏、香港、澳门";
		String home = "汉、蒙古、回、藏、维吾尔、苗、彝、壮、布依、朝鲜、满、侗、瑶、白、土家、哈尼、哈萨克、傣、黎、傈傈、佤、畲、高山、拉祜、水、东乡、纳西、景颇、柯尔克孜、土、达斡尔、仫佬、羌、布朗、撒拉、毛南、仡佬、锡伯、阿昌、普米、塔吉克、怒、乌兹别克、俄罗斯、鄂温克、德昂、保安、裕固、京、塔塔尔、独龙、鄂伦春、赫哲、门巴、珞巴、基诺";
		String h[] = home.split("、");
		int code = 1;
		for(int idx=0;idx<h.length;idx++){
			SysTp st = new SysTp();
			st.setTpId(StringHelper.uuid());
			String hc = String.valueOf(code);
			for(int i=0;i<3-hc.length();i++){hc="0"+hc;}
			st.setTpCode("n"+hc);
			st.setTpName(h[idx]+"族");
			st.setTpType("NATION");
			sysTpService.insert(st);
			code++;
		}
	}
}
