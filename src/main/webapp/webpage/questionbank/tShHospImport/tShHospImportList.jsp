<!--thisisid: tShHospImportList  -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>医院导入列表</title>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<style>
	select {
		width: 100%;
	}

</style>
<body>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:0px;border:0px">
		<table id="tShHospImportList"></table>  
	</div>
	<div id = "tShHospImportListToolbar">
		<div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
			<form id="tShHospImportForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
				<div class="seerch-div">
					<label>审核日期:</label>
					<div class="search-control">
						<input type="text" name="auditdate_begin" class="dts search-inp Wdate search-group-inp"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" placeholder="请选择开始日期"/>
						<span class="dts search-group-span">~</span>
						<input type="text" name="auditdate_end" class="dts search-inp Wdate search-group-inp" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});" placeholder="请选择结束日期"/>
					</div>
				</div>
				<div class="seerch-div">
					<label>上传批号:</label>
					<div class="search-control">
						<input class="dts search-inp" type="text" name="auditno" placeholder="请输入上传批号"/>
					</div>
				</div>
				<c:if test="${isadmin == '1'}"><%--区县管理员--%>
					<div class="seerch-div">
						<label>负责区域:</label>
						<div class="search-control">
							<%--<select name = "regionid" readonly="readonly" value="${regionid}" class="dts search-inp search-select"></select>--%>
							<t:dictSelect field="regionid" readonly="readonly" dictTable="t_s_region" dictField="id" dictText="name" dictCondition="where ((pid = 114) or (id = 114))" defaultVal="${regionid}"></t:dictSelect>
						</div>
					</div>
				</c:if>
				<c:if test="${isadmin == '0'}"><%--委管理员--%>
					<div class="seerch-div">
						<label>负责区域:</label>
						<div class="search-control">
							<t:dictSelect  field="regionid" dictTable="t_s_region" dictField="id" dictText="name" dictCondition="where ((pid = 114) or (id = 114))" hasLabel="false"  title="区域"></t:dictSelect>
						</div>
					</div>
				</c:if>


				<div class="seerch-div">
					<label>医院编号:</label>
					<div class="search-control">
						<select name = "hospid" class="dts search-inp search-select"></select>
					</div>
				</div>
				<div class="seerch-div">
					<label>状态:</label>
					<div class="search-control">
						<select name = "thestatus" class="dts search-inp search-select"></select>
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
			<%--<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="add('录入','tShHospImportController.do?goAdd','tShHospImportList',768,500)">
				<i class="fa fa-plus"></i>
				<span>录入</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('编辑','tShHospImportController.do?goUpdate','tShHospImportList',768,500)">
				<i class="fa fa-edit"></i>
				<span>编辑</span>
			</button>--%>
			
		<%--	<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="deleteALLSelect('批量删除','tShHospImportController.do?doBatchDel','tShHospImportList',null,null)">
				<i class="fa fa-trash"></i>
				<span>批量删除</span>
			</button>--%>
			
			<%--<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="openuploadwin('Excel导入', 'tShHospImportController.do?upload', 'tShHospImportList')">
				<i class="fa fa-download"></i>
				<span>导入</span>
			</button>--%>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShHospImportController.do?exportXls','tShHospImportList')">
				<i class="fa fa-upload"></i>
				<span>导出</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tShHospImportController.do?exportXlsByT','tShHospImportList')">
				<i class="fa fa-upload"></i>
				<span>模版下载</span>
			</button>
		
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tShHospImportList').datagrid('resize');});">
				<i class="fa fa-arrow-circle-left"></i>
				<span>检索</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="func_batch_audit()">
				<i class="fa fa-upload"></i>
				<span>批量审核</span>
			</button>

			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="func_audit()">
				<i class="fa fa-upload"></i>
				<span>审核</span>
			</button>

		</div>
	</div>
</div>

<script>

var tShHospImportListdictsData = {};
$(function(){
	var promiseArr = [];
	initDictByCode(tShHospImportListdictsData,"id",promiseArr,"t_sh_hospital","hospnameshort");
	initDictByCode(tShHospImportListdictsData,"thestatus",promiseArr,"","");
	$.when.apply(null,promiseArr).done(function(){
    	initDatagrid();
		$('#tShHospImportList').datagrid('getPager').pagination({
	        beforePageText: '',
	        afterPageText: '/{pages}',
	        displayMsg: '{from}-{to}共 {total}条',
	        showPageList: true,
	        showRefresh: true
	    });
	    $('#tShHospImportList').datagrid('getPager').pagination({
	        onBeforeRefresh: function(pageNumber, pageSize) {
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    });
		loadSearchFormDicts($("#tShHospImportForm").find("select[name='hospid']"),"t_sh_hospital","id","select","医院编号");
		loadSearchFormDicts($("#tShHospImportForm").find("select[name='thestatus']"),"","thestatus","select","状态");

	}).fail(function(){
		console.log("i'm sorry!it's unkown error that i can't resolve as yet");
	});
});

//easyui-datagrid实例化
function initDatagrid(){

	var actionUrl = "tShHospImportController.do?datagrid&regionid=${regionid}&field=auditdate,auditname,auditno,commitdate,commitname,createDate,createName,filename,hospid,id,memo,month,thescore,thestatus,updateDate,updateName,year,regionid,approvedate,approvename,approvestatus,";
 	$('#tShHospImportList').datagrid({
		url:actionUrl,
		idField: 'id', 
		title: '',
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
		toolbar: '#tShHospImportListToolbar',
		frozenColumns:[[]],
		rowStyler:function(index,row){
			if (row.thestatus=='0'){
				return 'background-color:yellow;color:black;font-weight:bold;';
			};
			if (row.thestatus=='10'){
				return 'background-color:green;font-weight:bold;color:white;';
			};

			if (row.thestatus>'10'){
				return 'background-color:white;color:black;font-weight:bold;';
			}
		},

		columns:[[
			{field:'ck',checkbox:true},
			{
				field : "hospid",
				title : "医院简称",
				width : 120,
				sortable: true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"id","t_sh_hospital");
				}
			}
			,
			{
				field : "auditno",
				title : "上传批号",
				width : 120,
				sortable: true,
			},{
				field : "thestatus",
				title : "状态",
				width : 100,
				sortable: true,
				formatter : function(value, rec, index) {
					return listDictFormat(value,"thestatus","");
				}
			}
			,{
				field : "createDate",
				title : "上传日期",
				width : 80,
				sortable: true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "createName",
				title : "上传人",
				width : 80,
				sortable: true,
			}
			,{
				field : "commitdate",
				title : "提交日期",
				width : 80,
				sortable: true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "commitname",
				title : "提交人",
				width : 80,
				sortable: true,
			}
			,{
				field : "auditdate",
				title : "审核日期",
				width : 80,
				sortable: true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "auditname",
				title : "审核人",
				width : 80,
				sortable: true,
			}

			,{
				field : "filename",
				title : "上传文件名",
				width : 120,
				sortable: true,
			}
			,{
				field : "id",
				title : "主键",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "memo",
				title : "备注",
				width : 120,
				sortable: true,
			},{
				field : "year",
				title : "年份",
				width : 50,
				sortable: true,
			}

			,{
				field : "month",
				title : "月份",
				width : 50,
				sortable: true,
			}
			,{
				field : "thescore",
				title : "得分",
				width : 50,
				sortable: true,
			}

			,{
	            field: 'opt',title: '操作',width: 150,
	            formatter: function(value, rec, index) {
	                if (!rec.id) {
	                    return '';
	                }
	                var href = '';
	                href += "<a href='#'   class='ace_button'  onclick=delObj('tShHospImportController.do?doDel&id=" + rec.id + "','tShHospImportList')>  <i class=' fa fa-trash-o'></i> ";
	                href += "删除</a>&nbsp;";
	                return href;
	            }
	        }
		]],
		onLoadSuccess: function(data) {
            $("#tShHospImportList").datagrid("clearSelections");
            if (!false) {
                if (data.total && data.rows.length == 0) {
                    var grid = $('#tShHospImportList');
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
	 $('#tShHospImportList').datagrid('reload');
}
//easyui-datagrid搜索
function doSearch(){
	var queryParams = $('#tShHospImportList').datagrid('options').queryParams;
	var actionUrl = "tShHospImportController.do?datagrid&field=auditdate,auditname,auditno,commitdate,commitname,createDate,createName,filename,hospid,id,memo,month,thescore,thestatus,updateDate,updateName,year,regionid,approvedate,approvename,approvestatus,";
	$('#tShHospImportForm').find(':input').each(function() {
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
	
    $('#tShHospImportList').datagrid({
        url: actionUrl,
        pageNumber: 1
    });
}
//easyui-datagrid重置搜索
function resetSearch(){
    var queryParams = $('#tShHospImportList').datagrid('options').queryParams;
    $('#tShHospImportForm').find(':input').each(function() {
    	if("checkbox"== $(this).attr("type")){
    		$("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else if("radio"== $(this).attr("type")){
			$("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else{
			$(this).val("");
		}
        queryParams[$(this).attr('name')] = "";
    });
    $('#tShHospImportForm').find("input[type='checkbox']").each(function() {
        $(this).attr('checked', false);
    });
    $('#tShHospImportForm').find("input[type='radio']").each(function() {
        $(this).attr('checked', false);
    });
    var actionUrl = "tShHospImportController.do?datagrid&field=auditdate,auditname,auditno,commitdate,commitname,createDate,createName,filename,hospid,id,memo,month,thescore,thestatus,updateDate,updateName,year,regionid,approvedate,approvename,approvestatus,";
    $('#tShHospImportList').datagrid({
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
	var arr = tShHospImportListdictsData[dictKey];
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
	var dicts = tShHospImportListdictsData[dictKey];
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

//zczadd begin   modify on  2019/2/28 13:59
function func_audit(){
	var msg=  "对不起，请先选择一条记录，才可以审核该医院的导入信息！";
	// ifselect_single_row("tShHospImportList","bootstrap-table",msg);
	var a= $("#tShHospImportList" ).datagrid('getSelected');
	if (!a) {
		$.messager.alert('提信息示', msg,"info");
		return;
	}
	else {
		var thestatus=a.thestatus;

		if(thestatus=="20"){
			var msgtt="对不起，该记录已经审核完成,不可重复审核,请重新选择!";
			$.messager.alert('提信息示', msgtt,"info");
			return;
		}
		if(thestatus!="10"){
			var msgere="对不起，该记录医院没有提交,只可对已提交的记录进行审核,请重新选择!";
			$.messager.alert('提信息示', msgere,"info");
			return;
		}
		if(thestatus=="10"){
			var hospid=a.hospid;
			var auditno=a.auditno;

			var finalaction="tShHospImportController.do?func_audit&hospid=" +hospid +"&auditno=" +auditno;
			$.ajax({
				cache:true,
				type:"post",
				url:finalaction,
				data:"",
				dataType:"json",
				success: function(data){
					$.messager.alert('提信息示', data.msg,"info");
					$("#tShHospImportList" ).datagrid("reload");
				}
			})

		}
	}

}


//zczadd end modify  on  2019/2/28 13:59
function func_batch_audit(){

	var msg=  "对不起，请至少选择一条记录，才可以审核该医院的导入信息！";
	// ifselect_single_row("tShHospImportList","bootstrap-table",msg);
	var a = $("#tShHospImportList" ).datagrid('getSelections');
	if (a.length == 0) {
		$.messager.alert('提信息示', msg,"info");
		return;
	}else {
		for (var i=0; i < a.length;i++){
			var thestatus=a[i].thestatus;

			if(thestatus=="20"){
				var msgtt="请选择未审核的记录";
				$.messager.alert('提信息示', msgtt,"info");
				return;
			}
			if(thestatus!="10"){
				var msgere="请选择已提交的记录";
				$.messager.alert('提信息示', msgere,"info");
				return;
			}
			if(thestatus=="10"){
				var hospname = listDictFormat(a[i].hospid,"id","t_sh_hospital");
				var finalaction="tShHospImportController.do?func_audit&hospid=" +a[i].hospid +"&auditno=" +a[i].auditno;

				$.ajax({
					cache:true,
					type:"post",
					url:finalaction,
					data:"",
					dataType:"json",
					success: function(data){

						$("#tShHospImportList" ).datagrid("reload");
					}
				})



			}
		}


	}


}



</script>
</body>
</html>