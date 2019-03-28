<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tShHospDrugListHistoryList" checkbox="true" pagination="true" fitColumns="true" title="医院药品历史记录" actionUrl="tShHospDrugListHistoryController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="药品名称"  field="commonname"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="药品规格"  field="gg"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="pcs"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="产地"  field="enterprisename"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="剂型"  field="drugform"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="购进单价"  field="inprice"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入库数量"  field="innum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="购进金额"  field="inje"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="转换比"  field="rationnum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="医院ID"  field="hospid"  queryMode="group"  dictionary="t_sh_hospital,id,hospname"  width="120"></t:dgCol>
   <t:dgCol title="导入批号"  field="auditno"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="原ID"  field="oldid"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tShHospDrugListHistoryController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tShHospDrugListHistoryController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tShHospDrugListHistoryController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tShHospDrugListHistoryController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tShHospDrugListHistoryController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'tShHospDrugListHistoryController.do?upload', "tShHospDrugListHistoryList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tShHospDrugListHistoryController.do?exportXls","tShHospDrugListHistoryList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tShHospDrugListHistoryController.do?exportXlsByT","tShHospDrugListHistoryList");
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
