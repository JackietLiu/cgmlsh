<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!--ZCZSN 20180927105857 -->
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="weixinSubscribeLocalList" checkbox="true" pagination="true" fitColumns="false"  actionUrl="weixinSubscribeLocalController.do?datagrid" idField="id" fit="true" queryMode="group">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="呢称"  field="nickname"   query="true" queryMode="single"  width="120"></t:dgCol>
    
    <t:dgCol title="微信性别"  field="sex"    queryMode="group"  width="100" dictionary="sex"></t:dgCol>
    <t:dgCol title="实名性别"  field="sex1"    queryMode="group"  width="100" dictionary="sex"></t:dgCol>
    <t:dgCol title="城市"  field="city"    queryMode="group"  width="40"></t:dgCol>
    <t:dgCol title="省份"  field="province"    queryMode="group"  width="40"></t:dgCol>
    <t:dgCol title="国籍"  field="country"    queryMode="group"  width="60"></t:dgCol>
    <t:dgCol title="图像"  field="headimgurl"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="关注时间"  field="subscribetime"   query="true" queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="是否关注"  field="subscribe"    queryMode="group"  width="60" dictionary="sf01"></t:dgCol>
    <t:dgCol title="语言"  field="language"    queryMode="group"  width="120"></t:dgCol>
  <%--   <t:dgCol title="unionid"  field="unionid"    queryMode="group"  width="120"></t:dgCol> --%>
    <t:dgCol title="备注"  field="remark"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="分组"  field="groupid"    queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="真实姓名"  field="realname"   query="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="身份证号"  field="idcard"   query="false" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="认证图片"  field="photopath"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="手机号"  field="mobile"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="memo"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="审核日期"  field="approvedate" formatter="yyyy-MM-dd"   queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="审核人"  field="approvename"    queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="审核状态"  field="approvestatus"   query="true" queryMode="single" dictionary="approvestatus" width="120"></t:dgCol>
  
    <t:dgCol title="其他户籍"  field="otherhuji"    queryMode="single"   width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="weixinSubscribeLocalController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
  <%--   <t:dgToolBar title="录入" icon="icon-add" url="weixinSubscribeLocalController.do?goAdd" funname="add"></t:dgToolBar> --%>
    <t:dgToolBar title="同步" icon="icon-reload" url="weixinSubscribeLocalController.do?goReload" funname="goReload()"></t:dgToolBar>
   <t:dgToolBar width="661" height="451" title="编辑" icon="icon-edit" url="weixinSubscribeLocalController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="weixinSubscribeLocalController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar width="661" height="451" title="查看" icon="icon-search" url="weixinSubscribeLocalController.do?goUpdate" funname="detail"></t:dgToolBar>
 <%--   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="分组" icon="icon-search" url="weixinSubscribeLocalController.do?goGroup" funname="goGroup()"></t:dgToolBar>
  <%--  <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/weixin/guanjia/subscribelocal/weixinSubscribeLocalList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
 function goReload(){	 
		$.ajax({
			url:"weixinSubscribeLocalController.do?goReload",
			type:"GET",
			dataType:"JSON",
			success:function(data){				
				if(data.success){
					tip(data.msg);
				}
			}
		});
	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'weixinSubscribeLocalController.do?upload', "weixinSubscribeLocalList");
}

//导出
function ExportXls() {
	JeecgExcelExport("weixinSubscribeLocalController.do?exportXls","weixinSubscribeLocalList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("weixinSubscribeLocalController.do?exportXlsByT","weixinSubscribeLocalList");
}

 </script>