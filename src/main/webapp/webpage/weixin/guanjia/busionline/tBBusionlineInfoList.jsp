<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN 20180926200758 -->
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBBusionlineInfoList" checkbox="false" pagination="true" fitColumns="false"   actionUrl="tBBusionlineInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   	<t:dgCol title="排序"  field="sortindex"    queryMode="single"  width="40"></t:dgCol>
   	<t:dgCol title="业务简称"  field="businameshort"    queryMode="single"  width="100"></t:dgCol>	
    <t:dgCol title="业务名称"  field="businame"   query="true" queryMode="single"  width="145"></t:dgCol>
    <t:dgCol title="图片"  field="photopath"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="功能链接"  field="url"   query="true" queryMode="single"  width="325"></t:dgCol>
    <t:dgCol title="在用"  field="isactive"   query="true" queryMode="single" dictionary="isactive" width="60"></t:dgCol>
    <t:dgCol title="分组"  field="groupflag"    queryMode="single" dictionary="groupflag" width="120"></t:dgCol>
    <t:dgCol title="备注"  field="memo"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBBusionlineInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar width="603" height="367" title="录入" icon="icon-add" url="tBBusionlineInfoController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar width="602" height="407" title="编辑" icon="icon-edit" url="tBBusionlineInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBBusionlineInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar width="602" height="407" title="查看" icon="icon-search" url="tBBusionlineInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/shanyang/busionline/tBBusionlineInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBBusionlineInfoController.do?upload', "tBBusionlineInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBBusionlineInfoController.do?exportXls","tBBusionlineInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBBusionlineInfoController.do?exportXlsByT","tBBusionlineInfoList");
}

 </script>