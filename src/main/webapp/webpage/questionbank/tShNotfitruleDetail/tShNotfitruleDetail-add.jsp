<!--thisisid: tShNotfitruleDetail-add -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>规则清单明细</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="tShNotfitruleDetailController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="hospid" class="col-sm-3 control-label">医院：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="hospid" type="list" extendJson="{class:'form-control input-sm'}"   dictTable="t_sh_hospital" dictField="id" dictText="hospname"  hasLabel="false"  title="医院"></t:dictSelect>     
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="auditno" class="col-sm-3 control-label">批号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="auditno" name="auditno" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入批号"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="ruleid" class="col-sm-3 control-label">规则：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="ruleid" type="list" extendJson="{class:'form-control input-sm'}"   dictTable="t_sh_rule_info" dictField="id" dictText="rulename"  hasLabel="false"  title="规则"></t:dictSelect>     
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="drugform" class="col-sm-3 control-label">剂型：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="drugform" name="drugform" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入剂型"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="gg" class="col-sm-3 control-label">药品规格：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="gg" name="gg" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入药品规格"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="commonname" class="col-sm-3 control-label">药品名称：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="commonname" name="commonname" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入药品名称"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="enterprisename" class="col-sm-3 control-label">厂家：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="enterprisename" name="enterprisename" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入厂家"  ignore="ignore" />
				</div>
			</div>
		</div>
					<div class="form-group">
						<label for="thedesc" class="col-sm-3 control-label">不符合说明：</label>
						<div class="col-sm-7">
				    <div class="input-group" style="width:100%">
						  	 	<textarea name="thedesc" value = "${tShNotfitruleDetail.thedesc}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">不符合说明</label>
			          </div>
						</div>
					<div class="form-group">
						<label for="memo" class="col-sm-3 control-label">备注：</label>
						<div class="col-sm-7">
				    <div class="input-group" style="width:100%">
						  	 	<textarea name="memo" value = "${tShNotfitruleDetail.memo}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
			          </div>
						</div>
					<div class="form-group">
						<label for="detailsql" class="col-sm-3 control-label">查询语句：</label>
						<div class="col-sm-7">
				    <div class="input-group" style="width:100%">
						  	 	<textarea name="detailsql" value = "${tShNotfitruleDetail.detailsql}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">查询语句</label>
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