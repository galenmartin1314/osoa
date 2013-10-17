var $form = null;
$(function(){
	$form = $.formUI({
		id : 'form0',
		name : 'form0',
		method : 'post',
		fn : function(){windowcb()},
		layout : 'double',
		items : [{
			xt : 'combotree',
			id : 'deptId',
			name : 'deptId',
			label : '所属部门',
			verify : '所属部门/not-null:true',
			valueFiled : 'id',
			textField : 'text',
			url : '../dept/initParent.shtml'
		},{
			xt : 'text',
			id : 'empCode',
			name : 'empCode',
			cls : 'input',
			label : '员工代码',
			verify : '员工代码/not-null:true'
		},{
			xt : 'text',
			id : 'empName',
			name : 'empName',
			cls : 'input',
			label : '员工姓名',
			verify : '员工代码/not-null:true'
		},{
			xt : 'text',
			id : 'empEpName',
			name : 'empEpName',
			cls : 'input',
			label : '曾 用 名'
		},{
			xt : 'combobox',
			id : 'sex',
			name : 'sex',
			cls : 'input',
			label : '性　　别',
			data : [{
				"value" : "0",
				"text" : "---请选择---",
				"selected" : true
			},{
				"value" : "1",
				"text" : "男"
			},{
				"value" : "2",
				"text" : "女"
			}],
			valueFiled : 'value',
			textField : 'text'
			
		},{
			xt : 'datebox',
			id : 'birthday',
			name : 'birthday',
			cls : 'input',
			label : '出生年月'
		},{
			xt : 'datebox',
			id : 'jobst',
			name : 'jobst',
			cls : 'input',
			label : '开始工作'
		},{
			xt : 'datebox',
			id : 'intotime',
			name : 'intotime',
			cls : 'input',
			label : '入职日期',
			verify : '入职日期/not-null:true'
		},{
			xt : 'combobox',
			id : 'np',
			name : 'np',
			cls : 'input',
			label : '籍　　贯',
			url : 'initTp.shtml?tp=0',
			valueFiled : 'value',
			textField : 'text'
			
		},{
			xt : 'combobox',
			id : 'nation',
			name : 'nation',
			cls : 'input',
			label : '民　　族',
			url : 'initTp.shtml?tp=1',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'combobox',
			id : 'cardtp',
			name : 'cardtp',
			cls : 'input',
			label : '证件类型',
			url : 'initTp.shtml?tp=2',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'text',
			id : 'cardno',
			name : 'cardno',
			cls : 'input',
			label : '证件号码'
		},{
			xt : 'combobox',
			id : 'eb',
			name : 'eb',
			cls : 'input',
			label : '学　　历',
			url : 'initTp.shtml?tp=3',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'combobox',
			id : 'pro',
			name : 'pro',
			cls : 'input',
			label : '专　　业',
			url : 'initTp.shtml?tp=4',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'combobox',
			id : 'tp',
			name : 'tp',
			cls : 'input',
			label : '职　　称',
			url : 'initTp.shtml?tp=5',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'combobox',
			id : 'posts',
			name : 'posts',
			cls : 'input',
			label : '职　　务',
			url : 'initTp.shtml?tp=6',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'combobox',
			id : 'ploityface',
			name : 'ploityface',
			cls : 'input',
			label : '政治面貌',
			url : 'initTp.shtml?tp=7',
			valueFiled : 'id',
			textField : 'text'
		},{
			xt : 'text',
			id : 'jobtel',
			name : 'jobtel',
			cls : 'input',
			label : '办公电话'
		},{
			xt : 'text',
			id : 'mobile',
			name : 'mobile',
			cls : 'input',
			label : '手　　机'
		},{
			xt : 'text',
			id : 'hometel',
			name : 'hometel',
			cls : 'input',
			label : '家庭电话'
		},{
			xt : 'text',
			id : 'homeaddr',
			name : 'homeaddr',
			cls : 'input',
			label : '家庭地址'
		},{
			xt : 'text',
			id : 'email',
			name : 'email',
			cls : 'input',
			label : '邮　　箱'
		},{
			xt : 'text',
			id : 'contract',
			name : 'contract',
			cls : 'input',
			label : '合同编号',
			inline : true,
			css : {width : "480px"}
		},{
			xt : 'text',
			id : 'remark',
			name : 'remark',
			cls : 'input',
			label : '备　　注',
			inline : true,
			css : {width : "480px"}
		},{
			xt : 'hidden',
			id : 'empId',
			name : 'empId'
		}]
	});
	//初始化光标
	$($('#deptId').parent().find("input").get(1)).focus();
	
	//加载编辑数据
	if($('#empspan').html()!="undefined" && $('#empspan').html()!=undefined){
		$form.form("load","init.shtml?empId="+$('#empspan').html());
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
