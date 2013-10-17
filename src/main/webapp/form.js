var $form = null;
$(function(){
	$form = $.formUI({
		id : "webform",
		name : "webform",
		//layout : 'double',
		fn : function(){alert("submit")},
		items : [{
			xt : 'text',
			id : 'text1',
			name : 'text1',
			label : 'How Are You',
			verify : 'sdf/not-null:true'
		},{
			xt : 'text',
			id : 'text2',
			name : 'text2',
			label : 'How Are You'
		},{
			xt : 'password',
			id : 't1',
			name : 't1',
			label : 'Your Password'
		},{
			xt : 'datebox',
			id : 'datebox',
			name : 'datebox',
			label : 'How Are You'
		},{
			xt : 'datetimebox',
			id : 'datetimebox',
			name : 'datetimebox',
			label : 'How Are You'
		},{
			xt : 'numberspinner',
			id : 'numberspinner',
			name : 'numberspinner',
			label : 'How Are You'
		},{
			xt : 'textarea',
			id : 't1',
			name : 't1',
			label : 'Your Intro'
		},{
			xt : 'combobox',
			id : 'combobox',
			name : 'combobox',
			label : 'Your ComboBox',
			url : 'combox.json',
			valueFiled : 'value',
			textField : 'text'
		},{
			xt : 'combogrid',
			id : 'combogrid',
			name : 'combogrid',
			label : 'Your ComboGrid',
			valueFiled : 'productid',
			textField : 'productname',
			url : 'combogrid.json',
			columns : [[
				{field:'productid',title:'value',width:80},
				{field:'productname',title:'text',width:80}
			]] 
		},{
			xt : 'combotree',
			id : 'combotree',
			name : 'combotree',
			label : 'Your ComboTree',
			valueFiled : 'id',
			textField : 'text',
			url : 'combotree.json'
		}]
	});
});