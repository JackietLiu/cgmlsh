<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="vsConfigList" checkbox="true" pagination="true" fitColumns="true" title="vs_config" actionUrl="vsConfigController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="entid"  field="entid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="deptid"  field="deptid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="userid"  field="userid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="userid2"  field="userid2"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="roleid"  field="roleid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="managerlevel"  field="managerlevel"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="code"  field="code"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="confname"  field="confname"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="thevalue"  field="thevalue"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="groupflag"  field="groupflag"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="codedetail"  field="codedetail"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="category"  field="category"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="configlevel"  field="configlevel"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="vsConfigController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="vsConfigController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="vsConfigController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="vsConfigController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="vsConfigController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/yiliao/tbconfig/vsConfigList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'vsConfigController.do?upload', "vsConfigList");
}

//导出
function ExportXls() {
	JeecgExcelExport("vsConfigController.do?exportXls","vsConfigList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("vsConfigController.do?exportXlsByT","vsConfigList");
}

 </script>