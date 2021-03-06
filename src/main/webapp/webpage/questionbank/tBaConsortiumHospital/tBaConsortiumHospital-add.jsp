<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医联体下属医院</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="jquery,easyui,tools,bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
<style>
	#hospname{
		width: 100%;
		padding: 6px;
		border: 1px solid #ccc;
	}
	select.input-sm{
		line-height: 20px;
	}

</style>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tBaConsortiumHospitalController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="consid" class="col-sm-3 control-label">联合体：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="consid" type="list" extendJson="{class:'form-control input-sm lineHeight'}"   dictTable="t_ba_medical_consortium" dictField="id" dictText="thename"  hasLabel="false"  title="联合体" defaultVal="${medicalConsortium.id}" readonly="readonly"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="headhospid" class="col-sm-3 control-label">牵头医院：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="headhospid" type="list" extendJson="{class:'form-control input-sm lineHeight'}"   dictTable="t_sh_hospital" dictField="id" dictText="hospname"  hasLabel="false"  title="联合体" defaultVal="${medicalConsortium.headhospid}" readonly="readonly"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="hospid" class="col-sm-3 control-label">基层医院：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="hospid" name="hospid" type="hidden" value="${id}"/>
				<input name="hospname" id="hospname" class="inputxt" value="${hospname}" readonly="readonly" datatype="*" />
				<%-- <input name="roleName22" id="roleName22" class="inputxt"   />--%>
				<t:choose hiddenName="hospid" hiddenid="id" textname="hospname" inputTextname="hospname" url="tBaConsortiumHospitalController.do?hospitals" name="hospList" icon="icon-search" title="医院列表" isclear="true" ></t:choose>
				<%--<input id="hospid" name="hospid" type="text" class="form-control input-sm"  ignore="ignore"  onclick="popupClick(this,'hospname','hospid','hosp_cons')"  />--%>
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