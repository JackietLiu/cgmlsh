<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<!DOCTYPE html>
<html>
 <head>
  <title>系统配置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <form formid="formobj" dialog="true" usePlugin="password" layout="table" action="tbConfig2Controller.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tbConfig2Page.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							配置名称:
						</label>
					</td>
						<td class="value">
					     	 <input id="confname" name="confname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配置名称</label>
						</td>
				
					<td align="right">
						<label class="Validform_label">
							代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="code" name="code" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代码</label>
						</td>
					</tr>
				<tr>
					
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							默认值:
						</label>
					</td>
					<td class="value">
					     	 <input id="defaultvalue" name="defaultvalue" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">默认值</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							是否在用:
						</label>
					</td>
					<td class="value"><t:dictSelect field="isactive" type="list"
					typeGroupCode="sf10" defaultVal="${json.isactive}" hasLabel="false"
					title="是否在用"></t:dictSelect> <span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否在用</label></td>
					<!-- <td align="right">
						<label class="Validform_label">
							管理级别:
						</label>
					</td>
					<td class="value">
					     	 <input id="managerlevel" name="managerlevel" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理级别</label>
						</td> -->
					</tr>
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							分组代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="groupflag" name="groupflag" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分组代码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							分组名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="groupflagname" name="groupflagname" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分组名称</label>
						</td>
					</tr> -->
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							类别:
						</label>
					</td>
					<td class="value">
					     	 <input id="category" name="category" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类别</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							值类别:
						</label>
					</td>
					<td class="value">
					     	 <input id="valuetype" name="valuetype" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">值类别</label>
						</td>
					</tr> -->
<!-- 				<tr>
					<td align="right">
						<label class="Validform_label">
							值范围:
						</label>
					</td>
					<td class="value">
					     	 <input id="valuescope" name="valuescope" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">值范围</label>
						</td>
					
					</tr> -->
			<!-- 	<tr>
					<td align="right">
						<label class="Validform_label">
							停止日期:
						</label>
					</td>
					<td class="value">
							   <input id="stopdate" name="stopdate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">停止日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							排序:
						</label>
					</td>
					<td class="value">
					     	 <input id="sortindex" name="sortindex" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序</label>
						</td>
					</tr> -->
				<tr>
					<!-- <td align="right">
						<label class="Validform_label">
							是否同步本地:
						</label>
					</td>
					<td class="value">
					     	 <input id="issynclocal" name="issynclocal" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否同步本地</label>
						</td> -->
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
				
			</table>
		</form>
 </body>
  <script src = "webpage/wz/tbconfig/tbConfig2.js"></script>		
