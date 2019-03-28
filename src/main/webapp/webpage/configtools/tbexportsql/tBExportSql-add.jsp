<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<!DOCTYPE html>
<html>
 <head>
  <title>导出数据</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBExportSqlController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tBExportSqlPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							保存文件名:
						</label>
					</td>
					<td class="value">
					     	 <input id="thefile" name="thefile" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保存文件名</label>
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
							用户名:
						</label>
					</td>
					<td class="value">
					     	 <input id="theusername" name="theusername" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							密码:
						</label>
					</td>
					<td class="value">
					     	 <input id="thepassword" name="thepassword" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">密码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							数据库类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="thedbtype" type="list"  typeGroupCode="dbtype"  defaultVal="${tBExportSqlPage.thedbtype}" hasLabel="false"  title="数据库类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数据库类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							插入的表名:
						</label>
					</td>
					<td class="value">
					     	 <input id="thetablename" name="thetablename" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">插入的表名</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							脚本:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="sqlscript" name="sqlscript"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">脚本</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							连接字符串:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="connstr" name="connstr"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">连接字符串</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/configtools/tbexportsql/tBExportSql.js"></script>		
