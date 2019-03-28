<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<%
mypartial.ResourceUtil_Expand.consolePrintName(this.getClass(),"") ;
%>

<!DOCTYPE html>
<html>
 <head>
  <title>系统配置详情</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tbConfigDetailController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tbConfigDetailPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							配置:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="confid" type="list"  dictTable="tb_config" dictField="id" dictText="confname"  defaultVal="${tbConfigDetailPage.confid}" hasLabel="false"  title="配置" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">配置</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="deptid" type="list"  dictTable="t_s_depart" dictField="id" dictText="departname"  defaultVal="${tbConfigDetailPage.deptid}" hasLabel="false"  title="部门" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部门</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="userid" type="list"  dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${tbConfigDetailPage.userid}" hasLabel="false"  title="用户" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							角色:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="roleid" type="list"  dictTable="t_s_role" dictField="id" dictText="rolename"  defaultVal="${tbConfigDetailPage.roleid}" hasLabel="false"  title="角色" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">角色</label>
						</td>
				</tr>
				<tr>
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
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							代码详细:
						</label>
					</td>
					<td class="value">
					     	 <input id="codedetail" name="codedetail" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代码详细</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							取值:
						</label>
					</td>
					<td class="value">
					     	 <input id="thevalue" name="thevalue" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取值</label>
						</td>
				</tr> -->
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否在用:
						</label>
					</td>
					<td class="value">
					     	 <input id="isactive" name="isactive" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否在用</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							说明:
						</label>
					</td>
					<td class="value">
					     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">说明</label>
						</td>
				</tr>
				<%-- <tr>
					<td align="right">
						<label class="Validform_label">
							公司id:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="entid" type="list"  typeGroupCode=""  defaultVal="${tbConfigDetailPage.entid}" hasLabel="false"  title="公司id" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司id</label>
						</td>
				</tr> --%>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/wz/tbconfigdetail/tbConfigDetail.js"></script>		
