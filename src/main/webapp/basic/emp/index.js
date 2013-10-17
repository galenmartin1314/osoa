var $lt = $("<table></table>");
var optid = null;
$(function(){
	$lt.appendTo('body');
	$lt.datagrid({
		title: '员工信息列表',
		iconCls: 'icon-list',
		fit:true,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		pagination:true,
		url:'list.shtml',
	    columns:[[
	        {field:'deptId',title:'所属部门',width:100,sort:true},
	        {field:'empCode',title:'员工代码',width:100},
	        {field:'empName',title:'员工姓名',width:100,sort:true},
	        {field:'empEpName',title:'曾用名',width:100},
	        {field:'posts',title:'职务',width:100},
	        {field:'jobtel',title:'办公电话',width:100},
	        {field:'mobile',title:'手机',width:100},
	        {field:'intotime',title:'入职时间',width:100}
	    ]],
	    toolbar:[{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){parent.myDesk.csw({
				title : '新增员工信息',
				width : 612,
				height : 600,
				frameurl : 'basic/emp/add.shtml'
			})}
		},{
			text:'编辑',
			iconCls:'icon-edit',
			handler:function(){
				if(!$lt.datagrid("getSelected")){
					parent.myDesk.warm(message.get("editsel"));
				}else{
					optid = $lt.datagrid("getSelected").empId;
					parent.myDesk.csw({
						title : '编辑员工信息',
						width : 612,
						height : 600,
						frameurl : 'basic/emp/edit.shtml?empId='+optid,
						handler : "update()"
					})
				}
			}
		},{
			text:'查看',
			iconCls:'icon-view',
			handler:function(){
				if(!$lt.datagrid("getSelected")){
					parent.myDesk.warm(message.get("editsel"));
				}else{
					optid = $lt.datagrid("getSelected").empId;
					parent.myDesk.csw({
						title : '查看员工信息',
						width : 612,
						height : 600,
						frameurl : 'basic/emp/view.shtml?empId='+optid,
						nosub : true
					})
				}
			}
		},'-',{
			text:'删除',
			iconCls:'icon-remove',
			handler:function(){
				if(!$lt.datagrid("getSelected")){
					parent.myDesk.warm(message.get("deletesel"));
				}else{
					optid = $lt.datagrid("getSelected").empId;
					parent.myDesk.confirm(message.get("deleteconfirm"),"deldata()");
				}
			}
		},'-',{
			text:'重置密码',
			iconCls:'icon-back',
			handler:function(){
				if(!$lt.datagrid("getSelected")){
					parent.myDesk.warm("请选择要操作的数据!");
				}else{
					optid = $lt.datagrid("getSelected").empId;
					parent.myDesk.confirm("是否需要重置当前用户的登录密码?","resetpass()");
				}
			}
		}]
	});
	
	//设置分页控件
	var p = $lt.datagrid('getPager');  
    $(p).pagination({
		pageSize:10,
        pageList: [10,15,20],//可以设置每页记录条数的列表  
        beforePageText: '第',//页数文本框前显示的汉字  
        afterPageText: '页    共 {pages} 页',  
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });
});

var deldata=function(){
	$.get('delete.shtml?empId='+optid,function(data){
		if(data.indexOf("success")!=-1){
			parent.myDesk.info(message.get("optsuccess"));
			parent.myDesk.refwin();
		}else{
			parent.myDesk.info(message.get("optfalure"));
		}
	})
}
var resetpass=function(){
	$.get('resetPass.shtml?empId='+optid,function(data){
		if(data.indexOf("success")!=-1){
			parent.myDesk.info(message.get("optsuccess"));
			parent.myDesk.refwin();
		}else{
			parent.myDesk.info(message.get("optfalure"));
		}
	})
}