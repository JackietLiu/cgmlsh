<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>联系方式</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,webuploader,bootstrap-form,tools,jquery,easyui"></t:base>
</head>
<style>
    #pic {
        visibility: hidden;
        position: absolute;
    }

</style>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tSCsInfoDController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="mid" name="mid" type="hidden"  value="${addmid}" maxlength="40" class="form-control input-sm" placeholder="请输入mid"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="methodname" class="col-sm-3 control-label">方式类别：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="methodname" type="list" extendJson="{class:'form-control input-sm',onchange:'fnSelect(this)'}"   typeGroupCode="methodname"  hasLabel="false" defaultVal="1" title="方式类别"></t:dictSelect>

			</div>
		</div>
	</div>
	<div class="form-group">
		<label id="select1" for="method" class="col-sm-3 control-label" >电话号码：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="method" name="method" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入方式"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group" id="pic" >
		<label for="picname" class="col-sm-3 control-label">图片：</label>
		<div class="col-sm-7" >
			<div class="input-group" style="width:100%">
                <%--<img src="${tSCsInfoDPage.picname}" height="60" width="60">--%>
				<t:webUploader name="picname" outJs="true" auto="true"   buttonText='添加图片' ></t:webUploader>
                <div class="form" id="filediv_picname"></div>
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
		<label for="memo" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="memo" name="memo" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">是否在用：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="isactive" type="list" extendJson="{class:'form-control input-sm'}" defaultVal="1"  typeGroupCode="isactive"  hasLabel="false"  title="在用"></t:dictSelect>     
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
	//方式与方式类型联动
	function fnSelect(dthis) {
		var isInter = dthis.value;
		//alert(isInter);
		if (isInter == 1) {
			document.getElementById('select1').innerHTML="电话号码：";
			document.getElementById("pic").style.visibility="hidden";
            document.getElementById("pic").style.position="absolute";
		};
		if (isInter == 2) {
			document.getElementById('select1').innerHTML="手机号码：";
			document.getElementById("pic").style.visibility="hidden";
            document.getElementById("pic").style.position="absolute";
		};
		if (isInter == 3) {
			document.getElementById('select1').innerHTML="微信号码：";
			document.getElementById("pic").style.visibility="visible";
            document.getElementById("pic").style.position="relative";
		};
		if (isInter == 4) {
			document.getElementById('select1').innerHTML="QQ号码：";
			document.getElementById("pic").style.visibility="hidden";
            document.getElementById("pic").style.position="absolute";
		};
	}
</script>
</body>
</html>