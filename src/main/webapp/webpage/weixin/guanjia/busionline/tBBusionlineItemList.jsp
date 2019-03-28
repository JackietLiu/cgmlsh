<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN 20180926200729 -->
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBBusionlineItemList" checkbox="false" pagination="true" fitColumns="false"   actionUrl="tBBusionlineItemController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="排序"  field="sortindex"    queryMode="single"  width="60"></t:dgCol>
    <t:dgCol title="政务ID"  field="busionlineid"    queryMode="single" dictionary="t_b_busionline_info,id,businameshort"  width="120"></t:dgCol>
    <t:dgCol title="图标"  field="photopath"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="项目名称"  field="itemname"   query="true" queryMode="single"  width="220"></t:dgCol>
    <t:dgCol title="功能链接"  field="url"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="memo"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="在用"  field="isactive"    queryMode="single" dictionary="isactive" width="60"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBBusionlineItemController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tBBusionlineItemController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBBusionlineItemController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBBusionlineItemController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tBBusionlineItemController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/shanyang/busionline/tBBusionlineItemList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });  
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBBusionlineItemController.do?upload', "tBBusionlineItemList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBBusionlineItemController.do?exportXls","tBBusionlineItemList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBBusionlineItemController.do?exportXlsByT","tBBusionlineItemList");
}

 </script>