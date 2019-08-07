<!--thisisid: tShHospitalList -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院信息</title>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<body>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:0px;border:0px">
		<table id="tShHospitalList"></table>  
	</div>
	<div id = "tShHospitalListToolbar">
		<div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
			<form id="tShHospitalForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
				<div class="seerch-div">
					<label>代码:</label>
					<div class="search-control">
						<input class="dts search-inp" type="text" name="hospcode" placeholder="请输入代码"/>
					</div>
				</div>
				<div class="seerch-div">
					<label>等级:</label>
					<div class="search-control">
						<select name = "hosplevel" class="dts search-inp search-select"></select>
					</div>
				</div>
				<div class="seerch-div">
					<label>医院名称:</label>
					<div class="search-control">
						<input class="dts search-inp" type="text" name="hospname" placeholder="请输入医院名称"/>
					</div>
				</div>
				<div class="seerch-div">
					<label style="visibility:hidden">查询</label>
					<div>
					<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="doSearch()">
						<i class="fa fa-search"></i>
						<span>查询</span>
					</button>
					
					<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="resetSearch()">
						<i class="fa fa-refresh"></i>
						<span>重置</span>
					</button>
					</div>
				</div>
			</form>
		</div>
		<div class="toolbar-btn">
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs"
					operationCode="add"
					onclick="add('录入','tShHospitalController.do?goAdd','tShHospitalList',768,500)">
				<i class="fa fa-plus"></i>
				<span>录入</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs"

					onclick="update('编辑','tShHospitalController.do?goUpdate','tShHospitalList',768,500)">
				<i class="fa fa-edit"></i>
				<span>编辑</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('查看','tShHospitalController.do?goUpdate&load=detail','tShHospitalList',768,500)">
				<i class="fa fa-search"></i>
				<span>查看</span>
			</button>

            <button type="button"
					operationCode="match"
					class="tool-btn tool-btn-default tool-btn-xs" onclick="added()">
               <i class="fa fa-plus"></i>
               <span>关联用户</span>
            </button>

			<button type="button"
					operationCode="batchdelete"
					class="tool-btn tool-btn-default tool-btn-xs" onclick="deleteALLSelect('批量删除','tShHospitalController.do?doBatchDel','tShHospitalList',null,null)">
				<i class="fa fa-trash"></i>
				<span>批量删除</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="openuploadwin('Excel导入', 'tShHospitalController.do?upload', 'tShHospitalList')">
				<i class="fa fa-download"></i>
				<span>导入</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShHospitalController.do?exportXls','tShHospitalList')">
				<i class="fa fa-upload"></i>
				<span>导出</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShHospitalController.do?exportXlsByT','tShHospitalList')">
				<i class="fa fa-upload"></i>
				<span>模版下载</span>
			</button>
		
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tShHospitalList').datagrid('resize');});">
				<i class="fa fa-arrow-circle-left"></i>
				<span>检索</span>
			</button>
		</div>
	</div>
</div>

<script>
var tShHospitalListdictsData = {};
$(function(){
	var promiseArr = [];
	initDictByCode(tShHospitalListdictsData,"hosplevel",promiseArr,"","");
	initDictByCode(tShHospitalListdictsData,"isactive",promiseArr,"","");
	initDictByCode(tShHospitalListdictsData,"id",promiseArr,"t_s_region","name");
	$.when.apply(null,promiseArr).done(function(){
    	initDatagrid();
		$('#tShHospitalList').datagrid('getPager').pagination({
	        beforePageText: '',
	        afterPageText: '/{pages}',
	        displayMsg: '{from}-{to}共 {total}条',
	        showPageList: true,
	        showRefresh: true
	    });
	    $('#tShHospitalList').datagrid('getPager').pagination({
	        onBeforeRefresh: function(pageNumber, pageSize) {
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    });
		loadSearchFormDicts($("#tShHospitalForm").find("select[name='hosplevel']"),"","hosplevel","select","等级");
	}).fail(function(){
		console.log("i'm sorry!it's unkown error that i can't resolve as yet");
	});
});

//easyui-datagrid实例化
function initDatagrid(){
	var actionUrl = "tShHospitalController.do?datagrid&field=address,createDate,createName,fax,hospcode,hosplevel,hospname,hospnameeng,hospnameshort,id,isactive,logofilename,memo,regcode,tel,thepercent,updateDate,updateName,versionname,regionid,";
 	$('#tShHospitalList').datagrid({
		url:actionUrl,
		idField: 'id', 
		title: '',
		loadMsg: '数据加载中...',
		fit:true,
		fitColumns:true,
		striped:true,
		autoRowHeight: true,
		pageSize: 10,
		pagination:true,
		singleSelect:false,
		pageList:[10,30,50,100],
		rownumbers:true,
		showFooter:true,
		sortName:'createDate',
		sortOrder:'desc',
		toolbar: '#tShHospitalListToolbar',
		frozenColumns:[[]],
		columns:[[
			{field:'ck',checkbox:true,},
            {
                field : "hospname",
                title : "医院名称",
                width : 260,
				halign :"center",
                sortable: true,
            },{
                field : "hospnameshort",
                title : "简称",
                width : 180,
				halign : "center",
                sortable: true,
            },{
                field : "hospnameeng",
                title : "英文名",
                width : 120,
				align : "center",
                sortable: true,
            },{
                field : "hospcode",
                title : "代码",
                width : 140,
				align : "center",
                sortable: true,
            },{
                field : "hosplevel",
                title : "等级",
                width : 60,
				align : "center",
                sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,"hosplevel","");
                }
            },{
				field : "address",
				title : "地址",
				width : 160,
				halign : "center",
				sortable: true,
			},
			{
				field : "regionid",
				title : "区域",
				width : 60,
				align : "center",
				sortable: true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"id","t_s_region");
				}
			},{
				field : "createDate",
				title : "创建日期",
				width : 120,
				align : "center",
				sortable: true,
				hidden:true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			},{
				field : "createName",
				title : "创建人名称",
				width : 120,
				align : "center",
				sortable: true,
				hidden:true,
			}
			,{
				field : "tel",
				title : "电话",
				width : 100,
				align : "center",
				sortable: true,
			}
			,{
				field : "fax",
				title : "传真",
				width : 100,
				align : "center",
				sortable: true,
			}
			,{
				field : "thepercent",
				title : "基药占比",
				width : 120,
				align : "center",
				sortable: true,
			}
			,{
				field : "id",
				title : "id",
				width : 120,
				align : "center",
				sortable: true,
				hidden:true,
			}
			,{
				field : "isactive",
				title : "是否在用",
				width : 80,
				align : "center",
				sortable: true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"isactive","");
				}
			}
			,{
				field : "logofilename",
				title : "图标名称",
				width : 80,
				align : "center",
				sortable: true,
				formatter:function(value,rec,index){
					return "<img src='"+value+"' width='30' height='30'>";
			 	}
			}
			,{
				field : "memo",
				title : "备注",
				width : 120,
				halign : "center",
				sortable: true,
			}
			,{
				field : "regcode",
				title : "注册码",
				width : 120,
				sortable: true,
				hidden : true,
			}
			,{
				field : "updateDate",
				title : "更新日期",
				width : 120,
				sortable: true,
				hidden:true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "updateName",
				title : "更新人名称",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "versionname",
				title : "系统版本",
				width : 120,
				sortable: true,
                hidden : true,
			}
			,{
	            field: 'opt',title: '操作',width: 150,align : "center",
	            formatter: function(value, rec, index) {
	                if (!rec.id) {
	                    return '';
	                }
	                var href = '';
	                href += "<a href='#' class='ace_button'  onclick=delObj('tShHospitalController.do?doDel&id=" + rec.id + "','tShHospitalList')>  <i class=' fa fa-trash-o'></i> ";
	                href += "删除</a>&nbsp;";
	                return href;
	            }
	        }
		]],
		onLoadSuccess: function(data) {
            $("#tShHospitalList").datagrid("clearSelections");
            if (!false) {
                if (data.total && data.rows.length == 0) {
                    var grid = $('#tShHospitalList');
                    var curr = grid.datagrid('getPager').data("pagination").options.pageNumber;
                    grid.datagrid({
                        pageNumber: (curr - 1)
                    });
                }
            }
        }
	});
}
//easyui-datagrid重新加载
function reloadTable() {
	 $('#tShHospitalList').datagrid('reload');
}
//easyui-datagrid搜索
function doSearch(){
	var queryParams = $('#tShHospitalList').datagrid('options').queryParams;
	var actionUrl = "tShHospitalController.do?datagrid&field=address,createDate,createName,fax,hospcode,hosplevel,hospname,hospnameeng,hospnameshort,id,isactive,logofilename,memo,regcode,tel,thepercent,updateDate,updateName,versionname,regionid,";
	$('#tShHospitalForm').find(':input').each(function() {
		var paramName = $(this).attr('name');
		if(!!paramName){
			if("checkbox"== $(this).attr("type")){
				queryParams[paramName] = getCheckboxVal(paramName);
			}else if("radio"== $(this).attr("type")){
				queryParams[paramName] = getRadioVal(paramName);
			}else{
				queryParams[paramName] = $(this).val();
			}
		}
    });
	
    $('#tShHospitalList').datagrid({
        url: actionUrl,
        pageNumber: 1
    });
}
//easyui-datagrid重置搜索
function resetSearch(){
    var queryParams = $('#tShHospitalList').datagrid('options').queryParams;
    $('#tShHospitalForm').find(':input').each(function() {
    	if("checkbox"== $(this).attr("type")){
    		$("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else if("radio"== $(this).attr("type")){
			$("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else{
			$(this).val("");
		}
        queryParams[$(this).attr('name')] = "";
    });
    $('#tShHospitalForm').find("input[type='checkbox']").each(function() {
        $(this).attr('checked', false);
    });
    $('#tShHospitalForm').find("input[type='radio']").each(function() {
        $(this).attr('checked', false);
    });
    var actionUrl = "tShHospitalController.do?datagrid&field=address,createDate,createName,fax,hospcode,hosplevel,hospname,hospnameeng,hospnameshort,id,isactive,logofilename,memo,regcode,tel,thepercent,updateDate,updateName,versionname,";
    $('#tShHospitalList').datagrid({
        url: actionUrl,
        pageNumber: 1
    });
}

//加载字典数据
function initDictByCode(dictObj,code,promiseArr,table,text){
	var dictKey = code;
	if(code=="id"){
		//如果当前dictcode为id那么，此处的字典对象对应的key为"表名+id"
		dictKey = table+code;
	}
	if(!dictObj[dictKey]){
		var url = "systemController.do?typeListJson&typeGroupName="+code;
		if(table){
			url += "&dicTable="+table+"&dicText="+text;
		}
		var dictAjax = jQuery.ajax({
            url:url,
    		type:"GET",
       		dataType:"JSON",
            success: function (back) {
               if(back.success){
            	   dictObj[dictKey]= back.obj;
               }
             }
         });
         promiseArr.push(dictAjax);
	}
}
//加载form查询数据字典项
function loadSearchFormDicts(obj,table,code,type,name){
	var html = "";
	var dictKey = code;
	if(code=="id"){
		dictKey = table+code;
	}
	var arr = tShHospitalListdictsData[dictKey];
	for(var a = 0;a < arr.length;a++){
		if("select"== type){
			if(a==0){
				html+="<option value = '' style='display: none'> 请选择"+name+"</option>";
			}
			html+="<option value = '"+arr[a].typecode+"'>"+arr[a].typename+"</option>";
		}else{
			if(!arr[a].typecode){
			}else{
				html+="<input name = '"+name+"' type='"+type+"' value = '"+arr[a].typecode+"'>"+arr[a].typename +"&nbsp;&nbsp;";
			}
		}
    }
	obj.html(html);
}
//获取Checkbox的值
function getCheckboxVal(name){
    var result = new Array();
    $("input[name='" + name + "']:checkbox").each(function() {
        if ($(this).is(":checked")) {
            result.push($(this).attr("value"));
        }
    });
    return result.join(",");
}
//获取radio的值
function getRadioVal(name){
	var v = $('input:radio[name="'+name+'"]:checked').val();
	if(!v){
		v ="";
	}
	return v;
}
//列表数据字典项格式化
function listDictFormat(value,code,table){
	if (!value) return '';
	var dictKey = code;
	if(code=="id"){
		dictKey = table+code;
	}
	var dicts = tShHospitalListdictsData[dictKey];
    var valArray = value.split(',');
    var showVal = '';
    if (valArray.length > 1) {
    	for (var k = 0; k < valArray.length; k++) {
           if(dicts && dicts.length>0){
        	   for(var a = 0;a < dicts.length;a++){
                	if(dicts[a].typecode ==valArray[k]){
                		showVal = showVal + dicts[a].typename + ',';
                		 break;
                	}
                }
           }
        }
        showVal=showVal.substring(0, showVal.length - 1);
    }else{
    	if(dicts && dicts.length>0){
    	   for(var a = 0;a < dicts.length;a++){
            	if(dicts[a].typecode == value){
            		showVal =  dicts[a].typename;
            		 break;
            	}
            }
       }
    }
    if(showVal==''){
    	showVal = value;
    }
    return showVal;
}

function added() {
    var url="tShUserHospRelController.do?goAdd&hospid=";
    var rows = $("#tShHospitalList").datagrid("getSelections");
    if(rows.length == 1) {
        createwindow("关联用户",url+rows[0].id,800,500);
    }else alert("只能选择一行操作");
}
</script>
</body>
</html>