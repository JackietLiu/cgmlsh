<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>审核规则表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="tShRuleInfoBoostrapController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${tShRuleInfoBoostrap.id}"/>
	<div class="form-group">
		<label for="rulename" class="col-sm-3 control-label">规则名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="rulename" name="rulename" value='${tShRuleInfoBoostrap.rulename}' type="text" maxlength="40" class="form-control input-sm" placeholder="请输入规则名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">在用：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
               <t:dictSelect field="isactive" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="isactive"  hasLabel="false"  title="在用" defaultVal="${tShRuleInfoBoostrap.isactive}"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="sortindex" class="col-sm-3 control-label">排序：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="sortindex" name="sortindex" value='${tShRuleInfoBoostrap.sortindex}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入排序"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="parms" class="col-sm-3 control-label">参数：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="parms" name="parms" value='${tShRuleInfoBoostrap.parms}' type="text" maxlength="200" class="form-control input-sm" placeholder="请输入参数"  ignore="ignore" />
			</div>
		</div>
	</div>
					<div class="form-group">
						<label for="ruledesc" class="col-sm-3 control-label">规则描述：</label>
						<div class="col-sm-7">
			          <div class="input-group" style="width:100%">
						  	 	<textarea name="ruledesc" class="form-control input-sm" rows="6"  ignore="ignore" >${tShRuleInfoBoostrap.ruledesc}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">规则描述</label>
			          </div>
						</div>
					<div class="form-group">
						<label for="resultdesc" class="col-sm-3 control-label">结果描述：</label>
						<div class="col-sm-7">
			          <div class="input-group" style="width:100%">
						  	 	<textarea name="resultdesc" class="form-control input-sm" rows="6"  ignore="ignore" >${tShRuleInfoBoostrap.resultdesc}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">结果描述</label>
			          </div>
						</div>
					<div class="form-group">
						<label for="rulesql" class="col-sm-3 control-label">规则语句：</label>
						<div class="col-sm-7">
			          <div class="input-group" style="width:100%">
						  	 	<textarea name="rulesql" class="form-control input-sm" rows="6"  ignore="ignore" >${tShRuleInfoBoostrap.rulesql}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">规则语句</label>
			          </div>
						</div>
					<div class="form-group">
						<label for="memo" class="col-sm-3 control-label">备注：</label>
						<div class="col-sm-7">
			          <div class="input-group" style="width:100%">
						  	 	<textarea name="memo" class="form-control input-sm" rows="6"  ignore="ignore" >${tShRuleInfoBoostrap.memo}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
			          </div>
						</div>
					<div class="form-group">
						<label for="detailsql" class="col-sm-3 control-label">明细语句：</label>
						<div class="col-sm-7">
			          <div class="input-group" style="width:100%">
						  	 	<textarea name="detailsql" class="form-control input-sm" rows="6"  ignore="ignore" >${tShRuleInfoBoostrap.detailsql}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">明细语句</label>
			          </div>
						</div>
	</form>
	</div>
 </div>
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