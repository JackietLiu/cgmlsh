<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>销售工单</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="testRulesController.do?doUpdate">
		<input id="id" name="id" type="hidden" value="${testRulesPage.id }" />
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 销售人员:
				</label></td>
				<td class="value"><input id="name" name="name" type="text"
					maxlength="32" style="width: 150px" class="inputxt" ignore="ignore"
					value='${testRulesPage.name}' /> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">销售人员</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 订单金额:
				</label></td>
				<td class="value"><input id="money" name="money" type="text"
					maxlength="32" style="width: 150px" class="inputxt"
					datatype="/^(-?\d+)(\.\d+)?$/" ignore="ignore"
					value='${testRulesPage.money}' /> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">订单金额</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 产品名字:
				</label></td>
				<td class="value"><input id="product" name="product"
					type="text" maxlength="200" style="width: 150px" class="inputxt"
					ignore="ignore" value='${testRulesPage.product}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">产品名字</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 下单时间:
				</label></td>
				<td class="value"><input id="saleDate" name="saleDate"
					type="text" style="width: 150px" class="Wdate"
					onClick="WdatePicker()" ignore="ignore"
					value='<fmt:formatDate value='${testRulesPage.saleDate}' type="date" pattern="yyyy-MM-dd"/>' />
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">下单时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> dd: </label>
				</td>
				<td class="value"><input id="dda" name="dda" type="text"
					maxlength="32" style="width: 150px" class="inputxt" ignore="ignore"
					value='${testRulesPage.dda}' /> <span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">dd</label></td>
			</tr>

			<tr>
				<td align="right"><label class="Validform_label"> cc: </label>
				</td>
				<td class="value"><script type="text/javascript"
						charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
					<script type="text/javascript" charset="utf-8"
						src="plug-in/ueditor/ueditor.all.min.js"></script> <textarea
						name="eeee" id="eeee" style="width: 650px; height: 300px">${testRulesPage.eeee }</textarea>

					<script type="text/javascript">
							        var eeee_editor = UE.getEditor('eeee');
								    </script> <span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">cc</label></td>
			</tr>
		</table>
	</t:formvalid>
</body>