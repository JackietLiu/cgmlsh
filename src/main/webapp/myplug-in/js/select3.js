/** 用法  其中sel1,sel2,sel3 分别为三个select 的id
 * 
$(function () {  
    BindCategory("sel1","sel2","sel3","XXX.json");	 
})

json 的格式如下sql2json
[{"id":"1111","name":"会计基础","pId":"0"},
{"id":"2222","name":"经济法","pId":"0"},
{"id":"297e93f9675e5da101675e81ec8d0002","name":"第一章 概论","pId":"1111"},
{"id":"297e93f9675e5da101675e82420c0004","name":"第一节 测试","pId":"297e93f9675e5da101675e81ec8d0002"},
{"id":"297e93f9675e5da101675e8288e30006","name":"第一章 经济法概论","pId":"2222"}
]
 */

function BindCategory(sel1,sel2,sel3,jsonfile) {
    var $txtCategory = $("#txtCategoryId");
	// alert(jsonfile);
    $.getJSON(jsonfile,function (json) {
	 //  alert(json);
        var html = ['<option value="">请选择</option>'];
        for (var key in json) {
			 
            if (json[key].pId == "0") {
                html.push('<option value="' + json[key].id + '">' + json[key].name + '</option>');
            }
        }
		 
        //第一级类别
        $("#"+sel1).empty().append(html.join('')).change(function () {
		
            $txtCategory.val(this.value);
         
            var html = ['<option value="">请选择</option>'];
            for (var data in json) {
                if (json[data].pId ==  $("#"+sel1).val()) {
                    html.push('<option value="' + json[data].id + '">' + json[data].name + '</option>');
                }
            }
            //第二级类别
			 $("#"+sel2)
             $("#"+sel2).empty().append(html.join('')).change(function () {
                $txtCategory.val(this.value);               
               
                var html = ['<option value="">请选择</option>'];
                for (var data in json) {
                    if (json[data].pId ==  $("#"+sel2).val()) {
                        html.push('<option value="' + json[data].id + '">' + json[data].name + '</option>');
                    }
                }
                //第三级类别
				 
                $("#"+sel3).empty().append(html.join('')).change(function () {
                    $txtCategory.val(this.value);
                });
                //如果不存在第三级类别则隐藏第三级类别控件
                if ($("#"+sel3).get(0).options.length <= 1) {
                    $("#"+sel3).hide();
                    return false;
                }
            });
            //如果不存在第二级类别则隐藏第二级类别控件
            if ($("#"+sel2).get(0).options.length <= 1) {
                $("#"+sel2).hide();
                return false;
            }
           
        });
    });
};
