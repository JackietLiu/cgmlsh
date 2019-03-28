<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <div><font style="font-size: 20px !important;color: red;">请选择子节点以查看</font></div>
 <script src = "webpage/wz/tbconfig/tbConfig2List.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tbConfig2Controller.do?upload', "tbConfig2List");
}

//导出
function ExportXls() {
	JeecgExcelExport("tbConfig2Controller.do?exportXls","tbConfig2List");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tbConfig2Controller.do?exportXlsByT","tbConfig2List");
}

 </script>