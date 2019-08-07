<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医疗联合体信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tBaMedicalConsortiumController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="thename" class="col-sm-3 control-label">机构名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="thename" name="thename" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入机构名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	 <div class="form-group">
		 <label for="headhospid" class="col-sm-3 control-label">牵头单位：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <%--<input id="headhospid" name="headhospid" type="text" maxlength="36" class="form-control input-sm" placeholder="请输入牵头单位"  ignore="ignore" />--%>
				 <t:dictSelect field="headhospid" type="list" extendJson="{class:'form-control input-sm'}"   dictTable="t_sh_hospital" dictField="id" dictText="hospname" dictCondition="where hosplevel='2' or hosplevel='3'" hasLabel="false"  title="医院（牵头单位）"></t:dictSelect>
			 </div>
		 </div>
	 </div>
	<div class="form-group">
		<label for="builddate" class="col-sm-3 control-label">组建日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="builddate" name="builddate" type="text" maxlength="12" class="form-control input-sm" placeholder="请输入组建日期"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="pid" class="col-sm-3 control-label">上级机构：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="pid" name="pid" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入上级机构"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="orglevel" class="col-sm-3 control-label">机构类型：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="orglevel" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="orglevel"  hasLabel="false"  title="机构类型"></t:dictSelect>     
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="medicaltype" class="col-sm-3 control-label">联合方式：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="medicaltype" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="medicaltype"  hasLabel="false"  title="联合方式"></t:dictSelect>     
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">在用：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="isactive" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="isactive"  hasLabel="false"  title="在用"></t:dictSelect>     
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="memo" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<textarea id="memo" name="memo" class="form-control" placeholder="请输入备注" rows="4"></textarea>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
		
		//单选框/多选框初始化
		$('.i-checks').iCheck({
			labelHover : false,
			cursor : true,
			checkboxClass : 'icheckbox_square-green',
			radioClass : 'iradio_square-green',
			increaseArea : '20%'
		});
		
		//表单提交
		$("#formobj").Validform({
			tiptype:function(msg,o,cssctl){
				if(o.type==3){
					validationMessage(o.obj,msg);
				}else{
					removeMessage(o.obj);
				}
			},
			btnSubmit : "#btn_sub",
			btnReset : "#btn_reset",
			ajaxPost : true,
			beforeSubmit : function(curform) {
			},
			usePlugin : {
				passwordstrength : {
					minLen : 6,
					maxLen : 18,
					trigger : function(obj, error) {
						if (error) {
							obj.parent().next().find(".Validform_checktip").show();
							obj.find(".passwordStrength").hide();
						} else {
							$(".passwordStrength").show();
							obj.parent().next().find(".Validform_checktip").hide();
						}
					}
				}
			},
			callback : function(data) {
				var win = frameElement.api.opener;
				if (data.success == true) {
					frameElement.api.close();
				    win.reloadTable();
				    win.tip(data.msg);
				} else {
				    if (data.responseText == '' || data.responseText == undefined) {
				        $.messager.alert('错误', data.msg);
				        $.Hidemsg();
				    } else {
				        try {
				            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
				            $.messager.alert('错误', emsg);
				            $.Hidemsg();
				        } catch (ex) {
				            $.messager.alert('错误', data.responseText + "");
				            $.Hidemsg();
				        }
				    }
				    return false;
				}
			}
		});
	});
	
</script>
</body>
</html>