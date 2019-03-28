<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>
 
<!DOCTYPE html>
<html>
 <head>
  <title>功能使用频率</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tSFunctionClickcountController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tSFunctionClickcountPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								功能ID:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="functionid" type="list"  dictTable="t_s_function" dictField="id" dictText="functionname"   defaultVal="${tSFunctionClickcountPage.functionid}" hasLabel="false"  title="功能ID" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">功能ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户ID:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="userid" type="list"  dictTable="t_s_base_user" dictField="id" dictText="username"   defaultVal="${tSFunctionClickcountPage.userid}" hasLabel="false"  title="用户ID" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								使用次数:
							</label>
						</td>
						<td class="value">
						    <input id="clickcount" name="clickcount" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${tSFunctionClickcountPage.clickcount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用次数</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/configtools/clickcount/tSFunctionClickcount.js"></script>		
