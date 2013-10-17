/**
 * 需要导入
 * jquery.js  map.js
 * 调用方式
 * <input type="text" id="username" name="username" verify="用户名/character-start-character-numeric-only:true/bw-len:6,12" />
 */

var $ve = new Map();
//初始化表单验证
var initVerify=function(){
	$(document).find("form").each(function(index,from){
		$form = $(from);
		var fmap = new Map();
		//查找Input文本框
		$form.find("input").each(function(index,dom){
			var $dom = $(dom);
			var vmap = new Map();
			if($dom.attr("type")=="text" || $dom.attr("type")=="password"){
				if($dom.attr("verify")!="undefined" && $dom.attr("verify")!=undefined){
					var vstr=$dom.attr("verify").split("/");
					var title = null;
					if(vstr.length>0){title = vstr[0];}
					//开始获取验证信息
					if(vstr.length>1){
						for(var idx=1;idx<vstr.length;idx++){
							var vac = vstr[idx].split(":");
							//特殊处理
							var lentxt = "";
							if(vac[0].indexOf("len")!=-1){
								lentxt = vac[1];
							}
							vmap.put(vac[0],title+altm.get(vac[0])+lentxt);
						}
					}
				}
			}
			if(vmap.size()>0)fmap.put($dom.attr("id"),vmap);
		});
		//查找文本域
		$form.find("textarea").each(function(index,dom){
			var $dom = $(dom);
			var vmap = new Map();
			if($dom.attr("verify")!="undefined" && $dom.attr("verify")!=undefined){
				var vstr=$dom.attr("verify").split("/");
				var title = null;
				if(vstr.length>0){title = vstr[0];}
				//开始获取验证信息
				if(vstr.length>1){
					for(var idx=1;idx<vstr.length;idx++){
						var vac = vstr[idx].split(":");
						//特殊处理
						var lentxt = "";
						if(vac[0].indexOf("len")!=-1){
							lentxt = vac[1];
						}
						vmap.put(vac[0],title+altm.get(vac[0])+lentxt);
					}
				}
			}
			if(vmap.size()>0)fmap.put($dom.attr("id"),vmap);
		});
		
		//将fmap方到验证序列中
		if(fmap.size()>0){
			var fid = $form.attr("id");
			$ve.put(fid,fmap);
			$form.submit(function(){
				return verifyForm(fid);
			});
		}
	});
}
//验证表单
var verifyForm=function(fid,nodlg){
	if($ve.get(fid)!="undefined" && $ve.get(fid)!=undefined && $ve.get(fid)!=null){
		var form = $ve.get(fid);
		var keys = form.keys();
		var flag = true;
		var disother = false;
		for(var key=0;key<keys.length;key++){
			var vmap = form.get(keys[key]);
			var vkeys = vmap.keys();
			var vkey=0;
			for(;vkey<vkeys.length;vkey++){
				//去除两端空格
				$("#"+keys[key]).val($("#"+keys[key]).val().trim());
				//不为空判断的其他判断
				if(vkeys[vkey]=="not-null" || $("#"+keys[key]).val()!=""){
					//判断
					if(typeof(vreg.get(vkeys[vkey]))=="function"){
						if(!vreg.get(vkeys[vkey]).call(function(){},$("#"+keys[key]).val(),vmap.get(vkeys[vkey]))){
							disother = true;
							flag=false;
							break;
						}
					}else{
						if(!vreg.get(vkeys[vkey]).test($("#"+keys[key]).val())){
							flag=false;
							break;
						}
					}
				}
			}
			if(!flag){
				if(disother){
					parent.myDesk.warm(specialmsg,keys[key],nodlg);
				}else{
					parent.myDesk.warm(vmap.get(vkeys[vkey]),keys[key],nodlg);
				}
				//$("#"+keys[key]).focus();
				break;
			}
		}
		return flag;
	}
}
//特殊提示信息
var specialmsg="";
//提示内容
var altm = new Map();
altm.put("not-null","不能为空!");//not-null:true
altm.put("positive-numeric-only","必须是正整数!");//positive-numeric-only:true
altm.put("negative-numeric-only","必须是负整数!");//negative-numeric-only:true
altm.put("integer-only","必须是整数!");//integer-only:true
altm.put("positive-float-only","必须是正小数!");//positive-float-only:true
altm.put("negative-float-only","必须是负小数!");//negative-float-only:true
altm.put("float-only","必须是小数!");//float-only:true
altm.put("numeric-only","必须是数字!");//numeric-only:true
altm.put("character-only","必须是[A-Za-z]的字母组合!");//character-only:true
altm.put("character-numeric-only","必须是[A-Za-z0-9]的字母、数字组合!");//character-numeric-only:true
altm.put("character-start-character-numeric-only","必须是以[A-Za-z]的字母开头后跟[A-Za-z0-9_]的字母、数字、下划线组合!");//character-start-character-numeric-only:true
altm.put("telno-only","格式不正确!");//telno-only:true
altm.put("mobile-only","格式不正确!");//mobile-only:true
altm.put("telno-mobile","格式不正确!");//telno-mobile:true
altm.put("post-only","格式不正确!");//post-only:true
altm.put("email-only","格式不正确!");//email-only:true
altm.put("website-only","格式不正确!");//website-only:true
altm.put("chinese-only","必须是中文!");//chinese-only:true
altm.put("cardid-only","格式不正确!");//cardid-only:true
altm.put("max-len","的文本长度应小于等于max_lengh!");//max-len:len
altm.put("min-len","的文本长度应大于等于min_lenth!");//min-len:len
altm.put("bw-len","的文本长度应大于等于min_lengh小于等于max_lengh!");//bw-len:minlen,maxlen
altm.put("fix-len","的文本长度应等于fix_lengh!");//fix-len:len

//验证的正则表达式
var vreg = new Map();
vreg.put("not-null",/^\s*(\S+\s*)+$/);//^[\w\s]+$
vreg.put("positive-numeric-only",/^\d+$/);
vreg.put("negative-numeric-only",/(^-\d+$)/);
vreg.put("integer-only",/^-?\d+$/);
vreg.put("positive-float-only",/^\d+\.\d+$/);
vreg.put("negative-float-only",/^-\d+\.\d+$/);
vreg.put("float-only",/^-?\d+\.\d+$/);
vreg.put("numeric-only",/(^-?\d+$)|(^-?\d+\.\d+$)/);
vreg.put("character-only",/^[A-Za-z]+$/);
vreg.put("character-numeric-only",/^\w+$/);
vreg.put("character-start-character-numeric-only",/^[A-Za-z]+\w+$/);
vreg.put("telno-only",/^(\d{3,4}|\d{3,4}-)?\d{7,8}$/);
vreg.put("mobile-only",/^1[3|4|5|8]\d{9}$/);
vreg.put("telno-mobile",/(^1[3|4|5|8]\d{9}$)|(^(\d{3,4}|\d{3,4}-)?\d{7,8}$)/);
vreg.put("post-only",/^\d{6}$/);
vreg.put("email-only",/^(?:\w+\.?)*\w+@(?:\w+\.?)*\w+$/);
var strRegex = /^((https|http|ftp|rtsp|mms)?:\/\/)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\.[a-z]{2,6})(:[0-9]{1,4})?((\/?)|(\/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+\/?)$/;    
vreg.put("website-only",new RegExp(strRegex));
vreg.put("chinese-only",/^[\u4e00-\u9fa5],{0,}$/);
vreg.put("cardid-only",/^\d{18}|\d{15}$/);
vreg.put("max-len",function(val,message){
	specialmsg = message.substring(0,message.lastIndexOf("!"));
	var clen = message.substring(message.lastIndexOf("!")+1,message.length);
	//消息替换
	specialmsg = specialmsg.replace("max_lengh",clen);
	var regstr = "^[\\w\\s]{0,"+clen+"}$";
	return new RegExp(regstr).test(val);
});
vreg.put("min-len",function(val,message){
	specialmsg = message.substring(0,message.lastIndexOf("!"));
	var clen = message.substring(message.lastIndexOf("!")+1,message.length);
	//消息替换
	specialmsg = specialmsg.replace("min_lenth",clen);
	var regstr = "^[\\w\\s]{"+clen+",999999}$";
	return new RegExp(regstr).test(val);
});
vreg.put("bw-len",function(val,message){
	specialmsg = message.substring(0,message.lastIndexOf("!"));
	var clen = message.substring(message.lastIndexOf("!")+1,message.length);
	//消息替换
	specialmsg = specialmsg.replace("min_lengh",clen.split(",")[0]);
	specialmsg = specialmsg.replace("max_lengh",clen.split(",")[1]);
	var regstr = "^[\\w\\s]{"+clen.split(",")[0]+","+clen.split(",")[1]+"}$";
	return new RegExp(regstr).test(val);
});
vreg.put("fix-len",function(val,message){
	specialmsg = message.substring(0,message.lastIndexOf("!"));
	var clen = message.substring(message.lastIndexOf("!")+1,message.length);
	//消息替换
	specialmsg = specialmsg.replace("fix_lengh",clen);
	var regstr = "^[\\w\\s]{"+clen+"}$";
	return new RegExp(regstr).test(val);
});



//判断函数
//去掉两端空格
String.prototype.trim= function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");  
}
String.prototype.vf=function(){
	
}

//加载网页自动执行
//$(function(){
//	initVerify();
//});