<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<!DOCTYPE html>
<html>
 <head>
  <title>同步日志信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBSyncLogController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tBSyncLogPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							同步表名:
						</label>
					</td>
					<td class="value">
					     	 <input id="synctablename" name="synctablename" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">同步表名</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							同步机器:
						</label>
					</td>
					<td class="value">
					     	 <input id="syncip" name="syncip" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">同步机器</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							同步描述:
						</label>
					</td>
					<td class="value" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="syncdesc" name="syncdesc"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">同步描述</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/configtools/tbsynclog/tBSyncLog.js"></script>		
