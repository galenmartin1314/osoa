var $lt = $("<table></table>");
var optid = null;
$(function(){
	$lt.appendTo('body');
	$lt.datagrid({
		title: '角色信息列表',
		iconCls: 'icon-list',
		fit:true,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		pagination:true,
		url:'list.shtml',
	    columns:[[
	        {field:'roleName',title:'角色名称',width:100,sort:true},
	        {field:'cdate',title:'创建时间',width:100},
	        {field:'udate',title:'更新时间',width:100},
	        {field:'remark',title:'备注',width:300}
	    ]],
	    toolbar:[{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){parent.myDesk.csw({
				title : '新增角色信息',
				width : 330,
				height : 215,
				frameurl : 'settings/roles/add.shtml'
			})}
		},{
			text:'编辑',
			iconCls:'icon-edit',
			handler:function(){
				if(!$lt.datagrid("getSelected")){
					parent.myDesk.warm(message.get("editsel"));
				}else{
					optid = $lt.datagrid("getSelected").deptId;
					parent.myDesk.csw({
						title : '编辑角色信息',
						width : 612,
						height : 300,
						frameurl : 'settings/roles/edit.shtml?roleid='+optid,
						handler : "update()"
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
					optid = $lt.datagrid("getSelected").deptId;
					parent.myDesk.confirm(message.get("deleteconfirm"),"deldata()");
				}
			}
		},'-',{
			text:'授权',
			iconCls:'icon-vest',
			handler:function(){
				if(!$lt.datagrid("getSelected")){
					parent.myDesk.warm(message.get("deletesel"));
				}else{
					optid = $lt.datagrid("getSelected").deptId;
					parent.myDesk.confirm(message.get("deleteconfirm"),"deldata()");
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
	$.get('delete.shtml?roleid='+optid,function(data){
		if(data.indexOf("success")!=-1){
			parent.myDesk.info(message.get("optsuccess"));
			parent.myDesk.refwin();
		}else{
			parent.myDesk.info(message.get("optfalure"));
		}
	})
}