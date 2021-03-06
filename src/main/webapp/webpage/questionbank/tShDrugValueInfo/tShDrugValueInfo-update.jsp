<!--thisisid: tShDrugValueInfo-update.jsp  -->
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
 <form id="formobj" action="tShDrugValueInfoController.do?doUpdate" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${tShDrugValueInfoPage.id}"/>

	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 合同名称：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="contractname" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.contractname}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 交易场：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="place" type="text" class="form-control" maxlength="50" value = "${tShDrugValueInfoPage.place}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 采购序号：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="buyno" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.buyno}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 评审分组：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="groupname" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.groupname}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 通用名：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="commonname" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.commonname}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 商品名：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="tradename" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.tradename}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 剂型：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="drugform" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.drugform}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 规格：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="gg" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.gg}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 转换比：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="rationnum" type="text" class="form-control" maxlength="10" value = "${tShDrugValueInfoPage.rationnum}"  datatype="n"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 最小包装单位：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="minpcs" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.minpcs}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 包装材质：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="pkccz" type="text" class="form-control" maxlength="50" value = "${tShDrugValueInfoPage.pkccz}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 生产企业全称：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="enterprisename" type="text" class="form-control" maxlength="255" value = "${tShDrugValueInfoPage.enterprisename}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 供应价：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="suppprice" type="text" class="form-control" maxlength="10" value = "${tShDrugValueInfoPage.suppprice}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label" style="padding-top:12px">
				 状态：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <div style="padding-top:12px">
					 <t:dictSelect field="isactive" defaultVal = "${tShDrugValueInfoPage.isactive}" extendJson="{class:'i-checks'}" type="radio" hasLabel="false"  title="状态"  typeGroupCode="isactive" ></t:dictSelect>
				 </div>
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 经销商简称：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="agencyshortname" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.agencyshortname}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 经销商全称：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="agencyname" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.agencyname}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 备注：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="memo" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.memo}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 产品备注：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="drugmemo" type="text" class="form-control" maxlength="20" value = "${tShDrugValueInfoPage.drugmemo}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 批准文号：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="registerno" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.registerno}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 南通入围结果：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="ntresult" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.ntresult}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 江苏入围结果：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="jsresult" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.jsresult}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 国家基药：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="isbasedrug" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.isbasedrug}"  ignore="ignore"  />
			 </div>
		 </div>
	 </div>
	 <div class="bt-item col-md-6 col-sm-6">
		 <div class="row">
			 <div class="col-md-3 col-sm-3 col-xs-3 bt-label">
				 购进单价：
			 </div>
			 <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				 <input name="inprice" type="text" class="form-control" maxlength="100" value = "${tShDrugValueInfoPage.inprice}"  ignore="ignore"  />
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