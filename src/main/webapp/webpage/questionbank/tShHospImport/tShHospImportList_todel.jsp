<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" href="myplug-in/mui/css/mui.min.css">
<script type="text/javascript" src="myplug-in/mui/js/mui.min.js"></script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tShHospImportList" checkbox="false" pagination="true" fitColumns="false" title="医院上传信息" actionUrl="tShHospImportController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="医院名称"  dictionary="t_sh_hospital,id,hospnameshort" query="true" field="hospid"  queryMode="single"   width="120"></t:dgCol>
   <t:dgCol title="上传批号"  field="auditno" dictionary="thestatus"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="thestatus" dictionary="" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="年份"  field="year"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="月份"  field="month"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="文件名"  field="filename"  queryMode="single"  width="120"></t:dgCol>
      <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
      <t:dgDelOpt title="删除" url="tShHospImportController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
       <t:dgToolBar title="录入" icon="icon-add" url="tShHospImportController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
       <t:dgToolBar title="编辑" icon="icon-edit" url="tShHospImportController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>--%>
  <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="tShHospImportController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tShHospImportController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
 <%--  <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
 <%--  <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   <t:dgToolBar title="审核" icon="icon-putout" funname="func_audit"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   //zczadd begin   modify on  2019/2/28 13:59
 function func_audit(){
  var row = $('#tShHospImportList').datagrid('getSelected');
  if (!row) {
   $.messager.alert('提信息示', "对不起，请先选择一条记录，才可以审核该医院的导入信息！","info");
   return;
  }
   var hospid=row.hospid;
  var auditno=row.auditno;
  alert(auditno);
  var url="tShHospImportController.do?func_audit&hospid=" +hospid +"&auditno=" +auditno;
  mui.ajax(url,{
   data:{
    category:''
   },
   dataType:'json',//服务器返回json格式数据
   type:'get',//HTTP请求类型
   success:function(data){
    mui.toast(data.msg);
   }
  });

 }


   //zczadd end modify  on  2019/2/28 13:59
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tShHospImportController.do?upload', "tShHospImportList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tShHospImportController.do?exportXls","tShHospImportList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tShHospImportController.do?exportXlsByT","tShHospImportList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

</script>
