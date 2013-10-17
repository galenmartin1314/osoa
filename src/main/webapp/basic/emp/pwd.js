var $form = null;
$(function(){
	$container = $("body").find("div");
	$form = $.formUI({
		id : 'form0',
		name : 'form0',
		method : 'post',
		target : $container,
		items : [{
			xt : 'password',
			id : 'opwd',
			name : 'opwd',
			cls : 'input',
			label : '旧 密 码',
			verify : '旧密码/not-null:true'
		},{
			xt : 'password',
			id : 'npwd',
			name : 'npwd',
			cls : 'input',
			label : '新 密 码',
			verify : '新密码/not-null:true'
		},{
			xt : 'password',
			id : 'repwd',
			name : 'repwd',
			cls : 'input',
			label : '密码确认',
			verify : '密码确认/not-null:true'
		},{
			xt : 'hidden',
			id : 'empId',
			name : 'empId'
		}]
	});
	//初始化光标
	$('#opwd').focus();
	
	//定义提交按钮
	var btns = $("<div>&nbsp;</div>");
	btns.appendTo($container);
	var _w = $(window).width();
	var _h = $(window).height()-$form.height()-31;
	btns.css({"windth":_w+"px","height":_h+"px","borderTop":"1px solid #eeeeee","background":"#fafafa"});
	btns.css({"text-align":"right"});
	btns.css("line-height",_h+"px");
	btns.css("padding-right","10px");
	var _sub = $("<a id='submitbtn' href='#'>提 交</a>");
	_sub.appendTo(btns);
	_sub.linkbutton({
		iconCls : 'icon-ok',
		plain : true
	});
	_sub.click(function(){
		$("#submitbtn").linkbutton('disable');
		windowcb();
	});
	btns.append("&nbsp;");
	var _cls = $("<a href='#'>关 闭</a>");
	_cls.appendTo(btns);
	_cls.linkbutton({
		iconCls : 'icon-cancel',
		plain : true
	});
	_cls.click(function(){
		parent.myDesk.clsApp();
	});
	//表单验证初始化
	initVerify();
	$("#empId").val($("#empspan").html());
});
//保存数据
function windowcb(){
	$form.form("submit",{
		url : 'resetPass.shtml',
		onSubmit : function(){
			var flag = verifyForm("form0","yes");
			if(!flag)$("#submitbtn").linkbutton('enable');
			else if($("#npwd").val()!=$("#repwd").val()){flag=false;parent.myDesk.info("新密码和密码确认输入不一致!");$("#submitbtn").linkbutton('enable');}
			return flag;
		},
		success: function(data){
			if(data=="success"){
				parent.myDesk.info(message.get("optsuccess"));
			}else if(data=="oldfail"){
				parent.myDesk.info("旧密码输入错误!");
			}else{
				parent.myDesk.info(message.get("optfalure"));
			}
			$("#submitbtn").linkbutton('enable');
		}
	})
}