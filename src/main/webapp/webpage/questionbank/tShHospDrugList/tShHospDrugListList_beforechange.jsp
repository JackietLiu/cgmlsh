<!--thisisid: tShHospDrugListList_beforechange.jsp  -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>医院上传药品列表</title>
<meta name="viewport" content="width=device-width" />
<t:base type="bootstrap,bootstrap-table,layer"></t:base>
   <link rel="stylesheet" href="myplug-in/mui/css/mui.min.css">
   <script type="text/javascript" src="myplug-in/mui/js/mui.min.js"></script>
</head>
<body>
<t:datagrid name="tShHospDrugListList" component="bootstrap-table"  checkbox="true" sortName="createDate"  sortOrder="desc"  pagination="true" fitColumns="true" title="医院上传药品列表" actionUrl="tShHospDrugListController.do?datagrid" idField="id"  fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="药品名称"  field="commonname"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="药品规格"  field="gg"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="pcs"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="厂家"  field="enterprisename"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="剂型"  field="drugform"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="购进单价"  field="inprice"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入库数量"  field="innum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="转换比"  field="rationnum"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="医院ID"  field="hospid"  query="true"  queryMode="single"  dictionary="t_sh_hospital,id,hospnameshort"  width="120"></t:dgCol>
   <t:dgCol title="导入批号"  field="auditno"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tShHospDrugListController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tShHospDrugListController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tShHospDrugListController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tShHospDrugListController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tShHospDrugListController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>

  </t:datagrid>
  <script type="text/javascript">
	 $(document).ready(function(){
	 });

	//导入
	function ImportXls() {
       var url="tShHospDrugListController.do?func_beforeimport";
       alert(url);
       mui.ajax(url,{
          data:{
             category:''
          },
          dataType:'json',//服务器返回json格式数据
          type:'get',//HTTP请求类型
          success:function(data){
             //有记录  提示是否继续
             if(!data.success ){
                var btnArray = ['中止', '继续'];
                mui.confirm(data.msg, '确认', btnArray, function(e) {
                   if (e.index == 1) {
                      openuploadwin('Excel导入', 'tShHospDrugListController.do?upload', "tShHospDrugListList");
                   } else {
                      return ;
                   }
                })

             }

             if(data.success ){
                openuploadwin('Excel导入', 'tShHospDrugListController.do?upload', "tShHospDrugListList");
             }

          }
       });

	//	openuploadwin('Excel导入', 'tShHospDrugListController.do?upload', "tShHospDrugListList");
	}
	
	//导出
	function ExportXls() {
		JeecgExcelExport("tShHospDrugListController.do?exportXls","tShHospDrugListList");
	}
	
	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("tShHospDrugListController.do?exportXlsByT","tShHospDrugListList");
	}
	
	 </script>
</body>
</html>