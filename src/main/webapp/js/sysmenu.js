var sysMenu = {
	createMenu:function(){
		var win_height=$(window).height();
		//初始化菜单高度
		$('#startmenu').css("height",win_height+"px");
		//定义菜单
		var menuC = $('#navigator');
		menuC.css("height",win_height+"px");
		menuC.css("width",$('#startmenu').width()+"px");
		menuC.accordion({fit:true});
		//主菜单1
		var ul = $("<ul></ul>");
		var li = $("<li onclick=\"myDesk.createApp({id:'jiguanshezhi',title:'籍贯设置',frameurl:'settings/index.shtml?np=0',barIcon:'images/menu/home.png',iconCls:'home'});\"></li>");
		var href = $("<img src=\"images/menu/home16x16.png\"/><span>　籍贯设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'nationshezhi',title:'民族设置',frameurl:'settings/index.shtml?np=1',barIcon:'images/menu/nation.png',iconCls:'nation'});\"></li>");
		var href = $("<img src=\"images/menu/nation16x16.png\"/><span>　民族设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'cardsshezhi',title:'证件设置',frameurl:'settings/index.shtml?np=2',barIcon:'images/menu/cards.png',iconCls:'cards'});\"></li>");
		var href = $("<img src=\"images/menu/cards16x16.png\"/><span>　证件设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'xuelishezhi',title:'学历设置',frameurl:'settings/index.shtml?np=3',barIcon:'images/menu/student.png',iconCls:'student'});\"></li>");
		var href = $("<img src=\"images/menu/student16x16.png\"/><span>　学历设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'zhuanyeshezhi',title:'专业设置',frameurl:'settings/index.shtml?np=4',barIcon:'images/menu/book.png',iconCls:'book'});\"></li>");
		var href = $("<img src=\"images/menu/book16x16.png\"/><span>　专业设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'zhichengshezhi',title:'职称设置',frameurl:'settings/index.shtml?np=5',barIcon:'images/menu/star.png',iconCls:'star'});\"></li>");
		var href = $("<img src=\"images/menu/star16x16.png\"/><span>　职称设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'zhiwushezhi',title:'职务设置',frameurl:'settings/index.shtml?np=6',barIcon:'images/menu/money.png',iconCls:'money'});\"></li>");
		var href = $("<img src=\"images/menu/money16x16.png\"/><span>　职务设置</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'zhengzhishezhi',title:'政治面貌',frameurl:'settings/index.shtml?np=7',barIcon:'images/menu/zhengzhi.png',iconCls:'zhengzhi'});\"></li>");
		var href = $("<img src=\"images/menu/zhengzhi16x16.png\"/><span>　政治面貌</span>");
		li.append(href);
		ul.append(li);
		menuC.accordion('add',{
			title:'综合设置',
			iconCls: 'settings',
			content: ul,
			selected: false
		});
		//主菜单2
		var ul = $("<ul></ul>");
		var li = $("<li onclick=\"myDesk.createApp({id:'zlxg',title:'资料修改',frameurl:'basic/emp/info.shtml',barIcon:'images/menu/infom.png',iconCls:'infom',width:612,height:600,maximizable:false,minimizable:false});\"></li>");
		var href = $("<img src=\"images/menu/infom16x16.png\"/><span>　资料修改</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'mmxg',title:'密码修改',frameurl:'basic/emp/pwd.shtml',barIcon:'images/menu/passwords.png',iconCls:'passwords',width:330,height:220,maximizable:false,minimizable:false});\"></li>");
		var href = $("<img src=\"images/menu/passwords16x16.png\"/><span>　密码修改</span>");
		li.append(href);
		ul.append(li);
		menuC.accordion('add',{
			title:'个人信息',
			iconCls: 'adminper',
			content: ul,
			selected: true
		});
		//主菜单3
		var ul = $("<ul></ul>");
		var li = $("<li onclick=\"myDesk.createApp({id:'bmxx',title:'部门信息',frameurl:'basic/dept/index.shtml',barIcon:'images/menu/department.png',iconCls:'department'});\"></li>");
		var href = $("<img src=\"images/menu/department16x16.png\"/><span>　部门信息</span>");
		li.append(href);
		ul.append(li);
		li = $("<li onclick=\"myDesk.createApp({id:'empxx',title:'员工信息',frameurl:'basic/emp/index.shtml',barIcon:'images/menu/employee.png',iconCls:'employee'});\"></li>");
		var href = $("<img src=\"images/menu/employee16x16.png\"/><span>　员工信息</span>");
		li.append(href);
		ul.append(li);
		menuC.accordion('add',{
			title:'基础管理',
			iconCls: 'baseadmin',
			content: ul,
			selected: false
		});
		//点击链接后变比菜单
		menuC.children().find("li").bind('click',function(){myDesk.menuShowOrHide(true);});
		//将开始菜单隐藏
		myDesk.menuShowOrHide(true);
	}
}