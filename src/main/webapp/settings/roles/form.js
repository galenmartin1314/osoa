var $form = null;
$(function(){
	$form = $.formUI({
		id : 'form0',
		name : 'form0',
		method : 'post',
		fn : function(){windowcb()},
		items : [{
			xt : 'text',
			id : 'roleName',
			name : 'roleName',
			cls : 'input',
			label : '角色名称',
			verify : '角色名称/not-null:true'
		},{
			xt : 'textarea',
			id : 'remark',
			name : 'remark',
			label : '备　　注',
			valueFiled : 'id',
			textField : 'text',
			url : 'initParent.shtml'
		},{
			xt : 'hidden',
			id : 'roleid',
			name : 'roleid'
		},{
			xt : 'hidden',
			id : 'cdate',
			name : 'cdate'
		},{
			xt : 'hidden',
			id : 'udate',
			name : 'udate'
		}]	
	});
	//初始化光标
	$('#deptNo').focus();
	//加载编辑数据
	if($('#deptspan').html()!="undefined" && $('#deptspan').html()!=undefined){
		$form.form("load","init.shtml?deptId="+$('#deptspan').html());
	}
	//表单验证初始化
	initVerify();
});
//保存数据
function windowcb(){
	$form.form("submit",{
		url : 'save.shtml',
		onSubmit : function(){
			var flag = verifyForm("form0");
			if(!flag)parent.myDesk.disableButton.linkbutton('enable');
			return flag;
		},
		success: function(data){
			if(data=="success"){
				parent.myDesk.confirm(message.get("optsuccess")+",是否立即分配权限?","vest()",true);
			}else{
				parent.myDesk.info(message.get("optfalure"));
			}
		}
	})
}
//修改数据
function update(){
	$form.form("submit",{
		url : 'update.shtml',
		onSubmit : function(){
			var flag = verifyForm("form0");
			if(!flag)parent.myDesk.disableButton.linkbutton('enable');
			return flag;
		},
		success: function(data){
			if(data=="success"){
				parent.myDesk.confirm(message.get("optsuccess")+",是否立即分配权限?","vest()",true);
			}else{
				parent.myDesk.info(message.get("optfalure"));
			}
		}
	})
}
//赋予权限
function vest(){
	alert("授权");
}