<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>审核规则信息</title>
<meta name="viewport" content="width=device-width" />
<t:base type="bootstrap,bootstrap-table,layer"></t:base>
</head>
<body>
<t:datagrid name="tShRuleInfoList" component="bootstrap-table"  checkbox="true" sortName="createDate"  sortOrder="desc"  pagination="true" fitColumns="true" title="审核规则信息" actionUrl="tShRuleInfoController.do?datagrid" idField="id"  fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="规则名称"  field="rulename"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="规则描述"  field="ruledesc"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结果描述"  field="resultdesc"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="规则语句"  field="rulesql"  queryMode="group"  dictionary="t_sh_rule_info_proc,procmysql,procname"  width="120"></t:dgCol>
   <t:dgCol title="在用"  field="isactive"  queryMode="group"  dictionary="isactive"  width="120"></t:dgCol>
   <t:dgCol title="排序"  field="sortindex"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="明细语句"  field="detailsql"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="参数"  field="parms"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="不合规提示"  field="allresultdeschaserror"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合规提示"  field="allresultdescnoerror"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="项目分值"  field="itemscore"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="明细分值"  field="detailscore"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tShRuleInfoController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tShRuleInfoController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tShRuleInfoController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tShRuleInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tShRuleInfoController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  <script type="text/javascript">
	 $(document).ready(function(){
	 });
	 
	   
	 
	//导入
	function ImportXls() {
		openuploadwin('Excel导入', 'tShRuleInfoController.do?upload', "tShRuleInfoList");
	}
	
	//导出
	function ExportXls() {
		JeecgExcelExport("tShRuleInfoController.do?exportXls","tShRuleInfoList");
	}
	
	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("tShRuleInfoController.do?exportXlsByT","tShRuleInfoList");
	}
	
	 </script>
</body>
</html>