<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tbConfigDetailList" checkbox="true" pagination="true" fitColumns="true" title="系统配置详情" actionUrl="tbConfigDetailController.do?datagrid&confid=${detailid}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="配置"  field="confid"    dictionary="tb_config,id,confname"  width="120"></t:dgCol>
   <t:dgCol title="部门"  field="deptid"    dictionary="t_s_depart,id,departname"  width="120" > </t:dgCol>
   <t:dgCol title="用户"  field="userid"    dictionary="t_s_base_user,id,realname"  width="120"></t:dgCol>
   <t:dgCol title="角色"  field="roleid"   dictionary="t_s_role,id,rolename"  width="120"></t:dgCol>
   <t:dgCol title="代码"  field="code"    width="120"></t:dgCol>
<%--    <t:dgCol title="代码详细"  field="codedetail"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="取值"  field="thevalue"  queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="是否在用"  field="isactive"   dictionary="isactive"  width="120"></t:dgCol>
   <t:dgCol title="说明"  field="memo"   width="120"></t:dgCol>
<%--    <t:dgCol title="公司id"  field="entid"  queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tbConfigDetailController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tbConfigDetailController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tbConfigDetailController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tbConfigDetailController.do?goUpdate" funname="update"></t:dgToolBar>
    <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tbConfigDetailController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/wz/tbconfigdetail/tbConfigDetailList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tbConfigDetailController.do?upload', "tbConfigDetailList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tbConfigDetailController.do?exportXls","tbConfigDetailList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tbConfigDetailController.do?exportXlsByT","tbConfigDetailList");
}

 </script>