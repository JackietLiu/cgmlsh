<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>一致性评价清单</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tShDrugValueInfoController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="commonname" class="col-sm-3 control-label">药品名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="commonname" name="commonname" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入药品名称"  ignore="ignore" />
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
		<label for="gg" class="col-sm-3 control-label">规格：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="gg" name="gg" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入规格"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="enterprisename" class="col-sm-3 control-label">生产厂家：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="enterprisename" name="enterprisename" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入生产厂家"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="registerno" class="col-sm-3 control-label">批准文号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="registerno" name="registerno" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入批准文号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="buyno" class="col-sm-3 control-label">产品编号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="buyno" name="buyno" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入产品编号"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="ntresult" class="col-sm-3 control-label">南通入围结果：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="ntresult" name="ntresult" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入南通入围结果"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="jsresult" class="col-sm-3 control-label">江苏入围结果：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="jsresult" name="jsresult" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入江苏入围结果"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="isbasedrug" class="col-sm-3 control-label">国家基药：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="isbasedrug" name="isbasedrug" type="text" maxlength="20" class="form-control input-sm" placeholder="请输入国家基药"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="inprice" class="col-sm-3 control-label">购进单价：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="inprice" name="inprice" type="text" maxlength="10" class="form-control input-sm" placeholder="请输入购进单价"  ignore="ignore" />
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