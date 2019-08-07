<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医联体下属医院</title>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
	<style>
		.datagrid .panel-body{
			overflow: hidden !important;
		}

	</style>
</head>
<body>
<!-- 当前页面 tBaConsortiumHospitalList.jsp  -->
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:0px;border:0px">
		<table id="tBaConsortiumHospitalList"></table>  
	</div>
	<div id = "tBaConsortiumHospitalListToolbar">
		<div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
			<form id="tBaConsortiumHospitalForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
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
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="add('录入','tBaConsortiumHospitalController.do?goAdd&consid=${consid}','tBaConsortiumHospitalList',768,500)">
				<i class="fa fa-plus"></i>
				<span>录入</span>
			</button>
			
			<%--<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('编辑','tBaConsortiumHospitalController.do?goUpdate','tBaConsortiumHospitalList',768,500)">
				<i class="fa fa-edit"></i>
				<span>编辑</span>
			</button>--%>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="deleteALLSelect('批量删除','tBaConsortiumHospitalController.do?doBatchDel','tBaConsortiumHospitalList',null,null)">
				<i class="fa fa-trash"></i>
				<span>批量删除</span>
			</button>
			
			<%--<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="openuploadwin('Excel导入', 'tBaConsortiumHospitalController.do?upload', 'tBaConsortiumHospitalList')">
				<i class="fa fa-download"></i>
				<span>导入</span>
			</button>

				<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tBaConsortiumHospitalController.do?exportXls','tBaConsortiumHospitalList')">
					<i class="fa fa-upload"></i>
					<span>导出</span>
				</button>

				<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tBaConsortiumHospitalController.do?exportXlsByT','tBaConsortiumHospitalList')">
					<i class="fa fa-upload"></i>
					<span>模版下载</span>
			</button>--%>
		
			<%--<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tBaConsortiumHospitalList').datagrid('resize');});">
				<i class="fa fa-arrow-circle-left"></i>
				<span>检索</span>
			</button>--%>
		</div>
	</div>
</div>

<script>
var tBaConsortiumHospitalListdictsData = {};
$(function(){
	var promiseArr = [];
	initDictByCode(tBaConsortiumHospitalListdictsData,"id",promiseArr,"t_ba_medical_consortium","thename");
	initDictByCode(tBaConsortiumHospitalListdictsData,"id",promiseArr,"t_sh_hospital","hospname");
	$.when.apply(null,promiseArr).done(function(){
    	initDatagrid();
		$('#tBaConsortiumHospitalList').datagrid('getPager').pagination({
	        beforePageText: '',
	        afterPageText: '/{pages}',
	        displayMsg: '{from}-{to}共 {total}条',
	        showPageList: true,
	        showRefresh: true
	    });
	    $('#tBaConsortiumHospitalList').datagrid('getPager').pagination({
	        onBeforeRefresh: function(pageNumber, pageSize) {
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    });
	}).fail(function(){
		console.log("i'm sorry!it's unkown error that i can't resolve as yet");
	});
});

//easyui-datagrid实例化
function initDatagrid(){
	var actionUrl = "tBaConsortiumHospitalController.do?datagrid&consid=${consid}&field=id,consid,headhospid,hospid,createName,createDate,updateName,updateDate,";
 	$('#tBaConsortiumHospitalList').datagrid({
		url:actionUrl,
		idField: 'id', 
		title: '医联体下属医院',
		loadMsg: '数据加载中...',
		fit:true,
		fitColumns:false,
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
		toolbar: '#tBaConsortiumHospitalListToolbar',
		frozenColumns:[[]],
		columns:[[
			{field:'ck',checkbox:true}
			,{
				field : "id",
				title : "id",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "consid",
				title : "联合体",
				width : 120,
				sortable: true,
                hidden:true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"id","t_ba_medical_consortium");
				}
			}
			,{
				field : "headhospid",
				title : "牵头单位",
				width : 120,
				sortable: true,
                hidden:true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"id","t_sh_hospital");
				}
			}
			,{
				field : "hospid",
				title : "基层医院",
				width : 220,
				sortable: true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"id","t_sh_hospital");
				}
			}
			,{
				field : "createName",
				title : "创建人名称",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "createDate",
				title : "创建日期",
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
	            field: 'opt',title: '操作',width: 150,
	            formatter: function(value, rec, index) {
	                if (!rec.id) {
	                    return '';
	                }
	                var href = '';
	                href += "<a href='#'   class='ace_button'  onclick=delObj('tBaConsortiumHospitalController.do?doDel&id=" + rec.id + "','tBaConsortiumHospitalList')>  <i class=' fa fa-trash-o'></i> ";
	                href += "删除</a>&nbsp;";
	                return href;
	            }
	        }
		]],
		onLoadSuccess: function(data) {
            $("#tBaConsortiumHospitalList").datagrid("clearSelections");
            if (!false) {
                if (data.total && data.rows.length == 0) {
                    var grid = $('#tBaConsortiumHospitalList');
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
	 $('#tBaConsortiumHospitalList').datagrid('reload');
}
//easyui-datagrid搜索
function doSearch(){
	var queryParams = $('#tBaConsortiumHospitalList').datagrid('options').queryParams;
	var actionUrl = "tBaConsortiumHospitalController.do?datagrid&consid=${consid}&field=id,consid,headhospid,hospid,createName,createDate,updateName,updateDate,";
	$('#tBaConsortiumHospitalForm').find(':input').each(function() {
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
	
    $('#tBaConsortiumHospitalList').datagrid({
        url: actionUrl,
        pageNumber: 1
    });
}
//easyui-datagrid重置搜索
function resetSearch(){
    var queryParams = $('#tBaConsortiumHospitalList').datagrid('options').queryParams;
    $('#tBaConsortiumHospitalForm').find(':input').each(function() {
    	if("checkbox"== $(this).attr("type")){
    		$("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else if("radio"== $(this).attr("type")){
			$("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else{
			$(this).val("");
		}
        queryParams[$(this).attr('name')] = "";
    });
    $('#tBaConsortiumHospitalForm').find("input[type='checkbox']").each(function() {
        $(this).attr('checked', false);
    });
    $('#tBaConsortiumHospitalForm').find("input[type='radio']").each(function() {
        $(this).attr('checked', false);
    });
    var actionUrl = "tBaConsortiumHospitalController.do?datagrid&consid=${consid}&field=id,consid,headhospid,hospid,createName,createDate,updateName,updateDate,";
    $('#tBaConsortiumHospitalList').datagrid({
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
	var arr = tBaConsortiumHospitalListdictsData[dictKey];
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
	var dicts = tBaConsortiumHospitalListdictsData[dictKey];
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
</script>
</body>
</html>