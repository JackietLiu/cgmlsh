<!--thisisid: tShHospital-update -->
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>医院信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="jquery,easyui,tools,bootstrap,bootstrap-table,layer,validform,webuploader,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tShHospitalController.do?doUpdate" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${tShHospitalPage.id}"/>
	 <div class="form-group">
		 <label for="hospname" class="col-sm-3 control-label">医院名称：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="hospname" name="hospname" value='${tShHospitalPage.hospname}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入医院名称"  ignore="ignore" />
			 </div>
		 </div>
	 </div>
	 <%--<div class="form-group">
		 <label for="hospnameeng" class="col-sm-3 control-label">英文名：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="hospnameeng" name="hospnameeng" value='${tShHospitalPage.hospnameeng}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入英文名"  ignore="ignore" />
			 </div>
		 </div>
	 </div>--%>
	 <div class="form-group">
		 <label for="hospnameshort" class="col-sm-3 control-label">简称：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="hospnameshort" name="hospnameshort" value='${tShHospitalPage.hospnameshort}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入简称"  ignore="ignore" />
			 </div>
		 </div>
	 </div>

	 <div class="form-group">
		 <label for="hospcode" class="col-sm-3 control-label">代码：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="hospcode" name="hospcode" value='${tShHospitalPage.hospcode}' type="text" maxlength="40" class="form-control input-sm" placeholder="请输入代码"  datatype="*"  ignore="checked" />
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="hosplevel" class="col-sm-3 control-label">等级：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <t:dictSelect field="hosplevel" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode="hosplevel"  hasLabel="false"  title="等级" defaultVal="${tShHospitalPage.hosplevel}"></t:dictSelect>
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="regcode" class="col-sm-3 control-label">注册码：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="regcode" name="regcode" value='${tShHospitalPage.regcode}' type="text" maxlength="200" class="form-control input-sm" placeholder="请输入注册码"  ignore="ignore" />
			 </div>
		 </div>
	 </div>

	 <div class="form-group">
		 <label for="address" class="col-sm-3 control-label">地址：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="address" name="address" value='${tShHospitalPage.address}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入地址"  ignore="ignore" />
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="regionid" class="col-sm-3 control-label">区域：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <t:dictSelect field="regionid" type="list" extendJson="{class:'form-control input-sm'}"   dictTable="t_s_region" dictField="id" dictText="name" dictCondition="where ((pid = 114) or (id = 114))"  hasLabel="false"  title="区域" defaultVal="${tShHospitalPage.regionid}"></t:dictSelect>
			 </div>
		 </div>
	 </div>

	 <div class="form-group">
		 <label for="tel" class="col-sm-3 control-label">联系人：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="contact" name="contact" value='${tShHospitalPage.contact}' type="text" maxlength="100" class="form-control input-sm" placeholder="请输入医院联系人"  ignore="ignore" required/>
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="tel" class="col-sm-3 control-label">手机号：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="mobileno" name="mobileno" value='${tShHospitalPage.mobileno}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入联系人手机号"  ignore="ignore" required/>
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="tel" class="col-sm-3 control-label">电话：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="tel" name="tel" value='${tShHospitalPage.tel}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入电话"  ignore="ignore" />
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="fax" class="col-sm-3 control-label">传真：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="fax" name="fax" value='${tShHospitalPage.fax}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入传真"  ignore="ignore" />
			 </div>
		 </div>
	 </div>
	 <div class="form-group">
		 <label for="thepercent" class="col-sm-3 control-label">基药占比：</label>
		 <div class="col-sm-7">
			 <div class="input-group" style="width:100%">
				 <input id="thepercent" name="thepercent" value='${tShHospitalPage.thepercent}' type="text" maxlength="5" class="form-control input-sm" placeholder="请输入百分比"  ignore="ignore" />
			 </div>
		 </div>
	 </div>




	<div class="form-group">
		<label for="isactive" class="col-sm-3 control-label">是否在用：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="isactive" type="radio" extendJson="{class:'i-checks'}"  typeGroupCode="isactive"  hasLabel="false"  title="在用" defaultVal="${tShHospitalPage.isactive}"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="logofilename" class="col-sm-3 control-label">图标名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<img src="${tShHospitalPage.logofilename}" height="60" width="60">
				<t:webUploader name="logofilename" outJs="true" auto="true" showImgDiv="filediv_logofilename" pathValues="${tShHospitalPage.logofilename}"></t:webUploader>

				<div style="display: none;" class="form" id="filediv_logofilename"></div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="memo" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="memo" name="memo" value='${tShHospitalPage.memo}' type="text" maxlength="250" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="versionname" class="col-sm-3 control-label">系统版本：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="versionname" name="versionname" value='${tShHospitalPage.versionname}' type="text" maxlength="20" class="form-control input-sm" placeholder="请输入系统版本"  ignore="ignore" />
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