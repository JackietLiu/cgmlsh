<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBExportSqlList" checkbox="false" pagination="true" fitColumns="true" title="导出数据" actionUrl="tBExportSqlController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="脚本"  field="sqlscript"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="保存文件名"  field="thefile"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="连接字符串"  field="connstr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="theusername"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="密码"  field="thepassword"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数据库类型"  field="thedbtype"  queryMode="single"  dictionary="dbtype"  width="120"></t:dgCol>
   <t:dgCol title="插入的表名"  field="thetablename"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBExportSqlController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   
   <t:dgToolBar title="录入" icon="icon-add" url="tBExportSqlController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBExportSqlController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBExportSqlController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tBExportSqlController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="导出脚本" icon="icon-putout" funname="Exportsql"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/configtools/tbexportsql/tBExportSqlList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 //zczadd begin
 function Exportsql() {
	 var row = $('#tBExportSqlList').datagrid('getSelected');
     if (!row) {
         $.messager.alert('提信息示', "对不起，请先选择一条记录信息，才可以导出相应的sql语句！","info");
         return;
     }
     else {
    	 
     } 
     var finalurl1="tBExportSqlController.do?execute&sqlscript="
    		 +encodeURI(row.sqlscript) 
    		 +"&thefile="+encodeURI(row.thefile)   
    		 +"&connstr="+encodeURI(row.connstr )
    		 +"&theusername="+encodeURI(row.theusername)
    		 +"&thepassword="+encodeURI(row.thepassword)
    		 +"&thedbtype="+encodeURI(row.thedbtype)
    		 +"&thetablename="+encodeURI(row.thetablename );
     $.ajax({
	 		cache:true ,
	 		type:"post" ,
	 		url: finalurl1 ,
	 		data:"" ,
	 		dataType:"json" ,
	 		success: function(data){		
	 			$.messager.alert('提信息示', data.msg,"info");
	 		},
	 		error:function(data){ 
	 		$.messager.alert('提信息示', data.msg,"info");
	 			 
	 		  } 
   	 	})   
     
	}  
//zczadd end
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBExportSqlController.do?upload', "tBExportSqlList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBExportSqlController.do?exportXls","tBExportSqlList");
}


//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBExportSqlController.do?exportXlsByT","tBExportSqlList");
}

 </script>