<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>在线文档一览</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,webuploader,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tBOnlineDocController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="docname" class="col-sm-3 control-label">文档名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="docname" name="docname" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入文档名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="docdesc" class="col-sm-3 control-label">文档描述：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="docdesc" name="docdesc" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入文档描述"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="docpathname" class="col-sm-3 control-label">文件名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:webUploader name="docpathname" outJs="true" auto="true" showImgDiv="filediv_docpathname"></t:webUploader>
				<div class="form" id="filediv_docpathname"></div>
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
		<label for="sortindex" class="col-sm-3 control-label">排序：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="sortindex" name="sortindex" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入排序"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="docclass" class="col-sm-3 control-label">类别：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="docclass" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="docclass"  hasLabel="false"  title="类别"></t:dictSelect>     
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