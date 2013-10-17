var $lt = $("<table></table>");
var optid = null;
$(function(){
	$lt.appendTo('body');
	$lt.datagrid({
		title: '部门信息列表',
		iconCls: 'icon-list',
		fit:true,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		pagination:true,
		url:'list.shtml',
	    columns:[[
	        {field:'deptNo',title:'部门编码',width:100,sort:true},
	        {field:'deptName',title:'部门名称',width:200},
	        {field:'deptLnkman',title:'联系人',width:100},
	        {field:'deptTel',title:'联系电话',width:100}
	    ]],
	    toolbar:[{
			text:'新增',
			iconCls:'icon-add',
			handler:function(){parent.myDesk.csw({
				title : '新增部门信息',
				width : 612,
				height : 300,
				frameurl : 'basic/dept/add.shtml'
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
						title : '编辑部门信息',
						width : 612,
						height : 300,
						frameurl : 'basic/dept/edit.shtml?deptId='+optid,
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
					optid = $lt.datagrid("getSelected").deptId;
					parent.myDesk.csw({
						title : '查看部门信息',
						width : 612,
						height : 300,
						frameurl : 'basic/dept/view.shtml?deptId='+optid,
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
	$.get('delete.shtml?deptId='+optid,function(data){
		if(data.indexOf("success")!=-1){
			parent.myDesk.info(message.get("optsuccess"));
			parent.myDesk.refwin();
		}else{
			parent.myDesk.info(message.get("optfalure"));
		}
	})
}