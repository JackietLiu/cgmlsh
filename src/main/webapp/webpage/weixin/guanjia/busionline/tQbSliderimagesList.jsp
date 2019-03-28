<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tQbSliderimagesList" checkbox="false" pagination="true" fitColumns="true" title="滚动图片信息" actionUrl="tQbSliderimagesController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="组名"  field="groupname"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="imgurl"  queryMode="single"  formatterjs="btListFileFormatter" width="120"></t:dgCol>
   <t:dgCol title="标题"  field="imgtitle"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="说明"  field="imgdesc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="在用"  field="isactive"  queryMode="single"  dictionary="isactive"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tQbSliderimagesController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tQbSliderimagesController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tQbSliderimagesController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tQbSliderimagesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tQbSliderimagesController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tQbSliderimagesController.do?upload', "tQbSliderimagesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tQbSliderimagesController.do?exportXls","tQbSliderimagesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tQbSliderimagesController.do?exportXlsByT","tQbSliderimagesList");
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
