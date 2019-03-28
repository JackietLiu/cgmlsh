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
  <style type="text/css">
    .hide{
	display:none;  
  }
  </style>
  <script type="text/javascript">
  //编写自定义JS代码
  window.onload = function(){
	  var yn = $("#yn").val();
	  if(yn == "Y"){
		  $("#new").addClass("hide");
		  $("#formobj").removeClass("hide");
	  }else{
		  $("#formobj").addClass("hide");
		  $("#new").removeClass("hide");		  
	  }
  }

  </script>
 </head>
 <body>
  <c:if test="${isTbConfigDetail == 'N'}">
  <c:if test="${tbConfigDetail.managerlevel !='Priority_System'  && tbConfigDetail.managerlevel =='Priority_Ent'}">
               
                <button type=button class="btn btn-normal btn-xs" id="new" name="new">
					<i class="fa fa-pencil"></i> <span class="bigger-110 no-text-shadow">新建</span>
				</button>
				
				
				  <form id="formobj" action="tbConfigDetailController.do?doAdd"  method="post"  class="hide">
					<input id="confid" name="confid" type="hidden" value="${tbConfigDetail.id }"/>
					<input id="yn" name="yn" type="hidden" value="${isTbConfigDetail}"/>
					<%-- <input id="confid" name="confid" type="hidden" value="${tbConfigDetail.confid }"/> --%>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">					
				<tr>
					<td align="right">
						<label class="Validform_label">
							代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="code" name="code" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  readonly="readonly" value="${tbConfigDetail.managerlevel}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							取值:
						</label>
					</td>
					<td class="value">
					     	 <input id="thevalue" name="thevalue" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${tbConfigDetail.defaultvalue}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取值</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${tbConfigDetail.memo}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否在用:
						</label>
					</td>
					<td class="value"><t:dictSelect field="isactive" type="list" typeGroupCode="sf10" defaultVal="${tbConfigDetail.isactive}" hasLabel="false" title="是否在用"></t:dictSelect>
                     <span class="Validform_checktip"></span>
			    	 <label class="Validform_label" style="display: none;">是否在用</label>
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
  </c:if>

     <c:if test="${tbConfigDetail.managerlevel =='Priority_System' ||tbConfigDetail.managerlevel =='Priority_User' ||tbConfigDetail.managerlevel =='Priority_Role' }">
     
     <font style="font-size: 20px !important;color: red;">该配置项不支持部门配置</font>
    </c:if>
  </c:if>
   <c:if test="${isTbConfigDetail == 'Y'}">
   	 <c:if test="${tbConfigDetail.code !='Priority_System'  && tbConfigDetail.code =='Priority_Ent'}">
				  <form id="formobj1" action="tbConfigDetailController.do?doUpdate"  method="post">
					<input id="id" name="id" type="hidden" value="${tbConfigDetail.id }"/>
					<input id="yn" name="yn" type="hidden" value="${isTbConfigDetail}"/>
					<%-- <input id="confid" name="confid" type="hidden" value="${tbConfigDetail.confid }"/> --%>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">					
				<tr>
					<td align="right">
						<label class="Validform_label">
							代码:
						</label>
					</td>
					<td class="value">
					     	 <input id="code" name="code" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  readonly="readonly" value="${tbConfigDetail.code}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代码</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							取值:
						</label>
					</td>
					<td class="value">
					     	 <input id="thevalue" name="thevalue" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${tbConfigDetail.thevalue}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取值</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="memo" name="memo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value="${tbConfigDetail.memo}"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否在用:
						</label>
					</td>
					<td class="value"><t:dictSelect field="isactive" type="list" typeGroupCode="sf10" defaultVal="${tbConfigDetail.isactive}" hasLabel="false" title="是否在用"></t:dictSelect>
                     <span class="Validform_checktip"></span>
			    	 <label class="Validform_label" style="display: none;">是否在用</label>
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
				
				<tr>
		<td align="center">
			</label></td>
			<td class="value">
				<button type=button class="btn btn-normal btn-xs" id="save1"
					name="save">
					<i class="fa fa-save"></i> <span class="bigger-110 no-text-shadow">保存</span>
				</button> <!-- <input type="submit"  value="保存"/> -->
			</td>
		</tr>
			</table>
		</form>	
		
		</c:if>		
		<c:if test="${tbConfigDetail.code =='Priority_System' ||tbConfigDetail.code =='Priority_User' ||tbConfigDetail.code =='Priority_Role' }">

     <font style="font-size: 20px !important;color: red;">该配置项不支持部门配置</font>
    </c:if>    
   </c:if>
 </body>
  <script src = "webpage/wz/tbconfigdetail/tbConfigDetail.js"></script>	
  <script type="text/javascript">
  
  $("#save").click(function(){
		 /* $("#formobj").submit(); */
		 $.ajax({
			 cache : true,
			 type : "post",
			 url : "tbConfigDetailController.do?doAdd",
			 data : $('#formobj').serialize(),		 
			 dataType : "json",
			 success : function(ret){
				 tip(ret.msg);
			 }
		 });
	});
$("#save1").click(function(){
		 /* $("#formobj").submit(); */
		 $.ajax({
			 cache : true,
			 type : "post",
			 url : "tbConfigDetailController.do?doUpdate",
			 data : $('#formobj1').serialize(),		 
			 dataType : "json",
			 success : function(ret){
				 tip(ret.msg);
			 }
		 });
	});
  $("#new").click(function(){
		 $("#formobj").removeClass("hide");
		 $("#new").addClass("hide");
	});
  </script>	
