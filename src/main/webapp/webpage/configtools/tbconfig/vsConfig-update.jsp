<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>vs_config</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="vsConfigController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${vsConfigPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								entid:
							</label>
						</td>
						<td class="value">
						     	 <input id="entid" name="entid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.entid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">entid</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								deptid:
							</label>
						</td>
						<td class="value">
						     	 <input id="deptid" name="deptid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.deptid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">deptid</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								userid:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${vsConfigPage.userid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userid</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								userid2:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid2" name="userid2" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.userid2}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userid2</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								roleid:
							</label>
						</td>
						<td class="value">
						     	 <input id="roleid" name="roleid" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.roleid}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">roleid</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								managerlevel:
							</label>
						</td>
						<td class="value">
						     	 <input id="managerlevel" name="managerlevel" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.managerlevel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">managerlevel</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								code:
							</label>
						</td>
						<td class="value">
						     	 <input id="code" name="code" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.code}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">code</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								confname:
							</label>
						</td>
						<td class="value">
						     	 <input id="confname" name="confname" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.confname}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">confname</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								thevalue:
							</label>
						</td>
						<td class="value">
						     	 <input id="thevalue" name="thevalue" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.thevalue}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">thevalue</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								groupflag:
							</label>
						</td>
						<td class="value">
						     	 <input id="groupflag" name="groupflag" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.groupflag}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">groupflag</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								codedetail:
							</label>
						</td>
						<td class="value">
						     	 <input id="codedetail" name="codedetail" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.codedetail}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">codedetail</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								category:
							</label>
						</td>
						<td class="value">
						     	 <input id="category" name="category" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.category}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">category</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								configlevel:
							</label>
						</td>
						<td class="value">
						     	 <input id="configlevel" name="configlevel" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${vsConfigPage.configlevel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">configlevel</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/yiliao/tbconfig/vsConfig.js"></script>		
