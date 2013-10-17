$(function(){
	var data = [{
            "id": 1,
            "text": "系统",
            "children": [{
                "id": 11,
                "text": "用户管理",
                "children": [{
                    "id": 19,
                    "text": "增加"
                }, {
                    "id": 3,
                    "text": "修改"
                }, {
                    "id": 5,
                    "text": "删除"
                }]
            }, {
                "id": 12,
                "text": "角色管理",
                "children": [{
                    "id": 13,
                    "text": "增加"
                }, {
                    "id": 3,
                    "text": "修改"
                }, {
                    "id": 5,
                    "text": "删除"
                }]
            }]
        }, {
            "id": 2,
            "text": "其他",
            "state": "closed"
        }];

        $(function () {
            $("#tt").tree({
                data: data,
                checkbox: true,
                cascadeCheck: false,
                onCheck: function (node, checked) {
                    if (checked) {
                        var parentNode = $("#tt").tree('getParent', node.target);
                        if (parentNode != null) {
                            $("#tt").tree('check', parentNode.target);
                        }
                    } else {
                        var childNode = $("#tt").tree('getChildren', node.target);
                        if (childNode.length > 0) {
                            for (var i = 0; i < childNode.length; i++) {
                                $("#tt").tree('uncheck', childNode[i].target);
                            }
                        }
                    }
                }
            });
        });
});


        function getChecked()
        {
            var arr = [];
            var checkeds = $('#tt').tree('getChecked', 'checked');
            for (var i = 0; i < checkeds.length; i++) {
                arr.push(checkeds[i].id);
            }
            alert(arr.join(','));
        }