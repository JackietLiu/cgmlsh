<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<t:base type="jquery,easyui,tools,DatePicker"></t:base>
 <script src = "webpage/wz/testloadop.js"></script>		
<script type="text/javascript">
	//编写自定义JS代码
</script>

<form id="confform" action="tbConfig2Controller.do?doUpdate" method="post">
	<input id="id" name="id" type="hidden" value="${json.id }" />
	<table style="width: 600px;" cellpadding="0" cellspacing="1"
		class="formtable">
		<tr>
			<td align="right"><label class="Validform_label"> 配置名称:
			</label></td>
			<td class="value"><input id="confname" name="confname" type="text"
				style="width: 150px; height: 25px;" class="inputxt" ignore="ignore"
				value="${json.confname}" /> 
				<span class="Validform_checktip"></span> <label
				class="Validform_label" style="display: none;">配置名称</label></td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr>
			<td align="right"><label class="Validform_label"> 代码: </label></td>
			<td class="value"><input id="code" name="code" type="text"
				style="width: 150px; height: 25px;" class="inputxt" ignore="ignore"
				value="${json.code}"  readonly="readonly"/> <span class="Validform_checktip"></span> <label
				class="Validform_label" style="display: none;">代码</label></td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr>
			<td align="right"><label class="Validform_label"> 备注: </label></td>
			<td class="value"><input id="memo" name="memo" type="text"
				style="width: 150px; height: 25px;" class="inputxt" ignore="ignore"
				value="${json.memo}" /> <span class="Validform_checktip"></span> <label
				class="Validform_label" style="display: none;">备注</label></td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr>
			<td align="right"><label class="Validform_label"> 默认值: </label>
			</td>
			<td class="value"><input id="defaultvalue" name="defaultvalue"
				type="text" style="width: 150px; height: 25px;" class="inputxt"
				ignore="ignore" value="${json.defaultvalue}" /> <span
				class="Validform_checktip"></span> <label class="Validform_label"
				style="display: none;">默认值</label></td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr>
			<td align="right"><label class="Validform_label"> 是否在用:
			</label></td>
			<td class="value"><t:dictSelect field="isactive" type="list"
					typeGroupCode="sf10" defaultVal="${json.isactive}" hasLabel="false"
					title="是否在用"></t:dictSelect> <span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否在用</label></td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr>
		<td align="center">
			</label></td>
			<td class="value">
				<button type=button class="btn btn-normal btn-xs" id="save"
					name="save">
					<i class="fa fa-save"></i> <span class="bigger-110 no-text-shadow">保存</span>
				</button> <!-- <input type="submit"  value="保存"/> -->
			</td>
		</tr>
	</table>
</form>

<script src="webpage/wz/tbconfig/tbConfig2List.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});

       
       var LODOP; //声明为全局变量       
	function myPrint() {		       
		CreatePrintPage();       
		LODOP.PRINT();		       
	};         
	function myPrintA() {		       
		CreatePrintPage();       
		LODOP.PRINTA();		       
	};  	       
	function myPreview() {		       
		CreatePrintPage();       
		LODOP.PREVIEW();		       
	};		       
	function mySetup() {		       
		CreatePrintPage();       
		LODOP.PRINT_SETUP();		       
	};	       
	function myDesign() {		       
		CreatePrintPage();       
		LODOP.PRINT_DESIGN();		       
	};	       
	function myBlankDesign() {       
		LODOP=getLodop();         
  		LODOP.PRINT_INIT("打印控件功能演示_Lodop功能_空白练习");		       
		LODOP.PRINT_DESIGN();		       
	};			       
	function CreatePrintPage() {       
		LODOP=getLodop();         
		LODOP.PRINT_INIT("表单打印测试");       
		LODOP.ADD_PRINT_RECT(10,55,360,220,0,1);         
		//LODOP.ADD_PRINT_TEXT(20,180,100,25,st);       
		LODOP.ADD_PRINT_HTM(10,55,"100%","100%",document.getElementById("confform").innerHTML);	         
 
	};       
	function myAddHtml() {       
		LODOP=getLodop();         
  		LODOP.PRINT_INIT("");		            
		LODOP.ADD_PRINT_HTM(10,55,"100%","100%",document.getElementById("confform").innerHTML);	       
	};	       
$("#save").click(function(){
	
	 $.ajax({
		 cache : true,
		 type : "post",
		 url : "tbConfig2Controller.do?doUpdate",
		 data : $('#confform').serialize(),		 
		 dataType : "json",
		 success : function(ret){
			 tip(ret.msg);
			 CreatePrintPage();
			 LODOP.PRINT_DESIGN();	
		 }
	 });
});
/* 	//导入
	function ImportXls() {
		openuploadwin('Excel导入', 'tbConfig2Controller.do?upload',
				"tbConfig2List");
	}

	//导出
	function ExportXls() {
		JeecgExcelExport("tbConfig2Controller.do?exportXls", "tbConfig2List");
	}

	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("tbConfig2Controller.do?exportXlsByT", "tbConfig2List");
	} */
</script>