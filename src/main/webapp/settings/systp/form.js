var $form = null;
$(function(){
	$form = $.formUI({
		id : 'form0',
		name : 'form0',
		method : 'post',
		fn : function(){windowcb()},
		items : [{
			xt : 'text',
			id : 'tpCode',
			name : 'tpCode',
			cls : 'input',
			label : '编 码',
			verify : '编码/not-null:true'
		},{
			xt : 'text',
			id : 'tpName',
			name : 'tpName',
			cls : 'input',
			label : '名 称',
			verify : '名称/not-null:true'
		},{
			xt : 'textarea',
			id : 'remark',
			name : 'remark',
			cls : 'textarea',
			label : '备 注'
		},{
			xt : 'hidden',
			id : 'tpId',
			name : 'tpId'
		},{
			xt : 'hidden',
			id : 'tpType',
			name : 'tpType'
		}]
	});
	//初始化光标
	$('#tpCode').focus();
	//初始化类型值
	if($('#tpspan').html()=="undefined" || $('#tpspan').html()==undefined){
		$('#tpType').val($('span').html());
	}else{
		//加载编辑数据
		$form.form("load","init.shtml?tpId="+$('span').html());
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
