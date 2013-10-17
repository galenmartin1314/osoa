(function($) {
	var keylist = new Array();
	var nextFocus = function(index){
		index = index + 1;
		if(keylist.length>index){
			keylist[index].focus();
		}else{
			parent.myDesk.btnfo();
		}
	}
	var defaults={
		id : 'form0',
		name : 'form0',
		method : 'post',
		target : '',
		action : '',
		layout : 'single', //this value between single and double,
		cls : '',
		css : '',
		fn : function(){},
		items : [],
		buttons : []
	};
	var Text = function(options, $td, index){//xt:'text'
		var defaults={
			id : 'input0',
			name : 'input0',
			label : '文本框',
			cls : '',
			css : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input type='text' />");
		_text.attr("id",ops.id).attr("name",ops.name).attr("class",ops.cls).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		//添加验证
		if(ops.verify){
			_text.attr("verify",ops.verify);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = _text;
		_text.keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var PassWord = function(options, $td, index){//xt:'password'
		var defaults={
			id : 'input0',
			name : 'input0',
			label : '密码框',
			cls : '',
			css : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input type='password' />");
		_text.attr("id",ops.id).attr("name",ops.name).attr("class",ops.cls).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		//添加验证
		if(ops.verify){
			_text.attr("verify",ops.verify);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = _text;
		_text.keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var DateBox = function(options, $td, index){//xt:'datebox'
		var defaults={
			id : 'input0',
			name : 'input0',
			label : '日期输入',
			cls : '',
			css : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input type='text' />");
		_text.attr("id",ops.id).attr("name",ops.name).attr("class",ops.cls).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		_text.datebox();
		//添加验证
		if(ops.verify){
			$(_text.parent().find("input").get(1)).attr("verify",ops.verify);
			$(_text.parent().find("input").get(1)).attr("id",ops.id+1);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = $(_text.parent().find("input").get(1));
		$(_text.parent().find("input").get(1)).keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var DateTimeBox = function(options, $td, index){//xt:'datetimebox'
		var defaults={
			id : 'input0',
			name : 'input0',
			label : '日期输入',
			cls : '',
			css : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input type='text' />");
		_text.attr("id",ops.id).attr("name",ops.name).attr("class",ops.cls).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		_text.datetimebox();
		//添加验证
		if(ops.verify){
			$(_text.parent().find("input").get(1)).attr("verify",ops.verify);
			$(_text.parent().find("input").get(1)).attr("id",ops.id+1);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = $(_text.parent().find("input").get(1));
		$(_text.parent().find("input").get(1)).keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var NumberSpinner = function(options, $td, index){//xt:'numberspinner'
		var defaults={
			id : 'input0',
			name : 'input0',
			label : '数字输入',
			min : 0,
			max : 100,
			cls : '',
			css : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input type='text' />");
		_text.attr("id",ops.id).attr("name",ops.name).attr("class",ops.cls).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		_text.numberspinner({
			min : ops.min,
			max : ops.max
		});
		//添加验证
		if(ops.verify){
			_text.attr("verify",ops.verify);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = _text;
		_text.keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var Hidden = function(options, $form){//xt:'hidden'
		var defaults={
			id : 'input0',
			name : 'input0'
		};
		var ops = $.extend(defaults, options);
		var _text = $("<input type='hidden' />");
		_text.attr("id",ops.id).attr("name",ops.name);
		_text.appendTo($form);
	};
	var TextAare = function(options, $td, index){//xt:'textarea'
		var defaults={
			id : 'input0',
			name : 'input0',
			label : '文本域',
			rows : 3,
			cols : 200,
			cls : '',
			css : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<textarea></textarea>");
		_text.attr("id",ops.id).attr("name",ops.name).attr("class",ops.cls).attr("rows",ops.rows).attr("cols",ops.cols).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		//添加验证
		if(ops.verify){
			_text.attr("verify",ops.verify);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = _text;
		_text.keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var ComboBox = function(options,$td, index){
		var defaults={
			id : 'combobox0',
			name : 'combobox0',
			label : '选择框',
			css : {},
			valueFiled : 'value',
			textField : 'text',
			data : [],
			url : ''
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input />");
		_text.attr("id",ops.id).attr("name",ops.name).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		if(ops.data.length>0){
			_text.combobox({
				data : ops.data,
				valueFiled : ops.valueFiled,
				textField : ops.textField
			});
		}else if(ops.url!=""){
			_text.combobox({
				url : ops.url,
				valueFiled : ops.valueFiled,
				textField : ops.textField
			});
		}else{_text.combobox();}
		//添加验证
		if(ops.verify){
			$(_text.parent().find("input").get(1)).attr("verify",ops.verify);
			$(_text.parent().find("input").get(1)).attr("id",ops.id+1);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = $(_text.parent().find("input").get(1));
		$(_text.parent().find("input").get(1)).keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var ComboGrid = function(options,$td, index){
		var defaults={
			id : 'combobox0',
			name : 'combobox0',
			label : '选择框',
			css : {},
			valueFiled : 'value',
			textField : 'text',
			panelWidth : 500,
			panelHeight : 100,
			url : '',
			method: 'get',
			columns : [[]],
			fitColumns: true
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input />");
		_text.attr("id",ops.id).attr("name",ops.name).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		_text.combogrid({
			panelWidth : ops.panelWidth,
			panelHeight : ops.panelHeight,
			url : ops.url,
			method: ops.method,
			valueFiled : ops.valueFiled,
			textField : ops.textField,
			columns : ops.columns,
			fitColumns : ops.fitColumns
		});
		//添加验证
		if(ops.verify){
			$(_text.parent().find("input").get(1)).attr("verify",ops.verify);
			$(_text.parent().find("input").get(1)).attr("id",ops.id+1);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = $(_text.parent().find("input").get(1));
		$(_text.parent().find("input").get(1)).keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
	var ComboTree = function(options,$td, index){
		var defaults={
			id : 'combobox0',
			name : 'combobox0',
			label : '选择框',
			css : {},
			valueFiled : 'value',
			textField : 'text',
			panelWidth : 300,
			panelHeight : 100,
			url : '',
			method: 'get'
		};
		var ops = $.extend(defaults, options);
		var _label = $("<label></label>");
		_label.html(ops.label + ":&nbsp;");
		var _text = $("<input />");
		_text.attr("id",ops.id).attr("name",ops.name).css({width:"200px"}).css(ops.css);
		$td.append(_label).append(_text);
		_text.combotree({
			panelWidth : ops.panelWidth,
			panelHeight : ops.panelHeight,
			url : ops.url,
			method: ops.method,
			valueFiled : ops.valueFiled,
			textField : ops.textField
		});
		//添加验证
		if(ops.verify){
			$(_text.parent().find("input").get(1)).attr("verify",ops.verify);
			$(_text.parent().find("input").get(1)).attr("id",ops.id+1);
			if(ops.verify.indexOf("not-null")!=-1)$td.append("<label style='color:#f00;'> *</label>");
		}
		//回车事件
		keylist[keylist.length] = $(_text.parent().find("input").get(1));
		$(_text.parent().find("input").get(1)).keydown(function(event){
			if(event.which == 13){
				nextFocus(index);
			}
		});
	};
    $.formUI = function(options) {
        var ops = $.extend(defaults, options);
        $form = $("<form></form>");
        //append to body
        if(ops.target=='')
        	$form.appendTo($('body'));
        else
        	$form.appendTo(ops.target);
        $form.attr("id",ops.id).attr("name",ops.name).attr("method",ops.method).attr("action",ops.action);
        //create body
        $tb = $("<table border='0' cellspacing='0' cellspadding='0'><tbody></tbody></table>");
        $tb.css({fontSize:'12px',margin:"15px"});
        $tb.appendTo($form);
        $tr = $("<tr></tr>");
        $tr.appendTo($tb);
        var column = 1;
        for(var idx=0;idx<ops.items.length;idx++){
        	var item = ops.items[idx];
        	if(item.xt!='hidden'){
	        	$td = $("<td></td>").css({height:"30px",padding:"4px"});
	        	$td.appendTo($tr);
        	}
        	if(item.inline){
        		$td.attr("colspan",2);
        		column=2;
        	}
        	switch(item.xt){
        		case "text":
        			Text(item,$td,idx);
        			break;
        		case "password":
        			PassWord(item,$td,idx);
        			break;
        		case "datebox":
        			DateBox(item,$td,idx);
        			break;
        		case "datetimebox":
        			DateTimeBox(item,$td,idx);
        			break;
        		case "numberspinner":
        			NumberSpinner(item,$td,idx);
        			break;
        		case "hidden":
        			Hidden(item,$form);
        			break;
        		case "textarea":
        			TextAare(item,$td,idx);
        			break;
        		case "combobox":
        			ComboBox(item,$td,idx);
        			break;
        		case "combogrid":
        			ComboGrid(item,$td,idx);
        			break;
        		case "combotree":
        			ComboTree(item,$td,idx);
        			break;
        		default:
        			return;
        	}
        	if(item.xt!='hidden'){
	    		if(ops.layout=="single"){
			        if(idx!=ops.items.length-1){
			        	$tr = $("<tr></tr>");
			        	$tr.appendTo($tb);
			        }
	    		}else{
	    			if(idx!=ops.items.length-1 && column==2){
			        	$tr = $("<tr></tr>");
			        	$tr.appendTo($tb);
			        	column = 1;
			        }else{
			        	column = column + 1;
			        }
	    		}
        	}
        }
        return $form;
    };
})(jQuery);