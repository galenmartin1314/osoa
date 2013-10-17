var $form = null;
$(function(){
	$form = $.formUI({
		id : 'form0',
		name : 'form0',
		method : 'post',
		fn : function(){windowcb()},
		layout : 'double',
		items : [{
			xt : 'text',
			id : 'deptNo',
			name : 'deptNo',
			cls : 'input',
			label : '部门编码',
			verify : '部门编码/not-null:true'
		},{
			xt : 'text',
			id : 'deptName',
			name : 'deptName',
			cls : 'input',
			label : '部门名称',
			verify : '部门名称/not-null:true'
		},{
			xt : 'text',
			id : 'deptLnkman',
			name : 'deptLnkman',
			cls : 'input',
			label : '联 系 人'
		},{
			xt : 'text',
			id : 'deptTel',
			name : 'deptTel',
			cls : 'input',
			label : '联系电话',
			verify : '联系电话/telno-mobile:true'
		},{
			xt : 'combotree',
			id : 'supId',
			name : 'supId',
			label : '上级部门',
			valueFiled : 'id',
			textField : 'text',
			url : 'initParent.shtml'
		},{
			xt : 'hidden',
			id : 'deptId',
			name : 'deptId'
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
				parent.myDesk.info(message.get("optsuccess"));
				parent.myDesk.clwandref();
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
				parent.myDesk.info(message.get("optsuccess"));
				parent.myDesk.clwandref();
			}else{
				parent.myDesk.info(message.get("optfalure"));
			}
		}
	})
}
