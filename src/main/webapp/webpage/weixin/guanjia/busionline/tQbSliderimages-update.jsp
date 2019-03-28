<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>滚动图片信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,webuploader,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="tQbSliderimagesController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${tQbSliderimages.id}"/>
	<div class="form-group">
		<label for="groupname" class="col-sm-3 control-label">组名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="groupname" name="groupname" value='${tQbSliderimages.groupname}' type="text" maxlength="40" class="form-control input-sm" placeholder="请输入组名"  ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="imgurl" class="col-sm-3 control-label">地址：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:webUploader name="imgurl" outJs="true" auto="true" showImgDiv="filediv_imgurl" pathValues="${tQbSliderimages.imgurl}"></t:webUploader>
				<div class="form" id="filediv_imgurl"></div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="imgtitle" class="col-sm-3 control-label">标题：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="imgtitle" name="imgtitle" value='${tQbSliderimages.imgtitle}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入标题"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">在用：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
               <t:dictSelect field="isactive" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="isactive"  hasLabel="false"  title="在用" defaultVal="${tQbSliderimages.isactive}"></t:dictSelect>
			</div>
		</div>
	</div>
					<div class="form-group">
					<label for="memo" class="col-sm-3 control-label">备注：</label>
					<div class="col-sm-7">
					<div class="input-group" style="width:100%">
						  	 	<textarea name="memo" class="form-control input-sm" rows="6"  ignore="ignore" >${tQbSliderimages.memo}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
			          </div>
						</div>
					<div class="form-group">
					<label for="imgdesc" class="col-sm-3 control-label">说明：</label>
					<div class="col-sm-7">
					<div class="input-group" style="width:100%">
						  	 	<textarea name="imgdesc" class="form-control input-sm" rows="6"  ignore="ignore" >${tQbSliderimages.imgdesc}</textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">说明</label>
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