var myDesk={
	init:function(){
		//设置任务栏时间日期
		this.timerSetter();
		//显示隐藏菜单
		$(document).bind("mousemove",function(event){
			if(event.pageX>($(window).width()-10)){
				if($.trim($('#startmenu').css("display"))=="none")myDesk.menuShowOrHide(false);
			}else if(event.pageX<($(window).width()-($('#startmenu').width()-10))){myDesk.menuShowOrHide(true);}
		});
		//初始化任务栏悬停按钮
		this.btnMap = new Map();
		this.preButton = null;
		//初始化窗口
		this.winChain = new Array();
		this.winMap = new Map();
		//初始化桌面
		this.iconMap = new Map();
		//初始化右键菜单
        $.contextMenu({
	        selector: '.desktop',
	        callback: function(key, options) {
	            switch(key){
	            	case 'display':
	            		myDesk.showDeskTop();
	            		break;
	            	case 'system':
	            		myDesk.systemSetting();
	            		break;
	            	case 'theme':
	            		myDesk.themeSetting();
	            		break;
	            	case 'logout':
	            		myDesk.logout();
	            		break;
	            	case 'about':
	            		myDesk.aboutSystem();
	            }
	        },
	        items: {
	            "display": {name: "显示桌面", icon: "display"},
	            "sep1": "-",
	            "system": {name: "系统设置", icon: "system"},
	            "theme": {name: "主题设置", icon: "theme"},
	            "sep2": "-",
	            "logout": {name: "退出系统", icon: "logout"},
	            "about": {name: "关于OSOA", icon: "about"}
	        }
	    });
	    //程序子窗口
	    this.subwin=new Array();
        //屏蔽系统右键
        $(document).contextmenu(function(){return false;});
        //屏蔽按钮
        this.disableButton = null;
	},
	//设置任务栏日期时间
	timerSetter:function(){
		var date = new Date();
		var year = date.getFullYear();
		var month = ""+date.getMonth();
		if(month.length==1)month="0"+month;
		var dt = ""+date.getDate();
		if(dt.length==1)dt="0"+dt;
		var hour = ""+date.getHours();
		if(hour.length==1)hour="0"+hour;
		var mis = ""+date.getMinutes();
		if(mis.length==1)mis="0"+mis;
		var sec = ""+date.getSeconds();
		if(sec.length==1)sec="0"+sec;
		$(".timer").text(year+"-"+month+"-"+dt+" "+hour+":"+mis+":"+sec);
		setTimeout("myDesk.timerSetter()",1000);
	},
	//控制菜单的显隐
	menuShowOrHide:function(sh){
		if(sh){
			$('#startmenu').hide();
		}else{
			$('#startmenu').css({display:"block", top:"0px", left:$(window).width()+"px", height:$(window).height()+"px"});
			$('#startmenu').animate({left:($(window).width()-$('#startmenu').width())+"px"});
		}
	},
	//创建应用窗口
	createApp:function(config){
		var defaults = {
			id : null,
			title : '新建窗口',
			barIcon: 'images/icon/window.png',
			width : $(window).width(),
			height : $(window).height()-$('.taskbar').height(),
			frameurl : 'http://www.baidu.com',
			iconCls : "window16x16",
			maximizable : true,
			minimizable : true,
			modal : false,
			collapsible : false,
			draggable : true,
			resizable : true,
			closable : true
		};
		var cfg = $.extend(defaults, config);
		//添加窗口链表
		this.winChain[this.winChain.length] = cfg['id'];
		//创建窗口
		var curwin = this.winMap.get(cfg['id']);
		
		if(curwin){
			$('#win_'+cfg['id']).window('open');
		}else{
			//在桌面上添加新窗口html代码
			$('.desktop').append(this.winHtml(cfg));
			//显示窗口
			$('#win_'+cfg['id']).window();
			//向窗口集合中该窗口
			this.winMap.put(cfg['id'], $('#win_'+cfg['id']));
		}
		//创建任务栏
		var curBtn = this.btnMap.get(cfg['id']);
		if(curBtn){
			if(this.winChain.length>1){
				$("#bar_"+this.winChain[this.winChain.length-2]+">li").removeClass("bar_column_select").addClass("bar_column_out");
			}
			curBtn.removeClass("bar_column_out").addClass("bar_column_select");
		}else{
			var html="<ul id=\"bar_"+cfg['id']+"\">";
			html = html + "<li class=\"bar_column_select\" title=\""+cfg['title']+"\"><img src=\""+cfg['barIcon']+"\"></li>";
			html = html + "</ul>";
			$(".bar_container").append(html);
			this.btnMap.put(cfg['id'], $('#bar_'+cfg['id']+">li"));
			
			if(this.winChain.length>1){
				$("#bar_"+this.winChain[this.winChain.length-2]+">li").removeClass("bar_column_select").addClass("bar_column_out");
			}
			//添加鼠标事件
			$("#bar_"+cfg['id']+">li").bind("click",function(){
				myDesk.createApp({id:""+cfg['id']});
			});
			$("#bar_"+cfg['id']+">li").bind("mouseover",function(){
				if($("#bar_"+cfg['id']+">li").attr("class")!="bar_column_select")
					$("#bar_"+cfg['id']+">li").removeClass("bar_column_out").addClass("bar_column_in");
			});
			$("#bar_"+cfg['id']+">li").bind("mouseout",function(){
				if($("#bar_"+cfg['id']+">li").attr("class")!="bar_column_select")
					$("#bar_"+cfg['id']+">li").removeClass("bar_column_in").addClass("bar_column_out");
			});
		}
	},
	//关闭应用
	clsApp:function(){
		$("#win_"+myDesk.winChain[myDesk.winChain.length-1]).window("close");
	},
	//销毁应用
	destoryApp:function(id){
		//卸载窗口
		this.winMap.remove(id);
		$("#win_"+id).window('destroy');
		//卸载任务栏按钮
		this.btnMap.remove(id);
		$("#bar_"+id).remove();
		//重置窗口链表
		this.restoreChain(id);
	},
	winHtml:function(cfg){
		var html = "<div id=\"win_" + cfg['id'] + "\"";
		html = html + " class=\"easyui-window\"";
		html = html + " data-options=\"";
		html = html + "maximizable:"+cfg['maximizable'];
		html = html + ",minimizable:"+cfg['minimizable'];
		html = html + ",modal:"+cfg['modal'];
		html = html + ",collapsible:"+cfg['collapsible'];
		html = html + ",draggable:"+cfg['draggable'];
		html = html + ",draggable:"+cfg['draggable'];
		html = html + ",closable:"+cfg['closable'];
		html = html + ",inline:true"; 
		html = html + ",onClose:function(){myDesk.destoryApp('"+cfg['id']+"');}";
		html = html + ",onMinimize:function(){myDesk.restoreChain('"+cfg['id']+"');}";
		html = html + ",closable:"+cfg['closable'];
		html = html + ",width:"+cfg['width'];
		html = html + ",height:"+cfg['height'];
		html = html + ",iconCls:'"+cfg['iconCls'];
		html = html + "',title:'"+cfg['title'];
		html = html + "',style:'{padding:5px}'\">";
		html = html + "<iframe frameborder=\"0\" width=\"100%\" height=\"100%\" marginwidth=\"100%\" marginheight=\"100%\" style=\"z-index:-1; \" src=\""+cfg['frameurl']+"\"></iframe>";
		html = html + "</div>";
		return html;
	},
	restoreChain:function(id){
		//清除任务栏样式
		if($("#bar_"+id+">li")){
			$("#bar_"+id+">li").removeClass("bar_column_select").addClass("bar_column_out");
		}
		//重置链表
		var tmpChain = new Array();
		var curChain = this.winChain;
		for(var idx=0;idx<curChain.length;idx++){
			if(curChain[idx]!=id){
				tmpChain[tmpChain.length]=curChain[idx];
			}
		}
		this.winChain = tmpChain;
		//并选中最后窗口
		if(this.winChain.length>0){
			$("#win_"+this.winChain[this.winChain.length-1]).window("open");
			$("#bar_"+this.winChain[this.winChain.length-1]+">li").removeClass("bar_column_out").addClass("bar_column_select");
		}
	},
	getMenuHeight:function(){
		return $(window).height();
	},
	createDeskTopApp:function(data){
		var win_h = $(window).height();
		var cur_top = 10;
		var cur_left = 10;
		for(var idx=0;idx<data.length;idx++){
			var deskicon = data[idx];
			var frame = deskicon.frame[0];
			//组合桌面图标
			var html = "<div id='icon_"+frame.id+"' style='left:"+cur_left+"px;top:"+cur_top+"px;' class='deskicon' ondblclick='myDesk.createApp("+JSON.stringify(frame)+")'>";
			html = html + "<div>";
			html = html + "<p><img src='"+deskicon.icon+"'/><p>";
			html = html + "<em>"+frame.title+"</em>";
			html = html + "</div></div>";
			$(".desktop").append(html);
			//计算左边距和顶边距
			if((cur_top+110)>(win_h-140)){
				cur_top = 10;
				cur_left = cur_left + 110;
			}else{
				cur_top = cur_top+110;
			}
			
		}
	},
	//创建应用子窗口
	csw:function(config){
		var defaults = {
			id : null,
			title : '新建窗口',
			width : 800,
			height : 400,
			frameurl : 'http://www.baidu.com',
			iconCls : "window16x16",
			maximizable : false,
			minimizable : false,
			modal : true,
			collapsible : false,
			draggable : false,
			resizable : false,
			closable : true,
			handler : 'windowcb()',
			nosub : false
		};
		var cfg = $.extend(defaults, config);
		var $dlg=$("<div></div>");
		//创建iframe
		var ifm = "<iframe frameborder=\"0\" width=\"100%\" height=\"100%\" marginwidth=\"100%\" marginheight=\"100%\" style=\"z-index:-1; \" src=\""+cfg['frameurl']+"\"></iframe>";
		$dlg.html(ifm);
		$('body').append($dlg);
		$dlg.dialog({
			title : cfg.title,
			width : cfg.width,
			height : cfg.height,
			iconCls : cfg.iconCls,
			maximizable : cfg.maximizable,
			minimizable : cfg.minimizable,
			modal : cfg.modal,
			collapsible : cfg.collapsible,
			draggable : cfg.draggable,
			resizable : cfg.resizable,
			closable : cfg.closable,
			onClose: function(obj){
				myDesk.subwin[myDesk.subwin.length-1].remove();
				myDesk.subwin.pop();
			},
			buttons: [{
				id : 'formsubmit',
				text:'提 交',
				iconCls: 'icon-ok',
				plain : true,
				handler: function(){
					myDesk.disableButton = $(this);
					myDesk.disableButton.linkbutton('disable');
					$dlg.find("iframe")[0].contentWindow.eval(cfg.handler);
				}
			},{
				text: '关 闭',
				iconCls: 'icon-cancel',
				plain : true,
				handler: function(){
					$dlg.dialog("close");
				}
			}]
		});
		//判断隐藏提交按钮
		if(cfg.nosub){$('#formsubmit').css({display:"none"})}
		//将窗口加入到子窗口列表
		this.subwin[this.subwin.length] = $dlg;
	},
	clw:function(){
		myDesk.subwin[myDesk.subwin.length-1].dialog('close');
	},
	btnfo:function(){
		myDesk.subwin[myDesk.subwin.length-1].find(".icon-ok").click();
	},
	clwandref:function(){
		myDesk.clw();
		//刷新列表
		myDesk.refwin();
	},
	refwin:function(){
		//刷新列表
		$('#win_'+myDesk.winChain[myDesk.winChain.length-1]).find("iframe")[0].contentWindow.$lt.datagrid("reload");
	},
	//桌面右键菜单处理函数
	showDeskTop:function(){
		var curChain = this.winChain;
		for(var idx=0;idx<curChain.length;idx++){
			//清除样式
			if($("#bar_"+curChain[idx]+">li").attr('class')=='bar_column_select')$("#bar_"+curChain[idx]+">li").removeClass("bar_column_select").addClass("bar_column_out");
			//关闭窗口
			$("#win_"+curChain[idx]).window("minimize");
		}
		this.winChain = new Array();
	},
	systemSetting:function(){
		alert('系统设置');
	},
	themeSetting:function(){
		alert('主题设置');
	},
	logout:function(){
		alert('退出系统');
	},
	aboutSystem:function(){
		alert('关于OSOA');
	},
	warm:function(msg, opid, nodlg){
		$.messager.alert('警告',msg,'warning',function(){
			if(nodlg){
				if(opid)
					$("#win_"+myDesk.winChain[myDesk.winChain.length-1]).find("iframe")[0].contentWindow.document.getElementById(opid).focus();
			}else{
				if(opid)
					myDesk.subwin[myDesk.subwin.length-1].find("iframe")[0].contentWindow.document.getElementById(opid).focus();
			}
		});
	},
	info:function(msg){
		$.messager.alert('信息',msg,'alert');
	},
	confirm:function(msg,fn,subwin){
		var subw = subwin;
		$.messager.confirm('确认信息', msg, function(r){
			if(r){
				if(subw){
					myDesk.subwin[myDesk.subwin.length-1].find("iframe")[0].contentWindow.eval(fn);
				}else{
					$('#win_'+myDesk.winChain[myDesk.winChain.length-1]).find("iframe")[0].contentWindow.eval(fn);
				}
			}
		});
	}
};

$(function(){
	//设置背景
	$('body').css("background","url('../images/blue_glow.jpg');");
	//初始化菜单
	sysMenu.createMenu();
	//初始化桌面
	myDesk.init();
	myDesk.createDeskTopApp([
		{icon:'images/desktop/baidu.png',frame:[{id:'baiduyixia',title:'百度一下',frameurl:'http://www.baidu.com',barIcon:'images/icon/baidu.png',iconCls:'baidu16x16'}]},
		{icon:'images/desktop/sina.png',frame:[{id:'sina',title:'新浪新闻',frameurl:'http://news.sina.com.cn/',barIcon:'images/icon/sina.png',iconCls:'sina16x16'}]},
		{icon:'images/desktop/hudongbk.png',frame:[{id:'hudongbk',title:'互动百科',frameurl:'http://www.baike.com/',barIcon:'images/icon/hudongbk.png',iconCls:'hudongbk16x16'}]},
		{icon:'images/desktop/letv.png',frame:[{id:'letv',title:'乐视网',frameurl:'http://www.letv.com/',barIcon:'images/icon/letv.png',iconCls:'letv16x16'}]},
		{icon:'images/desktop/qianqian.png',frame:[{id:'qianqian',title:'千千静听',frameurl:'http://qianqian.baidu.com/',barIcon:'images/icon/qianqian.png',iconCls:'qianqian16x16'}]},
		{icon:'images/desktop/doubandt.png',frame:[{id:'doubandt',title:'豆瓣电台',frameurl:'http://douban.fm/',barIcon:'images/icon/doubandt.png',iconCls:'doubandt16x16'}]},
		{icon:'images/desktop/taobao.png',frame:[{id:'taobao',title:'淘宝网',frameurl:'http://www.taobao.com/',barIcon:'images/icon/taobao.png',iconCls:'taobao16x16'}]},
		{icon:'images/desktop/zhongguancun.png',frame:[{id:'zhongguancun',title:'中关村在线',frameurl:'http://www.zol.com.cn/',barIcon:'images/icon/zhongguancun.png',iconCls:'zhongguancun16x16'}]}
	]);
	//用户退出登录
	$('#userDiv').find("a").click(function(){
		$.messager.confirm('系统确认信息', '确定要退出系统吗？', function(r){
            if (r){
            	$.get('logout.shtml',function(data){
            		window.location.href="index.html";
            	});
            }
        });
	});
});