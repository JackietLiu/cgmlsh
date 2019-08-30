<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>提交驳回记录</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tShHospImportBackController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="userid" class="col-sm-3 control-label">驳回人：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="userid" name="userid" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入驳回人"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="backdate" class="col-sm-3 control-label">驳回日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		   <input id="backdate" name="backdate" type="text" class="form-control input-sm" placeholder="请输入驳回日期"  ignore="ignore" />
                   <span class="input-group-addon" >
                       <span class="glyphicon glyphicon-calendar"></span>
                   </span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="hospid" class="col-sm-3 control-label">被驳回医院：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="hospid" name="hospid" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入被驳回医院"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="auditno" class="col-sm-3 control-label">上传编号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="auditno" name="auditno" type="text" maxlength="40" class="form-control input-sm" placeholder="请输入上传编号"  ignore="ignore" />
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
				//驳回日期 日期控件初始化
			    laydate.render({
				   elem: '#backdate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#backdate").val(DateJsonFormat(date,this.format));
				  }
				});
		
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