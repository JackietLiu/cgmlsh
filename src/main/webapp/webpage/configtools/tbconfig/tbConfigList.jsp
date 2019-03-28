<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tbConfigList" checkbox="true" pagination="true" fitColumns="true" title="系统配置信息" actionUrl="tbConfigController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="代码"  field="code"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="配置名称"  field="confname"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="配置描述"  field="confdescribe"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="默认值"  field="defaultvalue"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="管理级别"  field="managerlevel"  queryMode="group"  dictionary="tb_config where  groupflag='Config_Priority' and isactive='1',code,confname"  width="120"></t:dgCol>
   <t:dgCol title="分组代码"  field="groupflag"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="分组名称"  field="groupflagname"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类别"  field="category"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="值类别"  field="valuetype"  queryMode="group"  dictionary="valuetype"  width="120"></t:dgCol>
   <t:dgCol title="值范围"  field="valuescope"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否在用"  field="isactive"  queryMode="group"  dictionary="isactive"  width="120"></t:dgCol>
   <t:dgCol title="停止日期"  field="stopdate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="排序"  field="sortindex"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="是否同步本地"  field="issynclocal"  queryMode="group"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tbConfigController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tbConfigController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tbConfigController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tbConfigController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tbConfigController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/yiliao/tbconfig/tbConfigList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tbConfigController.do?upload', "tbConfigList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tbConfigController.do?exportXls","tbConfigList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tbConfigController.do?exportXlsByT","tbConfigList");
}

 </script>