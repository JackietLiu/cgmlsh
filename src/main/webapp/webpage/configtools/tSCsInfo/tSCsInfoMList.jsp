<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基地平台_实验室</title>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<link rel="stylesheet" href="plug-in/themes/naturebt/css/search-form.css">
<script type="text/javascript" src="myplug-in/polyfill.min.js"></script>
</head>
<body>
<div id="main_list" class="easyui-layout" fit="true">
	<div region="center" style="padding:0px;border:0px">
		<table id="tSCsInfoMList"></table>  
	</div>
	<div id = "tSCsInfoMListToolbar">
		<div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
			<form id="tSCsInfoMForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
				<div class="seerch-div">
					<label>姓名:</label>
					<div class="search-control">
						<input class="dts search-inp" type="text" name="csname" placeholder="请输入姓名"/>
					</div>
				</div>
				<div class="seerch-div">
					<label>在用:</label>
					<div class="search-control">
						<select name = "isactive" class="dts search-inp search-select"></select>
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
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="add('录入','tSCsInfoMController.do?goAdd','tSCsInfoMList',768,500)">
				<i class="fa fa-plus"></i>
				<span>录入</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('编辑','tSCsInfoMController.do?goUpdate','tSCsInfoMList',768,500)">
				<i class="fa fa-edit"></i>
				<span>编辑</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="deleteALLSelect('批量删除','tSCsInfoMController.do?doBatchDel','tSCsInfoMList',null,null)">
				<i class="fa fa-trash"></i>
				<span>批量删除</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="openuploadwin('Excel导入', 'tSCsInfoMController.do?upload', 'tSCsInfoMList')">
				<i class="fa fa-download"></i>
				<span>导入</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tSCsInfoMController.do?exportXls','tSCsInfoMList')">
				<i class="fa fa-upload"></i>
				<span>导出</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tSCsInfoMController.do?exportXlsByT','tSCsInfoMList')">
				<i class="fa fa-upload"></i>
				<span>模版下载</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tSCsInfoMList').datagrid('resize');});">
				<i class="fa fa-arrow-circle-left"></i>
				<span>检索</span>
			</button>
		</div>
	</div>
	 <div data-options="region:'east',
	title:'联系方式',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
	style="width: 400px; overflow: hidden;" id="eastPanel">
    	<div class="easyui-panel" style="padding:0px;border:0px" fit="true" border="false" id="userListpanel"></div>
	</div>
</div>

<script>
var tSCsInfoMListdictsData = {};
var li_east = 0;

$(function(){
	var promiseArr = [];
	initDictByCode(tSCsInfoMListdictsData,"isactive",promiseArr,"","");
	$.when.apply(null,promiseArr).done(function(){
		initDatagrid();
		$('#tSCsInfoMList').datagrid('getPager').pagination({
			beforePageText: '',
			afterPageText: '/{pages}',
			displayMsg: '{from}-{to}共 {total}条',
			showPageList: true,
			showRefresh: true
		});
		$('#tSCsInfoMList').datagrid('getPager').pagination({
			onBeforeRefresh: function(pageNumber, pageSize) {
				$(this).pagination('loading');
				$(this).pagination('loaded');
			}
		});
		loadSearchFormDicts($("#tSCsInfoMForm").find("select[name='isactive']"),"","isactive","select","在用");
	}).fail(function(){
		console.log("i'm sorry!it's unkown error that i can't resolve as yet");
	});
});
//easyui-datagrid实例化
function initDatagrid(){
	var actionUrl = "tSCsInfoMController.do?datagrid&field=id,createName,createDate,updateName,updateDate,csname,begintime,endtime,isactive,memo,sortindex,";
	$('#tSCsInfoMList').datagrid({
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
		toolbar: '#tSCsInfoMListToolbar',
		frozenColumns:[[]],
		columns:[[
			{field:'ck',checkbox:true}
			,{
				field : "id",
				title : "主键",
				width : 120,
				sortable: true,
				hidden:true,
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
				field : "csname",
				title : "姓名",
				width : 120,
				sortable: true,
				align : "center",
			}
			,{
				field : "begintime",
				title : "开始时间",
				width : 120,
				sortable: true,
				align : "center",
			}
			,{
				field : "endtime",
				title : "结束时间",
				width : 120,
				sortable: true,
				align : "center",
			}
			,{
				field : "isactive",
				title : "在用",
				width : 120,
				sortable: true,
				align : "center",
				formatter : function(value, rec, index) {
					return listDictFormat(value,"isactive","");
				}
			}
			,{
				field : "memo",
				title : "备注",
				width : 120,
				sortable: true,
				align : "center",
			}
			,{
				field : "sortindex",
				title : "排序",
				width : 120,
				sortable: true,
				align : "center",
				hidden : true,
			}
			,{
				field: 'opt',title: '操作',width: 150,align : "center",
				formatter: function(value, rec, index) {
					if (!rec.id) {
						return '';
					}
					var href = '';
					href += "<a href='#'   class='ace_button'  onclick=delObj('tSCsInfoMController.do?doDel&id=" + rec.id + "','tSCsInfoMList')>  <i class=' fa fa-trash-o'></i> ";
					href += "删除</a>&nbsp;";
					href += "<a href='#'   class='ace_button'  onclick=queryUsersByDepart('"+rec.id+"','"+rec.csname+"')>  <i class=' fa fa-edit'></i> ";
					href += "联系方式</a>&nbsp;";
					return href;
				}
			}
		]],
		onLoadSuccess: function(data) {
			$("#tSCsInfoMList").datagrid("clearSelections");
			if (!false) {
				if (data.total && data.rows.length == 0) {
					var grid = $('#tSCsInfoMList');
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
	 $('#tSCsInfoMList').datagrid('reload');
}

   

function queryUsersByDepart(id,username){
    var title = '用户:'+username;
    if(li_east == 0 || $('#main_list').layout('panel','east').panel('options').title != title){
        $('#main_list').layout('expand','east');
    }
    <%--$('#eastPanel').panel('setTitle','<t:mutiLang langKey="member.list"/>');--%>
    $('#main_list').layout('panel','east').panel('setTitle', title);
    $('#main_list').layout('panel','east').panel('resize', {width: 600});
    $('#userListpanel').panel("refresh", "tSCsInfoMController.do?operation&functionId=" + id);
}

//easyui-datagrid搜索
function doSearch(){
	var queryParams = $('#tSCsInfoMList').datagrid('options').queryParams;
	var actionUrl = "tSCsInfoMController.do?datagrid&field=id,createName,createDate,updateName,updateDate,csname,begintime,endtime,isactive,memo,sortindex,";
	$('#tSCsInfoMForm').find(':input').each(function() {
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

	$('#tSCsInfoMList').datagrid({
		url: actionUrl,
		pageNumber: 1
	});
}
//easyui-datagrid重置搜索
function resetSearch(){
	var queryParams = $('#tSCsInfoMList').datagrid('options').queryParams;
	$('#tSCsInfoMForm').find(':input').each(function() {
		if("checkbox"== $(this).attr("type")){
			$("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else if("radio"== $(this).attr("type")){
			$("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else{
			$(this).val("");
		}
		queryParams[$(this).attr('name')] = "";
	});
	$('#tSCsInfoMForm').find("input[type='checkbox']").each(function() {
		$(this).attr('checked', false);
	});
	$('#tSCsInfoMForm').find("input[type='radio']").each(function() {
		$(this).attr('checked', false);
	});
	var actionUrl = "tSCsInfoMController.do?datagrid&field=id,createName,createDate,updateName,updateDate,csname,begintime,endtime,isactive,memo,sortindex,";
	$('#tSCsInfoMList').datagrid({
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
	var arr = tSCsInfoMListdictsData[dictKey];
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
	var dicts = tSCsInfoMListdictsData[dictKey];
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
//列表文件图片 列格式化方法
function listFileImgFormat(value,type){
	var href='';
	if(value==null || value.length==0){
		return href;
	}
	var value1 = "systemController/showOrDownByurl.do?dbPath="+value;
	if("image"==type){
 		href+="<img src='"+value1+"' width=30 height=30  onmouseover='tipImg(this)' onmouseout='moveTipImg()' style='vertical-align:middle'/>";
	}else{
 		if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
 			href+="<img src='"+value1+"' onmouseover='tipImg(this)' onmouseout='moveTipImg()' width=30 height=30 style='vertical-align:middle'/>";
 		}else{
 			var value2 = "systemController/showOrDownByurl.do?down=1&dbPath="+value;
 			href+="<a href='"+value2+"' class='ace_button' style='text-decoration:none;' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
 		}
	}
	return href;
}
</script>
</body>
</html>